package com.tweetapp.service;

import com.tweetapp.entity.Tweet;
import com.tweetapp.entity.User;
import com.tweetapp.exception.ValidationException;
import com.tweetapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tweetapp.entity.User.SEQUENCE_NAME;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SequenceGeneratorService service;

	public User findLoginId(String loginId) {
		User user=userRepo.findByLoginId(loginId);
		return user;
	}
	public User register(User userDetails) throws ValidationException
	{
		if(userRepo.findByLoginId(userDetails.getLoginId())!=null)
			throw new ValidationException("Duplicate User");
		if(!userDetails.getPassword().equals(userDetails.getConfirmPassword()))
			throw new ValidationException("Password Mismatching");
		userDetails.setUserId(service.getSequenceNumber(SEQUENCE_NAME));
		return userRepo.save(userDetails);

	}
	public String resetPassword(String loginId,String newPassword)
	{
		User user=userRepo.findByLoginId(loginId);
		if(user==null)
		{
			return "Invalid UserName";
		}
		if(user.getPassword().equals(newPassword))
		{
			return "Old and New Password are same";
		}
		user.setPassword(newPassword);
		userRepo.save(user);
		return "Success";
	}
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public List<Tweet> findTweetOfUser(String loginId)
	{
		User user=userRepo.findByLoginId(loginId);
		if(user==null)
		{
			return null;
		}
		return user.getTweet();
	}
}
