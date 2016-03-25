package com.prac.algos.recursion;

public class ReverseUsingRecursion {

	public static void main(String[] args) {
		int n = 1024;
		 System.out.println(reverse(n));
		reverseMethod(n);
	}

	private static void reverseMethod(int number) {
		if (number < 10) {
			System.out.println(number);
			return;
		} else {
			System.out.print(number % 10);
			// Method is calling itself: recursion
			reverseMethod(number / 10);
		}
	}
	
	private static int reverse(int n) {
		if (n < 10) {
			return n;
		}
		
		return (n % 10) * (int) Math.pow(10, (int) Math.log10(n)) + reverse(n/10);
	}

}
