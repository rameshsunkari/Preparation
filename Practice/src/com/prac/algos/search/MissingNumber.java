package com.prac.algos.search;

public class MissingNumber {

	public static void main(String[] args) {

		int[] arr = {1, 2,4,6, 3, 7, 8};
		int len = arr.length;
		int missingNum = usingXOR(arr, 8);
		System.out.println(missingNum);
		System.out.println(usingSummation(arr, 8));
		System.out.println(getMissingNo(arr, len));
	}

	private static int usingXOR(int[] arr, int len) {
		int X = 0;
		for (int i=0;i<arr.length;i++) {
			X^=arr[i];
		}

		for(int i=1;i<=len;i++) {
			X^=i;
		}
		return X;
	}
	
	private static int usingSummation(int[] arr, int len) {
		int sum = (len)*(len+1)/2;
		
		for(int i=0;i<arr.length;i++) {
			sum-=arr[i];
		}
		
		return sum;
	}
	
	private static int getMissingNo (int a[], int n){
	    int i, net = n+1;
	    for(i=0; i<n; i++)
	        net += (i+1)-a[i];
	    return net;
	}

}
