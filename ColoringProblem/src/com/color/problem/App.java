package com.color.problem;

public class App {

	public static void main(String[] args) {
		int [] [] graph = new int[][] {
			{0,1,0,1,0},
			{1,0,1,1,0},
			{0,1,0,1,0},
			{1,1,1,0,1},
			{0,0,0,1,0}
		};
		
		int numberofcolors = 3;
		
		ColorProblem color = new ColorProblem(graph, numberofcolors);
		color.solve();
	}
}
