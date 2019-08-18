package com.performance;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SizeCalculate {

	public static void main(String[] args) throws IllegalAccessException {
		System.out.println("ss");
//		System.out.println(ObjectSizeCalculator.sizeOf((new Object())));
//		System.out.println(ObjectSizeCalculator.sizeOf(new HashMap<>()));
//		System.out.println(ObjectSizeCalculator.sizeOf(new LinkedHashMap<>()));
//		System.out.println(ObjectSizeCalculator.sizeOf(new ReentrantReadWriteLock()));
//		System.out.println(ObjectSizeCalculator.sizeOf(new byte[1000]));
//		System.out.println(ObjectSizeCalculator.sizeOf(new boolean[1000]));
//		System.out.println(ObjectSizeCalculator.sizeOf(new String("Hello World".toCharArray())));
//		System.out.println(ObjectSizeCalculator.sizeOf("Hello World"));
//		System.out.println(ObjectSizeCalculator.sizeOf(10));
//		System.out.println(ObjectSizeCalculator.sizeOf(20));
//		System.out.println(ObjectSizeCalculator.sizeOf("assa"));
//		System.out.println(ObjectSizeCalculator.sizeOf(new String("assa")));
//		System.out.println(ObjectSizeCalculator.sizeOf(new Kid()));
		System.out.println(ObjectSizeCalculator.sizeOf(new Parent()));
		//System.out.println(ObjectSizeCalculator.sizeOf(new Child()));
		//System.out.println(ObjectSizeCalculator.sizeOf(Thread.State.TERMINATED));
	  }
}

class Parent{
	
	int a =10;
	int b=20;
	String x = "assa";
	String y = new String("assa");
	Kid kid = new Kid();
}

class Child{
	
	int a =10;
	int b=20;
	String x = "assa";
}

class Kid{
	
	
}
