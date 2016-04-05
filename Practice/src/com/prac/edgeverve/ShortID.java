package com.prac.edgeverve;

import java.util.Arrays;
import java.util.Scanner;

public class ShortID {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input == null ||input.length() == 0) {
			return;
		}
		
		if (!input.contains(" ")) {
			return;
		}
		String[] inputArray = input.split(" ");
		int i =0;
		int num = Integer.parseInt(inputArray[0]);
		int[] longInputs = new int[num];
		while(i<num) {
			longInputs[i] = Integer.parseInt(inputArray[i+1]);
			i++;
		}
		
		int[] resultArray = new int[num];
		boolean found = false;
		int factor = 3;
		while(!found) {
			
			for (int j = 0;j< longInputs.length; j++) {
				resultArray[j] = longInputs[j] % factor; 
			}
			
			Arrays.sort(resultArray);
			for (int k=0;k<resultArray.length-1;k++) {
				if (resultArray[k] == resultArray[k+1]) {
					found = false;
					break;
				} else {
					found = true;
				}
			}
			if (found) {
				break;
			}
			
			factor++;
			
		}
		System.out.println(factor);
		sc.close();
	}

}
