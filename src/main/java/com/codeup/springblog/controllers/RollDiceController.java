package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/rollDice")
    public String roll () {
        return ("/roll-dice");
    }

    @PostMapping("/rollDice")
    public String rolled (@RequestParam Integer guess, Model model) {
        Random randomNum = new Random();
        model.addAttribute("randomNum", randomNum.nextInt(6));
        model.addAttribute("guess", guess);
        return "guessPage";
    }

}
