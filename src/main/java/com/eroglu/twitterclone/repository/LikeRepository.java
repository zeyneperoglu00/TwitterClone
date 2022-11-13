package com.eroglu.twitterclone.repository;

import com.eroglu.twitterclone.model.LikeAction;
import com.eroglu.twitterclone.model.Tweet;
import com.eroglu.twitterclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<LikeAction, Long> {
    Optional<LikeAction> findTopByTweetAndUserOrderByLikeIdDesc(Tweet tweet, User currentUser);
}
