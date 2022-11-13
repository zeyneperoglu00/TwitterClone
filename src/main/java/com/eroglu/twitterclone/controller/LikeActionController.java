package com.eroglu.twitterclone.controller;

import com.eroglu.twitterclone.dto.LikeActionDto;
import com.eroglu.twitterclone.service.LikeAction;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/likeaction")
@AllArgsConstructor
public class LikeActionController {
    private final LikeAction likeActionService;

    @PostMapping
    public ResponseEntity<Void> likeAction(@RequestBody LikeActionDto likeActionDto){
        likeActionService.likeAction(likeActionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
