package com.mavenproject.practice.dairyapp.dao;

import java.util.*;
import com.mavenproject.practice.dairyapp.entities.User;
public interface UserDaoInterface {
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User findById(int id);
	public List<User> findAll();
	public User findByUsername(String username);
}
