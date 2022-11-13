package com.eroglu.twitterclone.model;

import java.util.Arrays;

public enum FollowType {
    FOLLOW(1), UNFOLLOW(-1),
    ;

    private int direction;
    FollowType(int direction){
    }

    public static FollowType lookup(Integer direction) {
        return Arrays.stream(FollowType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow();
    }

    public Integer getDirection() {
        return direction;
    }
}
