package cz.vutbr.feec.pda.hungarian.model;

public class RowOrColumn {
	
	public int countZeros() {
		int numOfZeros = 0;
		for (int i = 0; i < items.length; i++) {
			if(items[i].getValue() == 0) {
				numOfZeros++;
			}
		}
		return numOfZeros;
	}
	
	private Item[] items;
	private int index;
	private boolean redLine;

	public RowOrColumn(int size, int index) {
		this.items = new Item[size];
		this.index = index;
	}
	
	public Item getItem(int index) {
		return items[index];
	}
	
	public void setItem(int index, Item item) {
		this.items[index] = item;
	}
	
	public int getLength() {
		return items.length; 
	}

	public int getIndex() {
		return index;
	}

	public boolean isRedLine() {
		return redLine;
	}

	public void setRedLine(boolean redLine) {
		this.redLine = redLine;
	}
}
