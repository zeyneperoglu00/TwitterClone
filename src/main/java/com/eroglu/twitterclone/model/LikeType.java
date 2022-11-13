package com.eroglu.twitterclone.model;

import java.util.Arrays;

public enum LikeType {
    LIKE(1), UNLIKE(-1),
    ;

    private int direction;
    LikeType(int direction){
    }

    public static LikeType lookup(Integer direction) {
        return Arrays.stream(LikeType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow();
    }

    public Integer getDirection() {
        return direction;
    }
}
