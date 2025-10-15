package cz.vutbr.feec.pda.hungarian.examples;

import cz.vutbr.feec.pda.hungarian.model.Matrix;

public class E04_Step3StraightLines {
	public static void main(String[] args) {
		int[][] data = new int[][] {
			{25, 40, 0}, 
			{0, 0, 20}, 
			{30, 0, 0}
		};
		Matrix m = new Matrix(data);
		m.getColumn(1).setRedLine(true);
		
		// Prints the whole matrix
		System.out.println(m);
	}
}
