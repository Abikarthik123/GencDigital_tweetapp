package com.tweetapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {


    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private int userId;

    private String image;

    private String firstName;

    private String lastName;

    private String email;

    private String loginId;

    private String password;

    private String confirmPassword;

    private String contactNumber;

    List<Tweet> tweet = new ArrayList<>();

}