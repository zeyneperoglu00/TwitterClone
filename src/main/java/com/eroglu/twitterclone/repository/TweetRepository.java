package com.eroglu.twitterclone.repository;

import com.eroglu.twitterclone.model.Tweet;
import com.eroglu.twitterclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByUserIn(List<User> userList);

    List<Tweet> findByUser(User user);
}
