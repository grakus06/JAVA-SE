package com.m2i.poec.sept15.javse.designpattern.singleton;

public class Singleton {

/*	private static Singleton instance;
	
	private Singleton() {}

	public static Singleton getInstance() {
		if( instance == null) {
			instance = new Singleton();
		}
		
		return instance;
	}*/	
	
	private static Singleton instance = new Singleton();
	
	private Singleton() {}

	public static Singleton getInstance() {
		return instance;
	}
	
	
	public void doSomething() {
		System.out.println("do something...");
	}
	
}
