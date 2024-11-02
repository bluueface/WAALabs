package com.waa.labs.service;

import com.waa.labs.entity.Comment;
import com.waa.labs.entity.Post;
import com.waa.labs.repository.CommentRepository;
import com.waa.labs.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Comment addCommentToPost(long postId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.addComment(comment);
        postRepository.save(post);
        return comment;
    }

    @Override
    public Optional<Comment> getCommentByUserIdAndPostIdAndCommentId(long userId, long postId, long commentId) {
        return commentRepository.findCommentByUserIdAndPostIdAndCommentId(userId, postId, commentId);
    }
}
