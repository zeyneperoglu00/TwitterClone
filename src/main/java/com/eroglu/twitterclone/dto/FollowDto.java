package com.eroglu.twitterclone.dto;

import com.eroglu.twitterclone.model.FollowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowDto {
    private FollowType followType;
    private long userId;
}