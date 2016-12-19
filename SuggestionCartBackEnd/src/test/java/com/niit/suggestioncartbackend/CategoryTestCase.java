package com.niit.suggestioncartbackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.suggestioncartbackend.dao.CategoryDAO;
import com.niit.suggestioncartbackend.model.Category;


public class CategoryTestCase 
{
	public CategoryTestCase() 
	{
	}
@Autowired
static AnnotationConfigApplicationContext context;

@Autowired
static Category category;

@Autowired(required=true)
static CategoryDAO categoryDAO;

@BeforeClass
@Autowired
public static void init()
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");		
    context.refresh();
    
     categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
     category=(Category)context.getBean("category");
    System.out.println("the object are created");

}
}
