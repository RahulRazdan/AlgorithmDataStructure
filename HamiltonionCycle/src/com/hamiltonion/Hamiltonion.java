package com.hamiltonion;

public class Hamiltonion {

	private int [] hamiltonionPath;
	private int [] [] hamiltonionGraph;
	private int numberOfVertexes;
	
	public Hamiltonion(int [][] hamiltonionGraph) {
		this.hamiltonionGraph = hamiltonionGraph;
		this.numberOfVertexes = hamiltonionGraph.length;
		this.hamiltonionPath = new int [hamiltonionGraph.length];
		this.hamiltonionPath[0] = 0;
		
	}

	public void solve() {
		if(hamiltonionGraphExist(1))
			printHamiltonionGraph();
		else
			System.out.println(" Cannot find hamiltonion graph");
	}

	private void printHamiltonionGraph() {
		for(int i=0;i<hamiltonionPath.length;i++)
				System.out.print(hamiltonionPath[i] + " ");
		
		System.out.print(hamiltonionPath[0]);
	}

	private boolean hamiltonionGraphExist(int position) {
		
		if(position == numberOfVertexes) {
			if(hamiltonionGraph[hamiltonionPath[position-1]][hamiltonionPath[0]] == 1)
				return true;
			else
				return false;
		}
		
		for(int vertexIndex =1 ; vertexIndex<numberOfVertexes;++vertexIndex) {
			if(isFeasible(vertexIndex,position)) {
				hamiltonionPath[position] = vertexIndex;
				
				if(hamiltonionGraphExist(position+1))
					return true;
			}
		}
		return false;
	}

	private boolean isFeasible(int vertexIndex, int position) {
		
		if(hamiltonionGraph[hamiltonionPath[position-1]][vertexIndex] == 0)
			return false;
		
		for(int i=0;i<position;i++) {
			if(hamiltonionPath[i] == vertexIndex)
				return false;
		}
		
		return true;
	}

}
