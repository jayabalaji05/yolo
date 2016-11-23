package com.niit.shoppingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCategory {
public static void main(String[] args)
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingbackend.dao");
	context.refresh();
	context.getBean("categoryDAO");
	context.close();
	System.out.println("the instance of object is created");
}

}
