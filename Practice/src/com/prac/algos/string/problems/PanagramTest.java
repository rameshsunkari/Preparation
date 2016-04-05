package com.prac.algos.string.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PanagramTest {
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	
	String str = sc.nextLine();
	
	boolean isPanagram = isPanagramTestHashMap(str);
	if (isPanagram) {
		System.out.println("pangram");
	} else {
		System.out.println("not pangram");
	}
	
	isPanagram = isPanagramTestArrays(str);
	if (isPanagram) {
		System.out.println("pangram");
	} else {
		System.out.println("not pangram");
	}
	
	sc.close();
}

private static boolean isPanagramTestArrays(String str) {
	str = str.toLowerCase();
	int[] count = new int[26];
	
	for(int i=0;i<count.length;i++) {
		count[i]=0;
	}
	
	char[] strArray = str.toCharArray();
	
	int i=0;
	while(i<strArray.length) {
		if (strArray[i] != ' ' || strArray[i] !='\n') {
			int ch = strArray[i] - 'a';
			count[ch]++;
		}
		i++;
	}
	
	for(i=0;i<count.length;i++) {
		if(count[i]==0) {
			return false;
		}
	}
	
	return true;
}

private static boolean isPanagramTestHashMap(String str) {
	str = str.toLowerCase();
	Map<Integer, Integer> charCountMap = new HashMap<Integer, Integer>();
	
	boolean isPanagram = false;
	if (str == null || str.length() == 0) {
		return isPanagram;
	} 
	
	char[] alphabets = new char[26];
	// fills alphabet array with the alphabet
	 for(char ch = 'a'; ch <= 'z'; ++ch)
     {
         charCountMap.put(ch-'a', 0);
     } 
        
	
	System.out.println(new String(alphabets));
	
	char[] strArray = str.toCharArray();
	
	int i=0;
	while(i<strArray.length) {
		int ch = strArray[i] - 'a';
		
		if (charCountMap.get(ch) != null) {
			int count = charCountMap.get(ch);
			charCountMap.put(ch, count+1);
		} else {
			charCountMap.put(ch, 1);
		}
		
		i++;
	}
	
	for (int alphabet : charCountMap.keySet()) {
		if (charCountMap.get(alphabet) <= 0) {
			isPanagram = false;
			break;
		}
		isPanagram = true;
	}
	
	return isPanagram;
}

}
