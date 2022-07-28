package com.tweetapp.repository;

import com.tweetapp.entity.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, String> {
//    Optional<List<Tweet>> findByUserId(String id);
//    Optional<List<Tweet>> findByUserIdOrderByCreatedAtDesc(String id);
    
}
