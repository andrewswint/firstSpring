package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StringTransformController {

        @GetMapping(path = "/string/reverse/{string}")
        @ResponseBody
        public String reverse (@PathVariable String string){
            String reverse = "";
            for (int i = string.length() - 1; i >= 0; i--) {
                reverse += string.charAt(i);
            }
            return reverse;
        }

        @GetMapping(path = "/string/uppercase/{string}")
        @ResponseBody
        public String upper (@PathVariable String string){
            return string.toUpperCase();
        }

        @GetMapping(path = "/string/both/{string}")
        @ResponseBody
        public String reverseCaps (@PathVariable String string){
            return reverse(string).toUpperCase();
        }

        @GetMapping(path = "/string/{string}")
        @ResponseBody
        public String query (
                @PathVariable String string,
        @RequestParam(required = false) boolean reverse,
        @RequestParam(required = false) boolean caps)
        {
            String newString = "";
            if (reverse && caps) {
                return newString = reverse(string).toUpperCase();
            } else if (reverse) {
                return newString = reverse(string);
            } else if (caps) {
                return newString.toUpperCase();
            } else {
                return string;
            }
        }

        @RequestMapping(value = "**")
        @ResponseBody
        public String error () {
            return "unmapped uri";
        }

        @RequestMapping(value = "/wildcard/**")
        @ResponseBody
        public String errorWildcard() {
            return "wildcard uri";
        }

}
