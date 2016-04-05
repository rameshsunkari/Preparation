package com.prac.algos.search;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingNumber {

	public static void main(String[] args) {
		int[] arr = {10, 5, 3, 4, 3, 5, 6};
		System.out.println(findFirstRepeatingNum(arr));
	}

	private static int findFirstRepeatingNum(int[] arr) {
		// Initialize index of first repeating element
        int min = -1;
 
        // Creates an empty hashset
        Set<Integer> set = new HashSet<Integer>();
 
        // Traverse the input array from right to left
        for (int i=arr.length-1; i>=0; i--)
        {
            // If element is already in hash set, update min
            if (set.contains(arr[i]))
                min = i;
 
            else   // Else add element to hash set
                set.add(arr[i]);
        }
 
        // Print the result
        if (min != -1)
          System.out.println("The first repeating element is " + arr[min]);
        else
          System.out.println("There are no repeating elements");
        return arr[min];
	}

}
