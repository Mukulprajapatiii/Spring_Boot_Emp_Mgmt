package com.javatechie.javatechie.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthCheck {
    @GetMapping("1")
    public String healthCheck(){
        return "Health Check";
    }
}
