package com.sudoku;

public class Soduko {

	private int [][] soduko;

	public Soduko(int[][] soduko) {
		this.soduko = soduko;
	}
	
	public void solve() {
		if(problemSolve(0,0)) {
			showMatrix();
		}else
			System.out.println("No Solution to SUDOKU");
	}

	private void showMatrix() {
		for(int i=0;i<Constants.BOARD_SIZE;i++) {
			
			if(i%3 == 0) 
				System.out.println(" ");
			
			for(int j=0;j<Constants.BOARD_SIZE;j++) {
				
				if(j%3 == 0) 
					System.out.print(" ");
				
				System.out.print(soduko[i][j] + " ");
			}

			System.out.println();
		}
	}

	private boolean problemSolve(int rowIndex, int columnIndex) {
		
		if(rowIndex == Constants.BOARD_SIZE && ++columnIndex == Constants.BOARD_SIZE) {
			return true;
		}
		
		if(rowIndex==Constants.BOARD_SIZE)
			rowIndex=0;
		
		if(soduko[rowIndex][columnIndex] != 0)
			return problemSolve(rowIndex+1, columnIndex);
		
		for(int number = Constants.MIN;number<=Constants.MAX;number++) {
			
			if(isValid(rowIndex,columnIndex,number)) {
				soduko[rowIndex][columnIndex] = number;
				
				if(problemSolve(rowIndex+1, columnIndex)) {
					return true;
				}
				
				soduko[rowIndex][columnIndex] = 0;
			}
		}
			
		return false;
	}

	private boolean isValid(int rowIndex, int columnIndex, int number) {
		
		for(int i =0;i<Constants.BOARD_SIZE;i++) {
			if(soduko[rowIndex][i] == number)
				return false;
		}
		
		for(int i =0;i<Constants.BOARD_SIZE;i++) {
			if(soduko[i][columnIndex] == number)
				return false;
		}
		
		int rowOffset = (rowIndex/3) * Constants.SMALL_BOARD;
		int columnOffset = (columnIndex/3) * Constants.SMALL_BOARD;
		
		for(int i =0;i<Constants.SMALL_BOARD;i++) {
			for(int j =0;j<Constants.SMALL_BOARD;j++) {
				if(soduko[rowOffset + i][columnOffset + j] == number)
					return false;
			}
			
		}
		return true;
	}

	
}
