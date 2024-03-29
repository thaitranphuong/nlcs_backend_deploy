package com.nienluancoso;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
public class KeepAliveScheduler {

    // Endpoint keep-alive
    @GetMapping("/keep-alive")
    public String keepAlive() {
        return "Server is alive!";
    }
}
