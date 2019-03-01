package com.cognizant.beans;

public class Bean1 {

	public Bean1() {
		// TODO Auto-generated constructor stub
	}

	//this class provide infrastructure services for e.g. Security, Tracing, Debugging, performance Monitoring
    //persistence,database operations etc

	//spring bean is infrastructure service class which provide above mentioned infrastructure services	

	//spring bean object life cycle are managed by IOC container(loosely coupled container)

	//information or the configuration required to manage the life cycle of spring bean must 
	//be provided either using XML or annotations

	//method provide some infrastructure services
	public void x(){
		System.out.println("x() calls");
	}
}
