package com.cognizant.di;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectionManager {
ApplicationContext ioc=null;
	public ConnectionManager() {	
 ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public Connection openConnection(){
		DataSource ds=(DataSource)ioc.getBean("ds");
	try {
		Class.forName(ds.getDriver());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Connection con=null;
	try{
		con=DriverManager.getConnection(ds.getDriver(),ds.getUsername(),ds.getPassword());
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return con;
	}

}
