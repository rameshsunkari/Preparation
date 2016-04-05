package com.prac.algos.search;

public class FindElementInMatrix {

	private static boolean searchMatrix(int[][] matrix, int data) {
		boolean found = false;
		int length = matrix.length;
		int width = matrix[0].length;
		
		int start = 0;
		int end = length*width -1;
		
		while(start<=end) {
			int mid = start + (end-start)/2;
			System.out.println(mid);
			
			int x = mid/width;
			int y = mid%width;
			
			if (matrix[x][y] == data) {
				System.out.println(x+"\t"+y);
				return true;
			}
			
			else if (matrix[x][y] > data) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		
		return found;
	}
	
	public static void main(String[] args) {
		int[][] matrix= {{1,2,3,4},{11,12,13,14},{21,22,23,24},{31,32,33,34}};
		System.out.println(searchMatrix(matrix, 23));
	}
}
