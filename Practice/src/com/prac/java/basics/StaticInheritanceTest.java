package com.prac.java.basics;


class TypeA {
	int a = 10;
	static int b = 1;
	public static void bark() {
		System.out.println("bark in A");
	}
	
	public void woof() {
		System.out.println("woof in A");
	}
}

class TypeB extends TypeA {
	int a = 20;
	static int b = 2;
	public static void bark() {
		System.out.println("bark in B");
	}
	
	public void woof() {
		System.out.println("woof in B");
	}
}
public class StaticInheritanceTest {

	public static void main(String[] args) {

		TypeA a = new TypeA();
		TypeA b = new TypeB();
		TypeB c = new TypeB();
		a.bark();
		b.bark();
		c.bark();
		
		a.woof();
		b.woof();
		c.woof();
		System.out.println(a.a);
		System.out.println(b.a);
		System.out.println(c.a);
		
		
		System.out.println(a.b);
		System.out.println(b.b);
		System.out.println(c.b);
		
		float flot = 2;
		float flotdub = 2.0f;
		
		System.out.println(flot);
		System.out.println(flotdub);
	}

}
