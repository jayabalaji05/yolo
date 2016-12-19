package com.niit.suggestioncartbackend.dao;

import org.springframework.stereotype.Component;

import com.niit.suggestioncartbackend.model.RegisterDetails;

@Component
public interface RegisterDetailsDAO {
public void adduser(RegisterDetails reg);
public RegisterDetails getinfo(String u);

}
