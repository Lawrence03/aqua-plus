package icu.samnyan.aqua.sega.cardmaker.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestControllerAdvice(basePackages = "icu.samnyan.aqua.sega.cardmaker")
public class CardmakerControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CardmakerControllerAdvice.class);


    /**
     * Get the map object from json string
     *
     * @param request HttpServletRequest
     */
    @ModelAttribute
    public Map<String, Object> preHandle(HttpServletRequest request) throws IOException {
        byte[] src = request.getInputStream().readAllBytes();
        String outputString = new String(src, StandardCharsets.UTF_8).trim();
        logger.info("Request " + request.getRequestURI() + ": " + outputString);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(outputString, new TypeReference<>() {
        });
    }

}
