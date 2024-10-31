package com.waa.labs;

import com.waa.labs.entity.Post;
import com.waa.labs.entity.User;
import com.waa.labs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerSideApplication {
    private static UserService userService = null;

    @Autowired
    public ServerSideApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerSideApplication.class, args);

        User user = new User();
        user.setName("Aziz");
        Post post1 = new Post();
        post1.setTitle("Help");
        post1.setContent("This is a help");
        Post post2 = new Post();
        post2.setTitle("Advice");
        post2.setContent("This is a advice");
        user.addPost(post1);
        user.addPost(post2);

        userService.createUser(user);
    }

}

