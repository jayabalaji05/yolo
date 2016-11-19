package com.niit.shoppingbackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.model.Category;


public class CategoryTestCase 
{
	public CategoryTestCase() 
	{
	}
@Autowired
static AnnotationConfigApplicationContext context;

@Autowired
static Category category;
@Autowired
static CategoryDAO categoryDAO;

@BeforeClass
public static void init()
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");		
    context.refresh();
    
    CategoryDAO categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
    Category category=(Category) context.getBean("category");
    System.out.println("the object are created");

}

@Test
public void createCategoryTestCase()
{
	category.setId("MOB_07");
	category.setDescription("Mobile Category");
	category.setName("mobile Category for u");
	Boolean status =categoryDAO.save(category);
	Assert.assertEquals("createCategoryTestCase",true, status);
}
}
