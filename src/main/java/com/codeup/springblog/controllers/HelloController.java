package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/deimos/{days}")
    @ResponseBody
    public String hello(@PathVariable String days) {
        return "There are  " + days + " until dev day";
    }

    @GetMapping("/deimos")
    @ResponseBody
    public String hello() {
        return "hello";
    }

}
