package com.waa.labs;

import com.waa.labs.entity.Comment;
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

        User user1 = new User();
        user1.setName("Aziz");

        User user2 = new User();
        user2.setName("Blueface");


        Post post1 = new Post();
        post1.setTitle("Help");
        post1.setContent("This is a help");

        Post post2 = new Post();
        post2.setTitle("Advice");
        post2.setContent("This is a advice");

        Post post3 = new Post();
        post3.setTitle("Tech");
        post3.setContent("This is a tech");

        user1.addPost(post1);
        user1.addPost(post2);
        user2.addPost(post3);

        Comment comment1 = new Comment();
        comment1.setName("comment1");
        Comment comment2 = new Comment();
        comment2.setName("comment2");
        post1.addComment(comment1);
        post2.addComment(comment2);


        userService.createUser(user1);
        userService.createUser(user2);
    }

}

