package com.color.problem;

public class ColorProblem {

	private int numberOfvertexes;
	private int numberofcolors;
	private int[] colors;
	private int[][] graph;
	
	public int getNumberOfvertexes() {
		return numberOfvertexes;
	}

	public void setNumberOfvertexes(int numberOfvertexes) {
		this.numberOfvertexes = numberOfvertexes;
	}

	public int getNumberofcolors() {
		return numberofcolors;
	}

	public void setNumberofcolors(int numberofcolors) {
		this.numberofcolors = numberofcolors;
	}

	public int[] getColors() {
		return colors;
	}

	public void setColors(int[] colors) {
		this.colors = colors;
	}

	public int[][] getGraph() {
		return graph;
	}

	public void setGraph(int[][] graph) {
		this.graph = graph;
	}

	public ColorProblem(int[][] graph, int numberofcolors) {
		super();
		this.numberOfvertexes = graph.length;
		this.numberofcolors = numberofcolors;
		this.colors = new int[numberOfvertexes];
		this.graph = graph;
	}

	public void solve() {
		if(solveProblem(0)) {
			displayResult();
		}else
			System.out.println("Cannot be solved!!");
	}

	private boolean solveProblem(int postion) {
		
		if(postion == numberOfvertexes)
			return true;
		
		for(int colorIndex=1;colorIndex<=numberofcolors;colorIndex++) {
			if(isColorValid(postion,colorIndex)) {
				colors[postion] = colorIndex;
				if(solveProblem(postion+1))
					return true;
			}
		}
		
		return false;
	}

	private boolean isColorValid(int postion, int colorIndex) {
		
		for(int i=0;i<numberOfvertexes;i++) {
			if(graph[postion][i] == 1 && colorIndex == colors[i])
				return false;
		}
		return true;
	}

	private void displayResult() {
		for(int i=0;i<numberOfvertexes;i++) {
			System.out.println("Node "+(i+1)+" color is : "+colors[i]);
		}
	}
}
