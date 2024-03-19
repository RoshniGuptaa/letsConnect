package com.chat.service;

import java.util.List;
import java.util.Optional;

import com.chat.exception.UserException;
import com.chat.modal.User;
import com.chat.repository.UserRepository;
import com.chat.request.UpdateUserRequest;

public class UserServiceImplementation implements UserService {

	
	private UserRepository userRepository;
	
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository= userRepository;
	}

	@Override
	public User findUserById(Integer id) throws UserException{
		// TODO Auto-generated method stub
		Optional<User> opt=userRepository.findById(id);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		throw new UserException("User not found with id "+ id);
	}

	@Override
	public User updateUserProfile(String jwt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(Integer userId, UpdateUserRequest req) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
