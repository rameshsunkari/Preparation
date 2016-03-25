package com.prac.java.basics;

class A {
static int i = 1111;
static {
	System.out.println("1." + i);
	i = i-- - --i;
	System.out.println("1." + i);
} 
{
	System.out.println("2." + i);
	i = i++ + ++i;
	System.out.println("2." + i);
}
}

class B extends A {
static {
	System.out.println("3." + i);
	i = --i - i-- ;
	System.out.println("3." + i);
} 
{
	System.out.println("4." + i);
	i = ++i + i++;
	System.out.println("4." + i);
}
}

public class IncrementDecrementTest {

	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.i);

	}

}
