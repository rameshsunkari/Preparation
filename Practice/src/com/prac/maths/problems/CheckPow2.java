package com.prac.maths.problems;

public class CheckPow2 {

	public static void main(String[] args) {
		
		int num = 1024;
		boolean isPow2 = checkPow2Recursive(num);
		System.out.println(isPow2);
		isPow2 = checkPow2Bits(num);
		System.out.println(isPow2);

	}

	private static boolean checkPow2Bits(int num) {
		return (num > 0) && ((num & (num-1)) == 0) ;
	}

	private static boolean checkPow2Recursive(int num) {
		boolean isPow2 = true;
		
		while(num > 1) {
			if (num % 2 != 0) {
				isPow2 = false;
				break;
			}
			
			num = num/2;
		}
		return isPow2;
	}

}
