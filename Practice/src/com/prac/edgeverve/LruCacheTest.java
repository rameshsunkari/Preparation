package com.prac.edgeverve;

import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author mayurjain
 * 
 */
public class LruCacheTest {
	private final int maxSize;
	private ConcurrentLinkedQueue<Character> queue = new ConcurrentLinkedQueue<Character>();

	public LruCacheTest(int size) {
		this.maxSize = size;
	}

	public void insertCache(Character data) {
		while (queue.size() >= maxSize) {
			queue.poll();
		}

		queue.add(data);
	}

	public Character getfromCache(Character data) {
		Character dat = null;
		if (queue.contains(data)) {
			queue.remove(data);
			dat = data;
		}
		insertCache(data);
		return dat;
	}

	public void printqueue() {
		for (Character data: queue) {
			System.out.print(data);
		}
		System.out.print(" ");
	}

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
		int n = Integer.parseInt(inputArray[0]);
		String pattern = inputArray[1];
		if (n<=0) {
			return;
		}
		
		
		
		LruCacheTest cache = new LruCacheTest(n);
		
		int i =0;
		while(i<pattern.length()) {
			Character charAti = pattern.charAt(i);
			if (charAti == ' ' || charAti =='\n') {
				continue;
			}
			
			if ('!' == charAti) {
				cache.printqueue();
			} else {
				cache.getfromCache(charAti);
			}
			i++;
		}
		
		sc.close();
/*		cache.getfromCache("mayur");
		cache.getfromCache("sumit");
		cache.getfromCache("amit");
		cache.printqueue();
		cache.getfromCache("sumit");
		cache.printqueue();
		cache.getfromCache("ankit");
		cache.printqueue();*/

	}
}
