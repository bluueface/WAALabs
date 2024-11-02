package com.waa.labs.repository;

import com.waa.labs.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c JOIN c.post p JOIN p.user u " +
            "WHERE u.id = :userId AND p.id = :postId AND c.id = :commentId")
    Optional<Comment> findCommentByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId);
}
