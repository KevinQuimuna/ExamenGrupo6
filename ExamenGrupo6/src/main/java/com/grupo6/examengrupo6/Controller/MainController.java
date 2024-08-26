package com.grupo6.examengrupo6.Controller;

import org. springframework. stereotype. Controller;
import org.springframework.web.bind. annotation. GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String showHomePage() {
        System.out.println("Hello from main controller");
        return "index";
    }
}