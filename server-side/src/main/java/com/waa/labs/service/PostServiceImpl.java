package com.waa.labs.service;

import com.waa.labs.entity.Post;
import com.waa.labs.entity.dto.PostDto;
import com.waa.labs.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final LoggerService loggerService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, LoggerService loggerService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.loggerService = loggerService;
    }

    @Override
    public List<PostDto> getAll() {
        return postRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByAuthorName(String author) {
        return postRepository.findByUser_Name(author)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByAuthorId(Long id) {
        return postRepository.findByUser_Id(id)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByTitle(String title) {
        return postRepository.findByTitle(title)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<PostDto> getPostsByAuthorContaining(String text) {
        return postRepository.findByUser_NameContainingIgnoreCase(text)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PostDto> getById(long id) {
        return postRepository.findById(id)
                .map(this::convertToDto);
    }

    @Override
    public Post save(Post post) {
        Post savedPost = postRepository.save(post);
        loggerService.logOperation(String.format("Created post with ID:%d", savedPost.getId()));
        return savedPost;
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
        loggerService.logOperation(String.format("Deleted post with ID:%d", id));
    }


    private PostDto convertToDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

}
