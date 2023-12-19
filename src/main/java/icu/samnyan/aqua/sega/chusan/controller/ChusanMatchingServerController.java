package icu.samnyan.aqua.sega.chusan.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * todo
 */
@RestController
@RequestMapping("/ChusanServlet/MatchingServer")
public class ChusanMatchingServerController {

    @PostMapping(value = "Ping")
    String getGameCharge(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\"}";
    }
}
