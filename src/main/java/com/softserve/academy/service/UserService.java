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

    public User getUserById(int id) {
        User user = userDAO.getUserById(id);
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("Resource not found");
        }
    }

    public void updateUser(int id, User newUser) {
        User oldUser = userDAO.getUserById(id);
        if (oldUser != null) {
            newUser.setCreateDate(oldUser.getCreateDate());
            userDAO.updateUser(id, newUser);
        }
    }

    public void deleteUser(int id) {
        int rowCount = userDAO.deleteUser(id);
        if (rowCount == 0) {
            throw new RuntimeException("Resource not found");
        }
    }

    public List<User> getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        if (!users.isEmpty()) {
            return users;
        } else {
            throw new RuntimeException("Resources not found");
        }
    }
}