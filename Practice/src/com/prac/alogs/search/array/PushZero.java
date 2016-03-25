package com.prac.alogs.search.array;

import java.util.Arrays;

public class PushZero {

	public static void main(String[] args) {
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        int[] arr1 = arr;
        pushZerosToEnd(arr, n);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        pushZeroSingleLoop(arr1, n);
        System.out.println(Arrays.toString(arr1));
        
        int negarr[] = {1, 9, 8, 4, -30, -560, -2, 7, 0, -6, -22, 9};
        arragePosNeg(negarr);
        System.out.println(Arrays.toString(negarr));
        
        String str = "move these spaces to the end";
        moveSpacesToEnd(str);
        moveSpacesToFront(str);
        

	}

	private static void moveSpacesToEnd(String str) {
		
		char[] chararr = str.toCharArray();
		int count = 0;
		
		for (int i = 0; i <chararr.length ; i++) {
			/*if(chararr[i] != ' '){
				chararr[count++] = chararr[i];
			}*/
			if(chararr[i] != ' ') {
				charSwap(chararr, i, count++);
			}
		}
		
		/*while (count < chararr.length) {
			chararr[count++]= ' ';
		}*/
		
		System.out.println(Arrays.toString(chararr));
		
	}
	
	private static void moveSpacesToFront(String str) {
		
		char[] chararr = str.toCharArray();
		int n = chararr.length-1;
		
		for(int i=n;i>=0;i--)
	    {
	        /*if(a[i] != ' ') {
	        	a[count--] = a[i];
	        }*/
			if(chararr[i] != ' ') {
				charSwap(chararr, n--, i);
			}
	    }
	     
	    /*while(count>=0)
	        chararr[count--] = ' ';*/

		System.out.println(Arrays.toString(chararr));
		
	}

	private static boolean isSpace(char c) {
		return c != ' ';
	}

	private static void arragePosNeg(int[] arr) {
		int j=0;
		for (int i = 0; i <arr.length ; i++) {
			if (arr[i] < 0) {
				swap(arr, i, j++);
			}
		}
		
	}

	private static void pushZerosToEnd(int[] arr, int n) {
		int count = 0;
		
		for (int i = 0; i <n ; i++) {
			if (arr[i] !=  0) {
				arr[count++] = arr[i];
			}
		}
		
		while(count < n) {
			arr[count++] = 0;
		}
		
	}
	
	private static void pushZeroSingleLoop(int[] arr, int n) {
		int j=0;
		for (int i = 0; i <n ; i++) {
			if (arr[i] != 0) {
				swap(arr, i, j++);
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
//		System.out.println("Swaping "+arr[i] +" at " + i + " and " + arr[j] + " at " + j);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void charSwap(char[] arr, int i, int j) {
//		System.out.println("Swaping "+arr[i] +" at " + i + " and " + arr[j] + " at " + j);
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
