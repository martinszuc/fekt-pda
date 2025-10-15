package cz.vutbr.feec.pda.hungarian.model;

public class Row extends RowOrColumn {

	public Row(int size, int index) {
		super(size, index);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Row(");
		sb.append(getIndex());
		sb.append(") [ ");
		for (int i = 0; i < getLength(); i++) {
			sb.append(getItem(i).getValue());
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}
}
