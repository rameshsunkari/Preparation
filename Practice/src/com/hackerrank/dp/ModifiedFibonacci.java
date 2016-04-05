package com.hackerrank.dp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ModifiedFibonacci {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int term1 = sc.nextInt();
        int term2= sc.nextInt();
        int num = sc.nextInt();
        
        if (term1 < 0 || term2 <0 || term1+term2>=num) {
            return;
        }
        
        BigInteger[] result = new BigInteger[num];
        result[0] = new BigInteger(String.valueOf(term1));
        result[1] = new BigInteger(String.valueOf(term2));
        for(int i=2;i<num;i++) {
            result[i] = result[i-1].multiply(result[i-1]).add(result[i-2]);
        }
        
        System.out.println(Arrays.toString(result));
        System.out.println(result[num-1]);
        
        /*if (84266613096281243382112 == result[num-1]) {
        System.out.println("passed");	
        }*/
        
        sc.close();
    }

}
