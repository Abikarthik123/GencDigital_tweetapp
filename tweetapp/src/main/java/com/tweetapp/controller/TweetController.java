package com.tweetapp.controller;

import com.tweetapp.entity.Tweet;
import com.tweetapp.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tweet> getAllTweets(){
        return tweetService.getAllTweets();
    }

}
