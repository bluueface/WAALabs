package com.waa.labs.service;

import com.waa.labs.config.aop.ExecutionTime;
import com.waa.labs.entity.User;
import com.waa.labs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LoggerService loggerService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LoggerService loggerService) {
        this.userRepository = userRepository;
        this.loggerService = loggerService;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @ExecutionTime
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        loggerService.logOperation(String.format("Created user with ID:%d", savedUser.getId()));
        return savedUser;
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
        loggerService.logOperation(String.format("Deleted user with ID:%d", id));
    }

    @Override
    public List<User> getUsersWithMoreThanNPost(int numberOfPosts) {
        return userRepository.findUsersWithMoreThanNPost(numberOfPosts);
    }

    @Override
    public List<User> getUsersByPostTitle(String title) {
        return userRepository.findUsersByPostTitle(title);
    }


}
