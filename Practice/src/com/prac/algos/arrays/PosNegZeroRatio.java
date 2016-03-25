package com.prac.algos.arrays;

import java.util.Scanner;

public class PosNegZeroRatio {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 6;
        int arr[] = {-4, 3, -9, 0, 4, 1};
        float pos = 0;
        float neg = 0;
        float zeros = 0;
        /*for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }*/
        
        for (int arr_i=0; arr_i<n;arr_i++) {
            if (arr[arr_i] > 0) {
                pos+=1;
            } else if (arr[arr_i] < 0) {
                neg+=1;
            } else {
                zeros+=1;
            }
        }
        
        float positive = pos/n;
        float negative = neg/n;
        float zero = zeros/n;
        
        System.out.println(positive);
        System.out.println(negative);
        System.out.println(zero);
    }
}
