package com.waa.labs.service;

import com.waa.labs.entity.Post;
import com.waa.labs.entity.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostDto> getAll();

    List<PostDto> getPostsByAuthorName(String author);

    List<PostDto> getPostsByAuthorContaining(String text);

    Optional<PostDto> getById(long id);

    Post save(Post post);

    void delete(long id);

    List<PostDto> getPostsByAuthorId(Long id);

    List<PostDto> getPostsByTitle(String title);

}
