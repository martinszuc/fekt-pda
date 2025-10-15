package cz.vutbr.feec.pda.hungarian.model;

public class Matrix {
	
	public Column[] columns;
	public Row[] rows;
	
	public Matrix(int[][] data) {
		columns = new Column[data.length];
		rows = new Row[data[0].length]; // must be same as previous
		
		// init rows 
		for (int row = 0; row < data.length; row++) {
			Row r = new Row(data.length, row);
			rows[row] = r; 
		}
		
		// init columns
		for (int col = 0; col < data[0].length; col++) {
			Column c = new Column(data[0].length, col);
			columns[col] = c;
		}
		
		// init items
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data.length; col++) {
				Item item = new Item(data[row][col], rows[row], columns[col]);
				rows[row].setItem(col, item);
				columns[col].setItem(row, item);
			}
		}
	}

	public Row getRow(int index) {
		return rows[index];
	}

	public Column getColumn(int index) {
		return columns[index];
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Matrix[\n");
		for (int r = 0; r < rows.length; r++) {
			for (int c = 0; c < columns.length; c++) {
				Row row = getRow(r);
				Column col = getColumn(c);
				if(row.isRedLine()) {
					sb.append("--");
				} else {
					sb.append("  ");
				}
				if(col.isRedLine()) {
					sb.append("|");
				}
				sb.append(row.getItem(c).getValue());
				if(row.isRedLine()) {
					sb.append("--");
				} else {
					sb.append("  ");
				}
			}
			sb.append(" \n");
		}
		sb.append("]");
		return sb.toString();
	}

	public Item getItem(int row, int column) {
		return rows[row].getItem(column);
	}

	public void setItem(int row, int column, int value) {
		rows[row].getItem(column).setValue(value);
	}

	public void reduceStep1() {
		// TODO Implement this method
	}

	public void reduceStep2() {
		// TODO Implement this method
	}
}
