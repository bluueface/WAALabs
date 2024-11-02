package com.waa.labs.service;

import com.waa.labs.entity.Comment;

import java.util.Optional;

public interface CommentService {
    Comment addCommentToPost(long postId, Comment comment);

    Optional<Comment> getCommentByUserIdAndPostIdAndCommentId(long userId, long postId, long commentId);
}
