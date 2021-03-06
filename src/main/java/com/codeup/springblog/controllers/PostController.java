package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.ImgRepo;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailServices;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final ImgRepo imgDao;
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailServices emailServices;

    public PostController(ImgRepo imgDao, PostRepository postDao, UserRepository userDao, EmailServices emailServices) {
        this.imgDao = imgDao;
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailServices = emailServices;
    }


    @GetMapping(path = "/post")
    public String post(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "post/index";
    }


    @GetMapping(path = "/post/delete")
    public String postDelete(@RequestParam Long id,
                             @RequestParam String title,
                             @RequestParam String body,
                             Model model) {
        model.addAttribute("id", id);
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        Post updatedPost = new Post(title, body, id);
        postDao.delete(updatedPost);
        return "redirect:/post";
    }

    @GetMapping("/newTest")
    @ResponseBody
    public String postDetails() {
        Post newPost = postDao.getOne(10L);
        return newPost.getPostDetails().getHistoryOfPost();
    }

    @GetMapping("/post/show")
    public String postShow(Model model) {
        model.addAttribute("post", postDao.getOne(4L));
        model.addAttribute("user", userDao.getOne(1L));
        return "post/show";
    }

    @GetMapping("/post/create")
    public String showCreateForm(Model model) {
       model.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping("/post/create")
    public String create(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postDao.save(post);
        emailServices.prepareAndSend(postDao.getOne(1L),"A post has been created", "The email sent");
        return "redirect:/post";
    }

    @GetMapping(path = "/post/{id}/update")
    public String postUpdate(Model model, @PathVariable long id) {
        model.addAttribute("post", postDao.getOne(id));
        return "post/update";
    }

    @PostMapping(path = "/post/{id}/update")
    public String postPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/post";
    }


}
