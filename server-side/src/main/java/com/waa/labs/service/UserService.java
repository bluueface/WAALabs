package com.waa.labs.service;

import com.waa.labs.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    Optional<User> getById(long id);

    User createUser(User user);

    List<User> getUsersWithMoreThanOnePost();
}
