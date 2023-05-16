package com.sep.cinemania.Controller.Swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerRedirectController {
    @GetMapping("/")
    public String handleError() {
        return "redirect:/swagger-ui/index.html#/";
    }
}