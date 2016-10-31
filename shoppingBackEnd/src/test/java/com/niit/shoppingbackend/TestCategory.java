package com.niit.shoppingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCategory {
public static void main(String[] args)
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingbackend.model");
	context.refresh();
	context.getBean("category");
	context.close();
	System.out.println("the instance of object is created");
}

}
