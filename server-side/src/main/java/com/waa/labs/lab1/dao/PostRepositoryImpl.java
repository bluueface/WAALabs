package com.waa.labs.lab1.dao;

import com.waa.labs.lab1.entities.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static final List<Post> posts = new ArrayList<>();

    static {
        posts.addAll(List.of(
                new Post(1L, "Help", "Need help!", "Dani Laporte"),
                new Post(2L, "Advice", "Advice to ...", "Lisa McLara"),
                new Post(3L, "Search", "Look for...", "Adam Mello"),
                new Post(4L, "Story", "The story of ...", "Michelle Alex"),
                new Post(5L, "Question", "Can I ....", "Javier Rodri"),
                new Post(6L, "Random", "Random stuff...", "Jhon Lenn")
        ));


    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Optional<Post> findById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst();
    }

    // FIXME
    @Override
    public Post save(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public void delete(Post post) {
        posts.remove(post);
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return posts.stream().filter(post -> post.getAuthor().equalsIgnoreCase(author)).toList();
    }

    @Override
    public List<Post> findByAuthorContaining(String text) {
        return posts.stream().filter(post -> post.getAuthor().toLowerCase().contains(text.toLowerCase())).toList();
    }
}
