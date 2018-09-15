package com.bin;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Integer> items = Arrays.asList(10,5,5);
		
		FirstFitDecreasingAlgo algo = new FirstFitDecreasingAlgo(items, 10);
		algo.solveBinPackingProblem();
		algo.showResults();
	}

}
