package com.niit.suggestioncartbackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.suggestioncartbackend.model.User;

@Component
public interface UserDAO {
	public boolean save(User user);
	public boolean update(User user);
	public User get(String id);
	public boolean delete(User user);
	public List<User> list();
}
