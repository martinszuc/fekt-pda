package cz.vutbr.feec.pda.hungarian.examples;

import cz.vutbr.feec.pda.hungarian.model.Matrix;
import cz.vutbr.feec.pda.hungarian.model.RowOrColumn;

public class E05_CountZeros {
	public static void main(String[] args) {
		int[][] data = new int[][] {
			{25, 40, 0}, 
			{0, 0, 20}, 
			{30, 0, 0}
		};
		Matrix m = new Matrix(data);
		RowOrColumn row = m.getRow(1);
		// RowOrColumn row = m.getColumn(1);
		System.out.println(row);
		
		int result = countZeros(row);
		System.out.println("Number of zeors:"+result);
	}

	private static int countZeros(RowOrColumn array) {
		// TODO
		return -1;
	}
}
