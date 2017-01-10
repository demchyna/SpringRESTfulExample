package com.softserve.academy.controller;

import com.softserve.academy.model.User;
import com.softserve.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    @ResponseStatus(value = HttpStatus.OK)
//    public User updateUser(@PathVariable int id, @RequestBody User user) {
//        userService.updateUser(id, user);
//        return user;
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void deleteUser(@PathVariable int id) {
//        userService.deleteUser(id);
//    }
//
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    @ResponseBody
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<User> getAllUser() {
//        return userService.getAllUsers();
//    }
}