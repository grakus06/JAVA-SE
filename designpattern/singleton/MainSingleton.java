package com.m2i.poec.sept15.javse.designpattern.singleton;

public class MainSingleton {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println(instance1 == instance2);
		System.out.println(instance1);
		System.out.println(instance2);
		
		instance1.doSomething();
		instance2.doSomething();
	}
}
