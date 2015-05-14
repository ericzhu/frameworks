package com.expedia.tictactoe;

import java.util.LinkedList;
import java.util.List;


/**
 * This class represent the GridBord on which the game is played.
 * @author ezhu
 *
 */
public class GridBoard {

	/**
	 * Flag indicating where is game is over
	 */
	private boolean gameOver = false;
	
	/**
	 * Symbol represent the next valid player for the game.
	 * null means both player are valid players at this 
	 * moment.
	 */
	private Symbol nextPlayerSymbol = null;
	
	/**
	 * A two dimension array represents the spots on the GridBoard.
	 */
	private int[][] grid;

	/**
	 * Constructor
	 */
	public GridBoard() {
		initGridBoard();
	}

	public GridBoard(int[][] grid) {
		this.grid = grid;
		this.gameOver = false;
	}

	/**
	 * initialize and set the grid spots to zero.
	 */
	public void initGridBoard() {
		this.grid = new int[][] { { ZERO, ZERO, ZERO }, { ZERO, ZERO, ZERO }, { ZERO, ZERO, ZERO } };
		this.gameOver = false;
	}

	public boolean isGameOver() {
		return this.gameOver;
	}

	/**
	 * Helper method for printing the status of the GridBoard.
	 */
	public void printPrettyGrid() {
		StringBuffer sb = new StringBuffer();
		sb.append("-----------------\n");

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				sb.append(toPrintSymbol(grid[i][j]) + "\t");
			}
			sb.append("\n");
		}

		sb.append("-----------------\n\n");

		System.out.println(sb.toString());
	}

	
	/**
	 * Helper method used for convert a value to a simple.
	 * X is represented by integer 1, O is represented by -1.
	 * 
	 * @param value
	 * @return
	 */
	private String toPrintSymbol(int value) {
		String symbol = " ";
		if (value == X_VALUE) {
			symbol = "X";
		} else if (value == O_VALUE) {
			symbol = "O";
		}

		return symbol;
	}

	/**
	 * Check if the player passed in the method is a valid next player.
	 * Because the playerX and playO should take its own proper turn to
	 * play the game.
	 * 
	 * @param player
	 * @return
	 */
	public boolean isRightPalyer(Player player) {
		return this.nextPlayerSymbol == null || this.nextPlayerSymbol.equals(player.getSymbol());
	}

	
	/**
	 * This method is invoked by the player when playing the game.
	 * As only one player is allowed to play at one moment. This 
	 * call to this method is synchronized on the instance.
	 * 
	 * @param player
	 */
	public synchronized void palyGame(Player player) {

		while (!isRightPalyer(player)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (gameOver) return;

		System.out.println("= " + player.getSymbol() + " is playing =");

		player.play();
		this.printPrettyGrid();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		checkAndUpdateStatus();
		setNextPalyer(player);
		notifyAll();
	}

	private void setNextPalyer(Player player) {
		if (Symbol.X.equals(player.getSymbol())) {
			this.nextPlayerSymbol = Symbol.O;
		} else {
			this.nextPlayerSymbol = Symbol.X;
		}
	}

	public static void main(String[] args) {
		System.out.println(new GridBoard().toString());
	}

	public static final int X_VALUE = 1;
	public static final int O_VALUE = -1;
	public static final int ZERO = 0;

	/**
	 * Enumeration represent the X and O symbol
	 * @author ezhu
	 *
	 */
	public enum Symbol {
		X {
			@Override
			public int toIntValue() {
				return X_VALUE;
			}
		},
		O {
			@Override
			public int toIntValue() {
				return O_VALUE;
			}
		};

		public abstract int toIntValue();
	}

	
	/**
	 * This method check the status of the game: game is over or not. 
	 * It is called each time after the game is played by one player.
	 */
	public void checkAndUpdateStatus() {
		
		int total = 0;

		for (int row = 0; row < 3; row++) {
			int rowTotal = grid[row][0] + grid[row][1] + grid[row][2];
			if (rowTotal == 3 || rowTotal == -3) {
				this.gameOver = true;
				total = rowTotal;
			}
		}

		for (int col = 0; col < 3; col++) {
			int colTotal = grid[0][col] + grid[1][col] + grid[2][col];
			if (colTotal == 3 || colTotal == -3) {
				this.gameOver = true;
				total = colTotal;
			}
		}

		int slashTotal = grid[0][0] + grid[1][1] + grid[2][2];

		if (slashTotal == 3 || slashTotal == -3) {
			this.gameOver = true;
			total = slashTotal;
		}

		int backSlashTotal = grid[2][0] + grid[1][1] + grid[0][2];
		if (backSlashTotal == 3 || backSlashTotal == -3) {
			this.gameOver = true;
			total = backSlashTotal;
		}

		if (!hasUnfilledSpot()) {
			this.gameOver = true;
		}
		
		if(gameOver) {
			
			System.out.println("======================");
			if(total == 3) {
				System.out.println("* X is winner *");
			} else if(total == -3) {
				System.out.println("* O is winner *");
			} else {
				System.out.println("* No winner   *");
			}
			System.out.println("======================");
		}
		
	}

	/**
	 * This method for calculate the available spots on the current Gridboard.
	 * @return
	 */
	public List<int[]> getAvailabeSpots() {
		List<int[]> availabeSpots = new LinkedList<int[]>();

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (ZERO == grid[row][col]) {
					availabeSpots.add(new int[] { row, col });
				}
			}
		}
		return availabeSpots;
	}

	private boolean hasUnfilledSpot() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (grid[row][col] == ZERO) {
					return true;
				}
			}
		}

		return false;
	}

	public void setSymbolOnSpot(int[] position, Symbol symbol) {
		grid[position[0]][position[1]] = symbol.toIntValue();
	}
}
