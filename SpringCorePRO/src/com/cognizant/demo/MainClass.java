package com.cognizant.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cognizant.beans.Bean1;
import com.cognizant.beans.Bean2;
import com.cognizant.beans.Bean3;
import com.cognizant.beans.Bean4;
import com.cognizant.beans.Beans5;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //tightly coupled code
		Bean1 b=new Bean1();
		b.x();
	//loosely coupled code
		Resource resource=new ClassPathResource("applicationContext.xml");
		
	//pure IOC container
		//usage of beanfactory is limited to creating instance of spring bean based on configuration info. in XML
		BeanFactory ioc1=new XmlBeanFactory(resource);
		Bean1 bean1=(Bean1)ioc1.getBean("bean1");//dependency injection and downward casting
	    bean1.x();
	    
	    //applicationContext is super set of BeanFactory apart from providing dependency injection
	    //provide services for validation, internationalization, email etc.
	    
	    ApplicationContext ioc2=new ClassPathXmlApplicationContext("applicationContext.xml");
	    Bean1 bean12=(Bean1)ioc2.getBean("bean1");//dependency injection and downward casting
	    bean12.x();
	    
	    Bean1 bean13=(Bean1)ioc2.getBean("bean1");
	    //by default IOC container implement the singleton design pattern
	    //in bean definition by default scope is singleton
	    if(bean12==bean13)
	    	System.out.println("indeed singleton design pattern ");
	    
	
	    //by default singleton bean are eagerly loaded
	    //just run after creating Bean2
	    
	    
	    //after doing lazy-init="true" in applicationContext.xml lazy loading
	    Bean2 bean2=(Bean2)ioc2.getBean("bean2");
	    
	    //prototype bean
	    Bean3 bean31=(Bean3)ioc2.getBean("bean3");
	    Bean3 bean32=(Bean3)ioc2.getBean("bean3");
	if(bean31==bean32)
		System.out.println("will not be printed");
	
	//multiple configuration files in class path
	//assume applicationContext1.xml, applicationContext2.xml
	//ApplicationContext ioc=new ClassPathApplicationContext(new String[]{"applicationContext1.xml","applicationContext2.xml"})
	
	//configuration file outside classpath
	//ApplicationContext ioc3=new FileSystemXmlApplicationContext("C:\\CognizantCofig\\beans.xml");
	//Bean3 bean3=(Bean3)ioc3.getBean("bean3");
	
	AbstractApplicationContext ioc4=new ClassPathXmlApplicationContext("applicationContext.xml");
	//init and destroy methods
	//init method will call automatically as it is eagerly loaded as talked above

	Bean4 bean4=(Bean4)ioc4.getBean("bean4");

	//for destroy method we have to do manually
	ioc4.registerShutdownHook();
	
	
	ApplicationContext ioc5=new ClassPathXmlApplicationContext("applicationContext.xml");
	Beans5 bean5=(Beans5)ioc5.getBean("bean5");
	
    
	

	}

}
