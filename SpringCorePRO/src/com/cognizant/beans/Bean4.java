package com.cognizant.beans;

public class Bean4 {

	public Bean4() {
		// TODO Auto-generated constructor stub
System.out.println("--Bean4 constructor--");
	}
	//initialization method
	//called after constructor completes
public void initMethod(){
	System.out.println("--initMethod()--");
}
//before the ioc container shuts down, destroy method gets calls
public void destroyMethod(){
	System.out.println("--destroyMethod()--");
}

}
