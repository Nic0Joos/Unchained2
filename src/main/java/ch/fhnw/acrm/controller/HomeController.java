package ch.fhnw.acrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// Author: Lennart
@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping
    public String getHomeView(){
        return "home.html";
    }

}
