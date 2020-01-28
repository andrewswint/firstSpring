package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping(path = "/post")
    public String post(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "post/index";
    }

    @GetMapping("/post/show")
    public String postId(Model model) {
        Post testPost = new Post("test1", "test1");
        model.addAttribute("title", testPost.getTitle());
        model.addAttribute("body", testPost.getBody());
        return "post/show";
    }

    @GetMapping(path = "/post/create")
    @ResponseBody
    public String postCreate() {
        return "view the form for creating a post";
    }

//    @PostMapping(path = "/post/create")
//    @ResponseBody
//    public String postPost() {
//        return "create a new post";
//    }

    @GetMapping(path = "/post/update")
    public String postUpdate(@RequestParam String id, @RequestParam String title, @RequestParam String body, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        return "post/update";
    }

    @PostMapping(path="/post/update")
    public String postPost(@RequestParam String id, @RequestParam String title, @RequestParam String body, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        Post updatedPost = new Post(title, body);
        postDao.save(updatedPost);
        return "post/index";
    }

}
