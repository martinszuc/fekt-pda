package cz.vutbr.feec.pda.hungarian.examples;

import cz.vutbr.feec.pda.hungarian.model.Matrix;

public class E02_Step1Reduce {
	public static void main(String[] args) {
		int[][] data = new int[][] {
			{40, 60, 15}, 
			{25, 30, 45}, 
			{55, 30, 25}
		};
		Matrix m = new Matrix(data);
		
		m.reduceStep1(); // TODO
		
		// Prints the whole matrix
		System.out.println(m);
		
	}
}

