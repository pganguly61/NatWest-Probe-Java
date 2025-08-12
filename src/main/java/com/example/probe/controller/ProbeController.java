package com.example.probe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.probe.service.ProbeService;

@RestController
@RequestMapping("/api/probe")

public class ProbeController {
    private final ProbeService probeService;
    
    public ProbeController (ProbeService probeService) {
    	this.probeService= probeService;
    }

    @PostMapping("/commands")
    public void sendCommands(@RequestBody String commands) {
        probeService.executeCommands(commands);
    }

    @GetMapping("/state")
    public String getState() {
        return probeService.getState();
    }
}
