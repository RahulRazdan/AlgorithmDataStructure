package com.knight;

public class Knight {

	private int[][] chessBoard;

	private int[] xMoves = { 2, 1,-1,-2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
	private static final int CHESS_SIZE = 8;
	private static final int NUM_OF_MOVES = 8;

	public Knight() {
		this.chessBoard = new int[CHESS_SIZE][CHESS_SIZE];
		initializeChessBoard();
	}

	private void initializeChessBoard() {
		for (int i = 0; i < CHESS_SIZE; i++) {
			for (int j = 0; j < CHESS_SIZE; j++)
				chessBoard[i][j] = Integer.MIN_VALUE;
		}
	}

	public void solveTour() {

		chessBoard[0][0] = 1;

		if (solve(2, 0, 0)) {
			printSolution();
		} else
			System.out.println("No feasible Solution");
	}

	private boolean solve(int stepCounter, int x, int y) {

		if (stepCounter == CHESS_SIZE * CHESS_SIZE + 1)
			return true;

		for (int i = 0; i < NUM_OF_MOVES; i++) {

			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];

			if (isStepValid(nextX, nextY)) {

				chessBoard[nextX][nextY] = stepCounter;

				if (solve(stepCounter + 1, nextX, nextY))
					return true;
				
				chessBoard[nextX][nextY] = Integer.MIN_VALUE;
			}

		}

		return false;
	}

	private boolean isStepValid(int nextX, int nextY) {
		
		if(nextX < 0 || nextX >= CHESS_SIZE) return false;
		if(nextY < 0 || nextY >= CHESS_SIZE) return false;
		if(chessBoard[nextX][nextY] != Integer.MIN_VALUE) return false;
		
		return true;
	}

	private void printSolution() {
		for (int i = 0; i < CHESS_SIZE; i++) {
			for (int j = 0; j < CHESS_SIZE; j++)
				System.out.print(chessBoard[i][j] + " ");

			System.out.println();
		}
	}

}
