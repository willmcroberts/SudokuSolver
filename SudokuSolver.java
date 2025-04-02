public class SudokuSolver {

	private static final int SIZE = 9;

	public static void main(String[] args) {
		int[][] board = {
			{0,0,0,0,8,6,2,0,0},
			{0,2,4,0,0,0,0,0,0},
			{0,0,7,0,0,3,0,0,5},
			{0,0,0,5,7,0,0,0,6},
			{0,0,8,0,9,0,0,7,0},
			{0,4,0,0,0,0,0,0,0},
			{4,8,0,0,0,0,0,9,0},
			{1,9,0,4,5,0,0,0,3},
			{0,0,0,0,0,0,0,0,2}
		};

		printBoard(board);

		if (solveBoard(board)) {
			System.out.println();
			System.out.println("Solved successfully!");
			System.out.println();
		} else {
			System.out.println("Unsolvable board");
		} // End elif statement

		printBoard(board);
	} // End main

	private static void printBoard(int[][] board) {
		for (int row = 0; row < SIZE; row++) {
			if (row % 3 == 0 && row != 0) {
				System.out.println("-----------");
			} // End if statement

			for (int column = 0; column < SIZE; column++) {
				if (column % 3 ==0 && column != 0) {
					System.out.print("|");
				} // End if statement

				System.out.print(board[row][column]);

			} // End nested for loop
			System.out.println();
		} // End for loop
	} // End printBoard()

	private static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < SIZE; i++) {
			if (board[row][i] == number) {
				return true;
			} // end if statement
		} // End for loop
		return false;
	} // End isNumberInRow()

	private static boolean isNumberInColumn(int[][] board, int number, int column) {
                for (int i = 0; i < SIZE; i++) {
                        if (board[i][column] == number) {
                                return true;
                        } // end if statement
                } // End for loop
                return false;
        } // End isNumberInColumn()

	private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        	int localBoxRow = row - row % 3;
		int localBoxColumn = column - column % 3;

		for (int i = localBoxRow; i < localBoxRow + 3; i++) {
			for (int j = localBoxColumn; j < localBoxColumn +3; j++) {
				if (board[i][j] == number) {
					return true;
				} // End if statment
			} // End nested for loop
		}  // End for loop
		return false;
        } // End isNumberInBox()

	private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
		return !isNumberInRow(board, number, row) && !isNumberInColumn(board, number, column) && !isNumberInBox(board, number, row, column);
	} // End isValidPlacement()

	private static boolean solveBoard(int[][] board) {
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				if (board[row][column] == 0 ) {
					for (int numberToTry = 1; numberToTry <= SIZE; numberToTry++) {
						if (isValidPlacement(board, numberToTry, row, column)) {
							board[row][column] = numberToTry;

							if (solveBoard(board)) {
								return true;
							} else {
								board[row][column] = 0;
							} // End elif statement
						} // end if statement
					} // End nested nested for loop
					return false;
				} // End if statement
			} // End nested for loop
		} // End for loop
		return true;
	} // End solveBoard


} // End SodokuSolver class
