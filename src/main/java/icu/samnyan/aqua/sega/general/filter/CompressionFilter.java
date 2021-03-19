package icu.samnyan.aqua.sega.general.filter;

import icu.samnyan.aqua.sega.util.AESUtil;
import icu.samnyan.aqua.sega.util.Compression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component
public class CompressionFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(CompressionFilter.class);
    private final List<String> filterList;

    public CompressionFilter() {
        filterList = new ArrayList<>();
        filterList.add("/ChuniServlet");
        filterList.add("/OngekiServlet");
        filterList.add("/MaimaiServlet");
        filterList.add("/Maimai2Servlet");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        logger.debug("Do compress filter");
        String encoding = request.getHeader("content-encoding");
        byte[] reqSrc = request.getInputStream().readAllBytes();

        double maiEncoding = request.getHeader("Mai-Encoding") == null ? 0.00 : Double.parseDouble(request.getHeader("Mai-Encoding"));
        Integer ongekiEncoding = request.getHeader("Ongeki-Encoding") == null ? 0 : Integer.parseInt(request.getHeader("Ongeki-Encoding"));
        Integer chuniEncoding = request.getHeader("Chuni-Encoding") == null || (reqSrc[0] == 0x78 && reqSrc[1] == 0x9C) ? 0 : Integer.parseInt(request.getHeader("Chuni-Encoding"));

        if(maiEncoding >= 1.10) reqSrc = cryptMai(reqSrc, maiEncoding, false);
        if (ongekiEncoding > 0) reqSrc = cryptOngeki(reqSrc, ongekiEncoding, false);
        if (chuniEncoding > 0) reqSrc = cryptChuni(reqSrc, chuniEncoding, false);

        byte[] reqResult;
        if (encoding != null && encoding.equals("deflate")) {
            logger.debug("Request length (compressed): {}", reqSrc.length);
            reqResult = Compression.decompress(reqSrc);
            logger.debug("Request length (decompressed): {}", reqResult.length);
        } else {
            reqResult = reqSrc;
        }

        // Decrypt mai2
        if(maiEncoding == 1.00) reqResult = cryptMai(reqResult, maiEncoding, false);

        CompressRequestWrapper requestWrapper = new CompressRequestWrapper(request, reqResult);
        CompressResponseWrapper responseWrapper = new CompressResponseWrapper(response);

        filterChain.doFilter(requestWrapper, responseWrapper);

        byte[] respSrc = responseWrapper.toByteArray();
        logger.debug("Response length (uncompressed): {}", respSrc.length);

        byte[] respResult = null;

        if(maiEncoding == 1.00) respResult = cryptMai(respSrc, maiEncoding, true);
        else respResult = respSrc;

        respResult = Compression.compress(respResult);
        logger.debug("Response length (compressed): {}", respResult.length);

        if(maiEncoding >= 1.10) respResult = cryptMai(respResult, maiEncoding, true);
        if (ongekiEncoding > 0) respResult = cryptOngeki(respResult, ongekiEncoding, true);
        if (chuniEncoding > 0) respResult = cryptChuni(respResult, chuniEncoding, true);

        response.setContentLength(respResult.length);
        response.setContentType("application/json; charset=utf-8");
        response.addHeader("Content-Encoding", "deflate");

        response.getOutputStream().write(respResult);

    }

    private byte[] cryptMai(byte[] in, double ver, boolean encrypt) {
        try {
            logger.debug((encrypt ? "En" : "De") + "crypt mai2");
            return encrypt ? AESUtil.encrypt(in, ver) : AESUtil.decrypt(in, ver);
        } catch (Exception e) {
            throw new RuntimeException("Mai2 " + (encrypt ? "en" : "de") + "cryption failed", e);
        }
    }

    private byte[] cryptOngeki(byte[] in, Integer ver, boolean encrypt) {
        try {
            logger.debug((encrypt ? "En" : "De") + "crypt ongeki");
            return encrypt ? AESUtil.encrypt_ongeki(in, ver) : AESUtil.decrypt_ongeki(in, ver);
        } catch (Exception e) {
            throw new RuntimeException("Ongeki " + (encrypt ? "en" : "de") + "cryption failed", e);
        }
    }

    private byte[] cryptChuni(byte[] in, Integer ver, boolean encrypt) {
        try {
            logger.debug((encrypt ? "En" : "De") + "crypt chuni");
            return encrypt ? AESUtil.encrypt_chuni(in, ver) : AESUtil.decrypt_chuni(in, ver);
        } catch (Exception e) {
            throw new RuntimeException("Chuni " + (encrypt ? "en" : "de") + "cryption failed", e);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        boolean notFilter = true;
        for (String prefix : filterList) {
            if (path.startsWith(prefix)) {
                notFilter = false;
                break;
            }
        }
        return notFilter;
    }
}
