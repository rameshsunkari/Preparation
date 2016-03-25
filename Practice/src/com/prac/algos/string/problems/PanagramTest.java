package com.prac.algos.string.problems;

import java.util.Scanner;

public class PanagramTest {
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	
	String str = sc.nextLine();
	
	boolean isPanagram = isPanagramTest(str);
	if (isPanagram) {
		System.out.println("pangram");
	} else {
		System.out.println("not pangram");
	}
}

private static boolean isPanagramTest(String str) {
	
	boolean isPanagram = false;
	if (str == null || str.length() == 0) {
		return isPanagram;
	} 
	
	char[] alphabets = new char[26];
	for (int i=0;i<26;i++) {
		alphabets[i] = 0;
	}
	
	System.out.println(new String(alphabets));
	
	char[] strArray = str.toCharArray();
	
	int i=0;
	while(i<strArray.length) {
		i++;
		
	}
	
	return isPanagram;
}

}
