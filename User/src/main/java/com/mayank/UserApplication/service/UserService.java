package com.mayank.UserApplication.service;

import com.mayank.UserApplication.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}
