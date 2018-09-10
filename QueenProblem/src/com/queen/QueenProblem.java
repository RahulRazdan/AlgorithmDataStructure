package com.queen;

/**
 * The Class QueenProblem.
 */
public class QueenProblem {

	/** The chess table. */
	int [][] chessTable;
	
	/** The number of queens. */
	int numberOfQueens;
	
	/**
	 * Instantiates a new queen problem.
	 *
	 * @param numberOfQueens the number of queens
	 */
	public QueenProblem(int numberOfQueens) {
		super();
		this.numberOfQueens = numberOfQueens;
		this.chessTable = new int[numberOfQueens][numberOfQueens];
	}
	
	/**
	 * Solve.
	 */
	public void solve() {
		
		if(setQueens(0)) {
			printQueens();
		}else
			System.out.println("There is no solution...");
	}

	/**
	 * Prints the queens.
	 */
	private void printQueens() {
		for(int i=0;i<numberOfQueens;i++) {
			for(int j=0;j<numberOfQueens;j++) {
				
				if(chessTable[i][j] == 1)
					System.out.print(" * ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
	}

	/**
	 * Sets the queens.
	 *
	 * @param colIndex the col index
	 * @return true, if successful
	 */
	private boolean setQueens(int colIndex) {
		
		if( colIndex == numberOfQueens)
			return true;
		
		for(int rowIndex=0;rowIndex<numberOfQueens;rowIndex++) {
			
			
			if(isPlaceValid(rowIndex,colIndex)) {
				chessTable[rowIndex][colIndex] = 1;
				
				if(setQueens(colIndex+1))
					 return true;
			}
			
			// BACKTRACKING
			chessTable[rowIndex][colIndex] = 0;
		}
		return false;
	}

	/**
	 * Checks if is place valid.
	 *
	 * @param rowIndex the row index
	 * @param colIndex the col index
	 * @return true, if is place valid
	 */
	private boolean isPlaceValid(int rowIndex, int colIndex) {
		
		// same row
		for(int i =0;i<colIndex;i++) {
			if(chessTable[rowIndex][i] == 1)
				return false;
		}
		
		// previous row diagonal 
		for(int i=rowIndex,j=colIndex;i>=0 && j>=0;i--,j--) {
			if(chessTable[i][j] == 1)
				return false;
		}
		// next row diagonal
		for(int i=rowIndex,j=colIndex;i<chessTable.length && j>=0;i++,j--) {
			if(chessTable[i][j] == 1)
				return false;
		}
		
		return true;
	}

	
}
