package com.prac.algos.arrays.problems;

public class SpiralPrint {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A = { { 1,  2,  3,  4 }, 
					  { 12, 13, 14, 5 }, 
					  { 11, 16, 15, 6 },
					  { 10,  9,  8, 7 } };
		int[][] A1 = { { 1,  12,  3,  4 }, 
				       { 2,  13, 14, 15 }, 
				       { 7,   9,  5, 6 },
				       { 10,  16,  8, 11 } };
		System.out.println(A.length);
		for (int i = 0; i<A.length; i++) {
			System.out.println(A[i].length);
		}
		printSpiral(A); //Prints 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 
		System.out.println();
//		printSpiral(A1);//1, 12, 3, 4, 15, 6, 11, 8, 16, 10, 7, 2, 13, 14, 5, 9, 
		spiralPrint(A, A.length, A[0].length); //Prints 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
		System.out.println();
		printMatrixNonRecursive(A, 4, 4);

	}
	
	public static void spiralPrint(int[][] arr, int m, int n) {
		int rowStart = 0;
		int rowEnd = m-1;
		int colStart = 0;
		int colEnd = n-1;
		
		while (rowStart<=rowEnd && colStart<=colEnd) {
			int i = rowStart, j = colStart;
			
			for (j= colStart; j <=colEnd; j++) {
				System.out.print(arr[i][j] + ",");
			}
			for (i=rowStart+1,j--;i<=rowEnd; i++) {
				System.out.print(arr[i][j] + ",");
			}
			for (j=colEnd-1, i--;j>=colStart;j--) {
				System.out.print(arr[i][j] + ",");
			}
			for (i=rowEnd-1,j++;i>=rowStart+1;i--) {
				System.out.print(arr[i][j] + ",");
			}
			
			rowStart++;
			colStart++;
			rowEnd--;
			colEnd--;
		}
	}
	
	public static void printSpiral(int[][] A) {
		int rowStart = 0;
		int colStart = 0;
		int rowEnd = A.length;
		int colEnd = A[0].length;
		do {
			for (int i = colStart; i < rowEnd; i++) {
				System.out.print(A[rowStart][i] + ", ");
			}
			// current row is done and no more need to process it
			rowStart++;
			for (int i = rowStart; i < colEnd; i++) {
				System.out.print(A[i][colEnd - 1] + ", ");
			}
			// current column is done and no more need to process it
			colEnd--;

			if (rowStart < rowEnd) {
				for (int i = colEnd - 1; i >= colStart; i--) {
					System.out.print(A[rowEnd - 1][i] + ", ");
				}
				rowEnd--;
			}
			if (colStart < colEnd) {
				for (int i = rowEnd - 1; i >= rowStart; i--) {
					System.out.print(A[i][colStart] + ", ");
				}
				colStart++;
			}

		} while (rowStart < rowEnd && colStart < colEnd);
	}
	
	public static void printMatrixNonRecursive(int array[][], int rows, int cols){
	    int nCurrentLevel = 0;
	    int min = (rows < cols) ? rows:cols;
	    
	    while(nCurrentLevel <= min/2){
	        for(int j = nCurrentLevel; j < cols - nCurrentLevel - 1; j++){
	            System.out.print(array[nCurrentLevel][j] + ", ");
	        }
	        for(int i = nCurrentLevel; i < rows - nCurrentLevel - 1; i++) {
	            System.out.print(array[i][cols - nCurrentLevel - 1] + ", ");
	        }
	        for(int j = cols - nCurrentLevel - 1; j > nCurrentLevel; j--){
	            System.out.print(array[rows - nCurrentLevel - 1][j] + ", ");
	        }
	        for(int i = rows - nCurrentLevel - 1; i > nCurrentLevel; i-- ){
	            System.out.print(array[i][nCurrentLevel] + ", ");
	        }
	        nCurrentLevel++;
	    }
	}


}
