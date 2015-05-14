package com.expedia.tictactoe;

import com.expedia.tictactoe.GridBoard.Symbol;


/**
 * 
 * This class represent a player in the game. 
 * It extends Thread class and play as an independent
 * thread in the applicaiton.
 * 
 * @author ezhu
 *
 */
public class Player extends Thread {
	private final Symbol symbol;
	private GridBoard gridBoard;
	private PlayAlgorithm playAlgorithm;

	public Player(Symbol symbol, GridBoard gridBoard, PlayAlgorithm playAlgorithm) {
		this.symbol = symbol;
		this.gridBoard = gridBoard;
		this.playAlgorithm = playAlgorithm;
	}

	@Override
	public void run() {
		while (!gridBoard.isGameOver()) {
			gridBoard.palyGame(this);
		}
	}

	public void play() {
		int[] position = playAlgorithm.getPosition(this.gridBoard);
		this.gridBoard.setSymbolOnSpot(position, this.symbol);
	}
	
	public Symbol getSymbol() {
		return this.symbol;
	}
}
