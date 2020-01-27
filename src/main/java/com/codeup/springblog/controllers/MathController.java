package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping(path = "/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @GetMapping(path = "/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @GetMapping(path = "/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @GetMapping(path = "/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        try {
            return num1 + " / " + num2 + " = " + (num1 / num2);
        } catch (ArithmeticException e) {
            System.err.println("Try again exception");
            e.printStackTrace();
            return "Error";
        }
    }

}
