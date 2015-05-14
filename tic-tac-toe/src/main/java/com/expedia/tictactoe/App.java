package com.expedia.tictactoe;

import com.expedia.tictactoe.GridBoard.Symbol;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		GridBoard gridBoard = new GridBoard();
		Player playerX = new Player(Symbol.X, gridBoard, PlayAlgorithmRandom.getInstance());
		Player playerO = new Player(Symbol.O, gridBoard, PlayAlgorithmRandom.getInstance());
		playerX.start();
		playerO.start();
	}
}