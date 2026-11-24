package com.bhargavspring.demoApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController combines @Controller and @ResponseBody.
// Its methods send their returned values directly in the web response.
@RestController
class HomeRestController {

    @GetMapping("/api/home")
    public String home() {
        return "Hello from a RestController";
    }
}
