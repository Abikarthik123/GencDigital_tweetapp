package com.tweetapp.service;

import com.tweetapp.entity.Tweet;
import com.tweetapp.entity.User;
import com.tweetapp.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TweetService {
    @Autowired
    private TweetRepository tweetRepo;
    @Autowired
    private UserService userService;

    public List<Tweet> getAllTweets() {
        return tweetRepo.findAll();
    }

//    public Tweet addTweet(String msg, String loginId) {
//        Tweet tweet = new Tweet();
//        User user = userService.findLoginId(loginId);
//        if (user == null) {
//            return null;
//        } else {
//            tweet.setId("1");
//            tweet.setLoginId(loginId);
//            tweet.setContent(msg);
//            tweet.setCreatedAt(Instant.now());
//            List<Tweet> tweetList = user.getTweet();
//            if (tweetList == null) {
//                tweetList = new ArrayList<>();
//            }
//            tweetList.add(tweet);
//            user.setTweet(tweetList);
//            postService.updatePostByComment(targetPost);
//            responseObj.setStatus("success");
//            responseObj.setMessage("success");
//            responseObj.setPayload(inputComment);
//            return responseObj;
//            tweet.setId("1");
//            tweet.setLoginId(loginId);
//            tweet.setContent(msg);
//            tweet.setCreatedAt(Instant.now());
//            return tweetRepo.save(tweet);
//        }
//    public String deleteTweet(String tweetId,String loginId)
//    {
//        Optional<Tweet> tweet=tweetRepo.findById(tweetId);
//        if(tweet.isEmpty())
//        {
//            return "No tweet is Available";
//        }
//        if(tweet.get().getLoginId()!= loginId)
//        {
//            return "you cant delete other Tweet";
//        }
//        tweetRepo.delete(tweet.get());
//        return "success";
//    }

//        public Tweet updateTweet (Tweet updateTweet)
//        {
//            return tweetRepo.save(updateTweet);
//        }
//    }
}
