package com.niit.shoppingbackend;

import static org.junit.Assert.*;

import javax.enterprise.context.Initialized;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.model.Category;

public class CategoryTestCase {public CategoryTestCase() {
	// TODO Auto-generated constructor stub
}
@Autowired
AnnotationConfigApplicationContext context;

@Autowired
Category category;
@Autowired
CategoryDAO categoryDAO;

}
