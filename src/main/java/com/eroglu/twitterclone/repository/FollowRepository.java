package com.eroglu.twitterclone.repository;

import com.eroglu.twitterclone.model.Follow;
import com.eroglu.twitterclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findTopByUser1AndUser2OrderByFollowIdDesc(User currentUser, User followedUser);
}
