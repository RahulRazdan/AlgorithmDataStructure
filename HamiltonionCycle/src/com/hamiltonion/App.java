package com.hamiltonion;

public class App {

	public static void main(String[] args) {
		
		int [][] hamiltonionGraph = {
				{0,1,1,1,0,0},
				{1,0,1,0,1,0},
				{1,1,1,1,0,1},
				{1,0,1,0,0,1},
				{0,1,0,0,0,1},
				{0,1,1,1,1,1},
		};
		
		Hamiltonion ham = new Hamiltonion(hamiltonionGraph);
		ham.solve();
	}
}
