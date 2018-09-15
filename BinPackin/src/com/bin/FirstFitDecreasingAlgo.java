package com.bin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstFitDecreasingAlgo {

	private List<Bin> bins;
	private List<Integer> items;
	private int capacity;
	private int binCounter = 1;
	
	public FirstFitDecreasingAlgo(List<Integer> items, int capacity) {
		super();
		this.items = items;
		this.capacity = capacity;
		this.bins = new ArrayList<>(this.items.size());
	}
	
	public void solveBinPackingProblem() {
		
		Collections.sort(items, Collections.reverseOrder());
		
		if(this.items.get(0) > this.capacity) {
			System.out.println("No feasible Solution");
			return;
		}
		
		// create our first bin
		this.bins.add(new Bin(binCounter,capacity));
		
		for(Integer item : items) {
			
			boolean isOk = false;
			int currentSize = 0 ;
			
			while(!isOk) {
				if(currentSize == this.bins.size()) {
					Bin bin = new Bin ( ++binCounter,capacity);
					bin.put(item);
					bins.add(bin);
					isOk=true;
				}else if ( this.bins.get(currentSize).put(item)) {
					isOk = true;
				}else {
					currentSize++;
				}
			}
		}
		
	}
	
	public void showResults() 
	{
		for(Bin bin: bins)
			System.out.println(bin);
	}

}
