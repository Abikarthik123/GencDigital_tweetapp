package com.tweetapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Transient;

import org.springframework.data.annotation.Id;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "post")
public class Tweet {

    @Transient
    public static final String SEQUENCE_NAME = "tweet_sequence";

    @Id
    private String id;

    private String loginId;

    private String content;

    private Instant createdAt;

    List<String> like = new ArrayList<>();

    List<Comment> comment = new ArrayList<>();
}