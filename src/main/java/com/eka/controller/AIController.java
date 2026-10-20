package com.eka.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AIController {

    private final OllamaChatModel model;

    public AIController(OllamaChatModel model) {
        this.model = model;
    }

    @GetMapping("/generate")
    public Map<String, String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", this.model.call(message));
    }

    @GetMapping("/test")
    public String sayHello(){
        return "Hello";
    }
}
