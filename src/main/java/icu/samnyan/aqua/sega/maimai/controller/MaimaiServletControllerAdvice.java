package icu.samnyan.aqua.sega.maimai.controller;

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

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@RestControllerAdvice(basePackages = "icu.samnyan.aqua.sega.maimai")
public class MaimaiServletControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MaimaiServletControllerAdvice.class);

    /**
     * Get the map object from json string
     *
     * @param request HttpServletRequest
     */
    @ModelAttribute
    public Map<String, Object> preHandle(HttpServletRequest request) throws IOException {
        // No need to decode body if GET method
        if (request.getMethod().equalsIgnoreCase("GET")) {
            return null;
        }
        byte[] src = request.getInputStream().readAllBytes();
        String outputString = new String(src, StandardCharsets.UTF_8).trim();
        logger.info("Request {} : {}", request.getRequestURI(), outputString);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(outputString, new TypeReference<>() {
        });
    }
}