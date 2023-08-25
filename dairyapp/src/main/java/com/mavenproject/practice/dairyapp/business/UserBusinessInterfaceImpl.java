package com.mavenproject.practice.dairyapp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mavenproject.practice.dairyapp.dao.UserDaoInterface;
import com.mavenproject.practice.dairyapp.entities.User;
@Component
public class UserBusinessInterfaceImpl implements UserBusinessInterface {
	
	@Autowired
	private UserDaoInterface userDaoInterface;
	
	public void save(User user) {
		// TODO Auto-generated method stub
		userDaoInterface.save(user);
		
		
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		userDaoInterface.update(user);
		
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		userDaoInterface.delete(user);
		
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDaoInterface.findById(id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDaoInterface.findAll();
	}
	
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDaoInterface.findByUsername(username);
	}

	public UserDaoInterface getUserInterface() {
		return userDaoInterface;
	}

	public void setUserInterface(UserDaoInterface userInterface) {
		this.userDaoInterface = userInterface;
	}

	

}
