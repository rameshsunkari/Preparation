package com.prac.algos.arrays.problems;

import java.util.Scanner;

public class Combination {

	public static void main(String[] args) {

		 Scanner scanner = new Scanner(System.in);
	       System.out.print("Enter the row number upto which Pascal's triangle has to be printed: ");
	       int n = scanner.nextInt();
	       int k = scanner.nextInt();
	       
	       System.out.println(calUsingDp(n, k));
	       
	       
	}
	
	   public static int calUsingDp(int n, int k)
		{
			int dp[][] = new int[n+1][k+1];
			for(int i=0; i<=n; i++) {
			 for(int j=0; j<=Math.min(i,k); j++)
			 {
			 	if(j==0 || i==j)
			 	 dp[i][j] = 1;
			 	else
			 	 dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			 }
			}
			/*for(int i=0; i<=n; i++)
			 {
			   for(int j=0; j<=k; j++)
			    System.out.print(dp[i][j]+" "); 
	 
			   System.out.println(); 
			 }*/ 
	 
			 return dp[n][k];
		}


}
