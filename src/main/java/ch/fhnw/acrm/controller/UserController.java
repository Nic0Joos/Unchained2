package ch.fhnw.acrm.controller;


import ch.fhnw.acrm.business.service.DistanceCalculatorService;
import ch.fhnw.acrm.business.service.LoggerService;
import ch.fhnw.acrm.business.service.UserService;
import ch.fhnw.acrm.data.domain.UnchainedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//Author: Alex
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DistanceCalculatorService distanceCalculatorService;


    @PostMapping(path = "/register")
    public ResponseEntity<Void> postRegister(@RequestBody UnchainedUser unchainedUser) {
        try {
            userService.saveUser(unchainedUser);
            LoggerService.logUser("User: " + unchainedUser.getName() + " was created with Traveldistance: "+ unchainedUser.getTravelDistance());
        } catch (Exception e) {
            LoggerService.logSystem("warning", e.toString());
            new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/profile/edit")
    public ResponseEntity<UnchainedUser> putUser(@RequestBody UnchainedUser unchainedUser) {
        try {
            unchainedUser.setId(userService.getCurrentUser().getId());
            userService.saveUser(unchainedUser);
            LoggerService.logUser("User with ID: " + unchainedUser.getId() + " was updated!");
        } catch (Exception e) {
            LoggerService.logUser("User profile of " + unchainedUser.getId() + " was not changed.");
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/profile/edit", produces = "application/json")
    public @ResponseBody UnchainedUser getProfile() {
        return userService.getCurrentUser();
    }

    @GetMapping(path="/users")
    public List<UnchainedUser> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(path = "/user")
    public String getProfileView() {
        return "customer.html";
    }

    @GetMapping(path = "/register")
    public String getRegisterView(){
        return "register.html";
    }

    @GetMapping(path = "/login")
    public String getLoginView(){
        return "login.html";
    }

    @RequestMapping(value = "/validate", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Void> init() {
        return ResponseEntity.ok().build();
    }

}
