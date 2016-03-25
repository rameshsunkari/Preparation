package com.prac.algos.string.problems;

import java.util.Scanner;

public class RemoveAdjacentDuplicates {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] strArray = new String[num];
		for (int i=0;i<num;i++) {
			strArray[i] = sc.next();
		}
		for(int i=0;i<num;i++) {
			System.out.println(removeAdjacentDuplications(strArray[i]));	
		}
		
		
		
		sc.close();
	}

	private static int removeAdjacentDuplications(String str) {
		int numOfDeletions = 0;
		
		int i = 0;
		char[] charArray = str.toCharArray();
		
		while(i<charArray.length-1) {
			if(charArray[i] == charArray[i+1]) {
				numOfDeletions++;
			} 
			i++;
		}
		return numOfDeletions;
	}

}
