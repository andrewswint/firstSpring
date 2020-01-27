package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping(path = "/post")
    @ResponseBody
    public String post() {
        return "post index page";
    }
    @GetMapping(path = "/post/{id}")
    @ResponseBody
    public String postId(@PathVariable String id) {
        return "view an individual post";
    }

    @GetMapping(path = "/post/create")
    @ResponseBody
    public String postCreate() {
        return "view the form for creating a post";
    }

    @PostMapping(path = "/post/create")
    @ResponseBody
    public String postPost() {
        return "create a new post";
    }

}
