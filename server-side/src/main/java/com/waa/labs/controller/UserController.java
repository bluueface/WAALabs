package com.waa.labs.controller;

import com.waa.labs.entity.User;
import com.waa.labs.entity.dto.PostDto;
import com.waa.labs.service.PostService;
import com.waa.labs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    @Autowired
    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return userService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUserId(@PathVariable long id) {
        return ResponseEntity.ok(postService.getPostsByAuthorId(id));
    }

    @GetMapping("/with-posts")
    public ResponseEntity<List<User>> getUsersWithMoreThanOnePost() {
        return ResponseEntity.ok(userService.getUsersWithMoreThanOnePost());
    }
}
