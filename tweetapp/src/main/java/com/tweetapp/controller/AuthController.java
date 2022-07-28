package com.tweetapp.controller;

import com.tweetapp.exception.UserNotFoundException;
import com.tweetapp.service.UserService;
import com.tweetapp.util.JwtRequest;
import com.tweetapp.util.JwtResponse;
import com.tweetapp.util.JwtUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @GetMapping("/check")
    public String check(@RequestHeader("Authorization") String authorization) {
        return "Hello World" + authorization;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws UserNotFoundException {
        authenticate(authenticationRequest.getLoginId(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getLoginId());
        final String jwttoken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwttoken));

    }

    private void authenticate(String loginId, String password) throws UserNotFoundException {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginId, password));

        } catch (DisabledException e) {

            throw new UserNotFoundException("USER_DISABLED");
        } catch (BadCredentialsException e) {

            throw new UserNotFoundException("INVALID_CREDENTIALS");
        }
    }

    @GetMapping("/loginId")
    public String getLoginId(@RequestHeader("Authorization") String authorization) {
        String token = authorization.substring(7);
        return jwtTokenUtil.getLoginIdFromToken(token);
    }

}

