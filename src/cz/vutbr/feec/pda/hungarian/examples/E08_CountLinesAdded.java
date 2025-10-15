package cz.vutbr.feec.pda.hungarian.examples;

import cz.vutbr.feec.pda.hungarian.model.Item;
import cz.vutbr.feec.pda.hungarian.model.Matrix;
import cz.vutbr.feec.pda.hungarian.model.Row;

public class E08_CountLinesAdded {
	public static void main(String[] args) {
		int[][] data = new int[][] {
			{25, 40, 0}, 
			{0, 0, 20}, 
			{30, 0, 0}
		};
		Matrix m = new Matrix(data);
		
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[0].length; col++) {
				Row r = m.getRow(row);
				Item i = r.getItem(col);
				if(i.getValue() == 0 && !i.isRedLine()) {
					// Solution to the problem
					if(i.getColumn().countZeros() > i.getRow().countZeros()) {
						i.getColumn().setRedLine(true);
					} else {
						i.getRow().setRedLine(true);
					}
				}
			}
		}
		System.out.println(m);
	}
}
