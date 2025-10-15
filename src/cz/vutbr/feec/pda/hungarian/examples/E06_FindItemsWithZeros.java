package cz.vutbr.feec.pda.hungarian.examples;

import cz.vutbr.feec.pda.hungarian.model.Matrix;

public class E06_FindItemsWithZeros {
	public static void main(String[] args) {
		int[][] data = new int[][] {
			{25, 40, 0}, 
			{0, 0, 20}, 
			{30, 0, 0}
		};
		Matrix m = new Matrix(data);
		
		// TODO find a column or row with max free zeros
		
	}
}
