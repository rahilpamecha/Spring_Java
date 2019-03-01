package com.cognizant.beans;

public class Beans5 {

	public Beans5() {
		// TODO Auto-generated constructor stub
		System.out.println("--Bean5--");
	}
	//factory method
public static Beans5 createInstance(){
	System.out.println("--createInstance--");
	//Custom instance
	Beans5 bean5=new Beans5();
	return bean5;
}
}
