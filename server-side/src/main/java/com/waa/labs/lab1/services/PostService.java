package com.waa.labs.lab1.services;

import com.waa.labs.lab1.entities.Post;
import com.waa.labs.lab1.entities.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostDto> getAll();

    List<PostDto> getPostsByAuthor(String author);

    List<PostDto> getPostsByAuthorContaining(String text);
    
    Optional<PostDto> getById(long id);

    Post save(Post post);

    void delete(long id);
}
