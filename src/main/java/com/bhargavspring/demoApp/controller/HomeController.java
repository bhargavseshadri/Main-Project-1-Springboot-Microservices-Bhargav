package com.bhargavspring.demoApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller marks this class as one that handles web requests.
@Controller  //Here we can use @RestController as well and skip the method level @ResponseBody
public class HomeController {

    // @ResponseBody sends the returned text directly in the web response.
    // Without it, Spring would treat the returned String as a page name.
    @GetMapping("/")
    @ResponseBody
    public String greet() {
        return "Hi, Printing from HomeController.java";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "We don't teach, we Educate!!";
    }
}


