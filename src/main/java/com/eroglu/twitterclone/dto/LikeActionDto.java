package com.eroglu.twitterclone.dto;

import com.eroglu.twitterclone.model.LikeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeActionDto {
    private LikeType likeType;
    private long tweetId;
}
