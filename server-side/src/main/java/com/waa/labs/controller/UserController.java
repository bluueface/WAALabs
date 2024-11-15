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
@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<List<User>> getUsersWithMoreThanNPost(@RequestParam int numberOfPosts) {
        return ResponseEntity.ok(userService.getUsersWithMoreThanNPost(numberOfPosts));
    }

    @GetMapping("/post-title")
    public ResponseEntity<List<User>> getUsersByPostTitle(@RequestParam String title) {
        return ResponseEntity.ok(userService.getUsersByPostTitle(title));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") long id) {
        if (userService.getById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // localhost:8080/api/v1/users/111/posts/1/comments/1

}
