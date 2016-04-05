package com.hackerrank.dp;

import java.util.Scanner;

public class KadanesAlgorithm {
	/* Function to largest continuous sum */
    public int maxSequenceSum(int[] arr)
    {        
        int maxSoFar = arr[0], maxEndingHere = arr[0];
 
        for (int i = 1; i < arr.length; i++)
        {
            /* calculate maxEndingHere */
            if (maxEndingHere < 0)
                maxEndingHere = arr[i];
            else
                maxEndingHere += arr[i];
 
            /* calculate maxSoFar */
            if (maxEndingHere >= maxSoFar)
                maxSoFar = maxEndingHere;
        }
        
        System.out.println(maxEndingHere);
        return maxSoFar;
    }    
    /* Main function */
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kadane Algorithm Test\n");
        /* Make an object of Kadane class */
        KadanesAlgorithm k = new KadanesAlgorithm();
 
        System.out.println("Enter size of array :");
        int N = scan.nextInt();
        /* Accept two 2d matrices */
        System.out.println("Enter "+ N +" elements");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = scan.nextInt();
        int sum = k.maxSequenceSum(arr);
        System.out.println("\nMaximum Sequence sum = "+ sum);
        scan.close();
 
    }
}
