package ch.fhnw.acrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Author: Lennart
@Controller
@RequestMapping(path = "/about")
public class AboutUsController {

    @GetMapping
    public String getIndexView(){
        return "about-us.html";
    }

}
