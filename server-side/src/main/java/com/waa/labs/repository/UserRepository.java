package com.waa.labs.repository;

import com.waa.labs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE SIZE(u.posts) >= :numberOfPosts")
    List<User> findUsersWithMoreThanNPost(int numberOfPosts);

    @Query("SELECT u FROM User u JOIN u.posts p WHERE LOWER(p.title) = LOWER(:title)")
    List<User> findUsersByPostTitle(String title);

    Optional<User> findByEmail(String username);
}
