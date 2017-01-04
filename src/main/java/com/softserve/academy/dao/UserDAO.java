package com.softserve.academy.dao;

import com.fasterxml.jackson.core.JsonParseException;
import com.softserve.academy.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
public class UserDAO {

    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserById(Integer id) {
        return users.stream().filter(item -> item.getId().equals(id)).findFirst().get();
    }

    public void updateUser(User oldUser, User newUser) {
        users.set(users.indexOf(oldUser), newUser);
    }

    public void deleteUser(User user) {
        users.remove(users.indexOf(user));
    }

    public List<User> getAllUsers() {
        return users;
    }
}

