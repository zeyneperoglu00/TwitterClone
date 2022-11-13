package com.eroglu.twitterclone.service;

import com.eroglu.twitterclone.dto.LikeActionDto;
import com.eroglu.twitterclone.exceptions.TwitterException;
import com.eroglu.twitterclone.model.Tweet;
import com.eroglu.twitterclone.repository.LikeRepository;
import com.eroglu.twitterclone.repository.TweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.eroglu.twitterclone.model.LikeType.LIKE;

@Service
@AllArgsConstructor
public class LikeAction {

    private final TweetRepository tweetRepository;
    private final AuthService authService;
    private final LikeRepository likeRepository;

    @Transactional
    public void likeAction(LikeActionDto likeActionDto) {
        Tweet tweet = tweetRepository.findById(likeActionDto.getTweetId()).
                orElseThrow();
        Optional<com.eroglu.twitterclone.model.LikeAction> likeActionByTweetAndUser = likeRepository.findTopByTweetAndUserOrderByLikeIdDesc(tweet, authService.getCurrentUser());

        if (likeActionByTweetAndUser.isPresent() &&
                likeActionByTweetAndUser.get().getLikeType()
                        .equals(likeActionDto.getLikeType())) {
            throw new TwitterException("You have already "
                    + likeActionDto.getLikeType() + "'d for this post");
        }
        if (LIKE.equals(likeActionDto.getLikeType())) {
            tweet.setLikeCount(tweet.getLikeCount() + 1);
        } else {
            if(!likeActionByTweetAndUser.isPresent()) {
                throw new TwitterException("You need to Like a Tweet first to Unlike");
            }
            tweet.setLikeCount(tweet.getLikeCount() - 1);
        }
        likeRepository.save(mapToLikeAction(likeActionDto, tweet));
        tweetRepository.save(tweet);
    }

    private Object getLikeType() {
        return null;
    }

    private LikeAction mapToLikeAction(LikeActionDto likeActionDto, Tweet tweet) {
        return LikeAction.builder()
                .likeType(likeActionDto.getLikeType())
                .tweet(tweet)
                .user(authService.getCurrentUser())
                .build();
    }

    private static Object builder() {
        return null;
    }
}