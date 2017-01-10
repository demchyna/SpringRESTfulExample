package com.softserve.academy.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.softserve.academy.dao.UserDAO;
import com.softserve.academy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }

    public void updateUser(int id, User newUser) {
        User oldUser = userDAO.getUserById(id);
        if (oldUser != null) {
            userDAO.updateUser(id, newUser);
        }
    }

//    public void deleteUser(int id) {
//        User user = getUserById(id);
//        if (user != null) {
//            userDAO.deleteUser(user);
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> users = userDAO.getAllUsers();
//        if (!users.isEmpty()) {
//            return users;
//        } else {
//            return null;
//        }
//    }
}
