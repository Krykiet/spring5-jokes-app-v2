package com.spring5.spring5jokesappv2.controllers;

import com.spring5.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    //This is JokeServiceImpl because we annotated it with @Service for Spring
    private final JokeService jokeService;

    //single constructor in controller may be omitted
    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/",""})
    // Model is interface, "M" in MVC
    public String showJoke(Model model) {
        // joke is property of the model joke, gets inserted into thymeleaf template in p tag
        // <p th:text="${joke}"> Joke here</p>
        model.addAttribute("joke", jokeService.getJoke());
        // This tells thymeleaf to search for index in templates
        return "index";
    }
}
