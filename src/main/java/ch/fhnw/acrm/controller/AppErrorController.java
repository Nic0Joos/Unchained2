package ch.fhnw.acrm.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

//Author: Luca
@Controller
public class AppErrorController implements ErrorController {


    @RequestMapping("/error")
    public String renderErrorPage(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            switch (statusCode) {
                case 403:
                    return "403.html";
                case 404:
                    return "404.html";
            }
        }
        return "login";
    }

}
