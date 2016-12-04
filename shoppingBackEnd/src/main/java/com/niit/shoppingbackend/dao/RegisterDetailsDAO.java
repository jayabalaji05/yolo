package com.niit.shoppingbackend.dao;

import org.springframework.stereotype.Component;

import com.niit.shoppingbackend.model.RegisterDetails;

@Component
public interface RegisterDetailsDAO {
public void adduser(RegisterDetails reg);
public RegisterDetails getinfo(String u);

}
