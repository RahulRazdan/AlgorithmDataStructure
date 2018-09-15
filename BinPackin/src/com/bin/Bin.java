package com.bin;

import java.util.ArrayList;
import java.util.List;

public class Bin {

	private List<Integer> items;
	private int capacity;
	private int currentSize;
	private int id;
	
	public Bin(int id, int capacity) {
		super();
		this.items = new ArrayList<>();
		this.capacity = capacity;
		this.id = id;
	}

	public boolean put(Integer item) {
		
		if(this.currentSize + item > this.capacity) return false;
		
		this.items.add(item);
		this.currentSize+=item;
		
		return true;
	}

	@Override
	public String toString() {
		String string = "Items in Bin [id=" + id + "]";
		for(Integer item : items)
			string+=" "+item;
		return string;
	}
	
	
}
