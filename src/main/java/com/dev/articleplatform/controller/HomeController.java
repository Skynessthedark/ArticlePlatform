package com.dev.articleplatform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getHomePage() {
        return "Welcome To Article Platform";
    }
}
