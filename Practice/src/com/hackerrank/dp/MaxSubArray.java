package com.hackerrank.dp;

import java.util.Scanner;

public class MaxSubArray {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int numOfTestCases = sc.nextInt();
        
        for (int i=0;i<numOfTestCases;i++) {
            int size = sc.nextInt();    
            int[] arr = new int[size];
            for (int j=0;j<size;j++) {
                arr[j] = sc.nextInt();
            }
            
            int maxPosSum = Integer.MIN_VALUE;int possum = 0;int negsum=0;
            int maxNegSum = Integer.MIN_VALUE;
            for (int k=0;k<size;k++) {
                if (arr[k] > 0) {
                    possum = Math.max(possum+arr[k], arr[k]);
                    maxPosSum = Math.max(possum, maxPosSum);    
                }
                
                negsum = Math.max(negsum+arr[k], arr[k]);
                maxNegSum = Math.max(negsum, maxNegSum);    
                
                
            }
            System.out.print(maxNegSum + " ");
            System.out.print(maxPosSum);
        }
    }
}
