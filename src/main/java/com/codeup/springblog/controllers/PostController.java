package com.codeup.springblog.controllers;

import com.codeup.springblog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping(path = "/post")
    public String post(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(1,"title1", "body1");
        Post post2 = new Post(2,"title2", "body2");
        Post post3 = new Post(3,"title3", "body3");
        posts.add(0, post1);
        posts.add(1, post2);
        posts.add(2, post3);
        model.addAttribute("posts", posts);
        return "post/index";
    }

    @GetMapping("/post/show")
    public String postId(Model model) {
        Post testPost = new Post(1, "test1", "test1");
        model.addAttribute("title", testPost.getTitle());
        model.addAttribute("body", testPost.getBody());
        return "post/show";
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
