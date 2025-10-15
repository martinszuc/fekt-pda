package cz.vutbr.feec.pda.hungarian.examples;

import cz.vutbr.feec.pda.hungarian.model.Matrix;

public class E03_Step2Reduce {
	public static void main(String[] args) {
		int[][] data = new int[][] {
			{25, 45, 0}, 
			{0, 5, 20}, 
			{30, 5, 0}
		};
		Matrix m = new Matrix(data);
		
		m.reduceStep2(); // TODO
		
		// Prints the whole matrix
		System.out.println(m);
		
	}
}

