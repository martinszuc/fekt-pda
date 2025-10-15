package cz.vutbr.feec.pda.hungarian.model;

public class Item {
	
	private Column column;
	private Row row;
	private int value;

	public Item(int value, Row row, Column column) {
		this.column = column;
		this.row = row;
		this.value = value;
	}

	public Column getColumn() {
		return column;
	}

	public Row getRow() {
		return row;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Item(r=");
		sb.append(getRow().getIndex());
		sb.append(",c=");
		sb.append(getColumn().getIndex());
		sb.append("): ");
		sb.append(value);
		return sb.toString();
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isRedLine() {
		return row.isRedLine() || column.isRedLine();
	}
}
