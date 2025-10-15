package cz.vutbr.feec.pda.hungarian.examples;

import cz.vutbr.feec.pda.hungarian.model.Matrix;

public class E01_Matrix {
	public static void main(String[] args) {
		int[][] data = new int[][] {
			{4, 3, 3}, 
			{6, 4, 5}, 
			{7, 7, 5}
		};
		Matrix m = new Matrix(data);
		// Prints the whole matrix
		System.out.println(m);
		
		// Prints row (index starts from 0)
		System.out.println(m.getRow(2));
		
		// Prints column (index starts from 0)
		System.out.println(m.getColumn(0));
		
		// Prints item (starts from 0,0)
		System.out.println(m.getItem(0, 0));
		
		m.setItem(1,3, 10);
	}
}

