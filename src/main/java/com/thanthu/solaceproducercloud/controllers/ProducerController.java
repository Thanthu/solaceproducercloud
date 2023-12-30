package com.thanthu.solaceproducercloud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/message")
public class ProducerController {

    private final StreamBridge streamBridge;

    @PostMapping
    public String sendMessage(@RequestBody Map<String, String> request) {
        streamBridge.send("queuename", request.get("message"));
        return "success";
    }

}
