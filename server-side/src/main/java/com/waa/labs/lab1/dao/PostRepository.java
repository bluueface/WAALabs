package com.waa.labs.lab1.dao;

import com.waa.labs.lab1.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<Post> findAll();

    Optional<Post> findById(long id);

    Post save(Post post);

    void delete(Post post);

    List<Post> findByAuthor(String author);

    List<Post> findByAuthorContaining(String text);

}
