package com.eroglu.twitterclone.controller;

import com.eroglu.twitterclone.dto.FollowDto;
import com.eroglu.twitterclone.dto.LikeActionDto;
import com.eroglu.twitterclone.service.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/follow")
@AllArgsConstructor
public class FollowController {
    private final FollowService followService;

    @PostMapping
    public ResponseEntity<Void> follow(@RequestBody FollowDto followDto){
        followService.follow(followDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
