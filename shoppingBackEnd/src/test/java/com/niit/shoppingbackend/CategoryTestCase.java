package com.niit.shoppingbackend;

import org.junit.BeforeClass;
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
