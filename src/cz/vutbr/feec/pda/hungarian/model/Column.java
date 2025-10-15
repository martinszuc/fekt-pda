package cz.vutbr.feec.pda.hungarian.model;

public class Column extends RowOrColumn {

	public Column(int size, int index) {
		super(size, index);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Column(");
		sb.append(getIndex());
		sb.append(") [ \n");
		for (int i = 0; i < getLength(); i++) {
			sb.append("  ");
			sb.append(getItem(i).getValue());
			sb.append("\n");
		}
		sb.append("]");
		return sb.toString();
	}
}
