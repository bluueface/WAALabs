package com.waa.labs.repository;

import com.waa.labs.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser_Name(String userName);

    List<Post> findByUser_Id(Long id);

    List<Post> findByUser_NameContainingIgnoreCase(String text);
}
