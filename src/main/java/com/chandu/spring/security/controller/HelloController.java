package com.chandu.spring.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping("/hello")
    public String greet(HttpServletRequest request)
    {
        return "Hello World "+request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request)
    {
        return "chandu "+request.getSession().getId();
    }
}
