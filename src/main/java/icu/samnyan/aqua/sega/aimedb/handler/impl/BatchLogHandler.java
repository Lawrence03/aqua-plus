package icu.samnyan.aqua.sega.aimedb.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.aimedb.handler.BaseHandler;
import icu.samnyan.aqua.sega.aimedb.util.AimeDbUtil;
import icu.samnyan.aqua.sega.aimedb.util.LogMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component
public class BatchLogHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(BatchLogHandler.class);

    private final LogMapper logMapper;

    @Autowired
    public BatchLogHandler(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    @Override
    public void handle(ChannelHandlerContext ctx, ByteBuf msg) throws JsonProcessingException {
        Map<String, Object> requestMap = AimeDbUtil.getBaseInfo(msg);

        long logLength = msg.getUnsignedIntLE(992);
        List<BatchLogItem> batchLogItems = new ArrayList<>();
        for (int i = 0; i < logLength; i++) {
            batchLogItems.add(new BatchLogItem(
                    msg.getUnsignedIntLE(32 + 48 * i),
                    msg.getIntLE(32 + 48 * i + 32),
                    msg.getIntLE(32 + 48 * i + 40),
                    msg.getIntLE(32 + 48 * i + 44)
            ));
        }

        requestMap.put("type", "batch_log");
        requestMap.put("logLength", logLength);
        if (!batchLogItems.isEmpty()) {
            requestMap.put("log", batchLogItems);
        }

        logger.info("Request: " + logMapper.write(requestMap));

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", "batch_log");
        resultMap.put("status", 1);
        resultMap.put("logLength", logLength);

        logger.info("Response: " + logMapper.write(resultMap));

        ByteBuf respSrc = Unpooled.copiedBuffer(new byte[0x0040]);
        respSrc.setShortLE(0x0004, 0x0014);
        respSrc.setShortLE(0x0008, (int) resultMap.get("status"));
        for (int i = 0; i < logLength; i++) {
            respSrc.setByte(0x0020 + i, 0x0001);
        }

        ctx.writeAndFlush(respSrc);
    }

    @AllArgsConstructor
    @Data
    public static class BatchLogItem implements Serializable {
        private static final long serialVersionUID = 1L;

        private long userId;
        private int playAt;
        private int playId;
        private int placeId;
    }
}
