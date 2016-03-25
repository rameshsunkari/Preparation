package com.prac.alogos.divideconquer.problems;

public class PowerNLongN {

	private static int count1;
	private static int count2;
	public static void main(String[] args) {
		int a = 4;
		int b = 3;
		float result = power(a, b);
		if (b < 0) {
			result =  1 / power(a, -b);
		} else {
			result =  power(a, b);
		}
		System.out.println(result + "hits:" + count1);
		System.out.println(normalPow(a, b) + "hits:" + count2);
	}

	private static float power(int a, int b) {
		
		count1++;
		if (b ==0 ) {
			return 1;
		}
		float temp = power (a, b/2);
		if (b %2 == 0) {
			return temp*temp;
		} else {
			return a * temp * temp;
		}
		
	}
	
	private static float normalPow(int a, int b) {
		if (b==0) {
			return 1;
		}
		
		float result = 1;
		
		if (b > 0) {
		for (int i = 0; i < b; i++) {
			result = result * a;
			count2++;
		}
		} else {
			for (int i = 0; i < Math.abs(b); i++) {
				result = result / a;
				count2++;
			}	
		}
		
		return result;
	}

}
