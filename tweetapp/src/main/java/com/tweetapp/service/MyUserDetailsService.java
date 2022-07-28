package com.tweetapp.service;

import com.tweetapp.entity.User;
import com.tweetapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User u=userRepo.findByLoginId(loginId);
        if(u==null)
            throw new UsernameNotFoundException("user not found!!");

        return new MyUserDetails(u);
    }
 
}