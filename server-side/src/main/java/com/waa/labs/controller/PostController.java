package com.waa.labs.controller;

import com.waa.labs.entity.Post;
import com.waa.labs.entity.dto.PostDto;
import com.waa.labs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(required = false) String authorName,
            @RequestParam(required = false) String text
    ) {
        if (authorName != null) {
            return ResponseEntity.ok(postService.getPostsByAuthorName(authorName));
        } else if (text != null) {
            return ResponseEntity.ok(postService.getPostsByAuthorContaining(text));
        } else {
            return ResponseEntity.ok(postService.getAll());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id) {
        return postService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") long id) {
        if (postService.getById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
