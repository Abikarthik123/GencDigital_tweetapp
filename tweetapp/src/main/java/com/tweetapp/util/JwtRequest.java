package com.tweetapp.util;

import lombok.Data;

@Data
public class JwtRequest {

	private String loginId;
	private String password;
}