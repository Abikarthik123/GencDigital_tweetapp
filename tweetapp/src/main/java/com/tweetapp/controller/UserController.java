package com.tweetapp.controller;

import com.tweetapp.entity.Tweet;
import com.tweetapp.entity.User;
import com.tweetapp.exception.ValidationException;
import com.tweetapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthController auth;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User registerUser(@RequestBody User userDetail) throws ValidationException
    {
        return userService.register(userDetail);
    }

    @PostMapping("/{loginId}/forgot")
    public String registerUser(@PathVariable String loginId,@RequestParam String newPassword)
    {
        return userService.resetPassword(loginId,newPassword);
    }
    @GetMapping(value="/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser(@RequestHeader("Authorization") String authorization){
        String userId=auth.getLoginId(authorization);
       return userService.getAllUsers();
    }

    @GetMapping(value="/user/search/{loginId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User searchUserName(@RequestHeader("Authorization") String authorization,@PathVariable String loginId)
   {
       String userId=auth.getLoginId(authorization);
       return userService.findLoginId(loginId);
   }

    @GetMapping(value="/{loginId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tweet> getTweetOfUser(@RequestHeader("Authorization") String authorization, @PathVariable String loginId)
    {
        return userService.findTweetOfUser(loginId);
    }
}

