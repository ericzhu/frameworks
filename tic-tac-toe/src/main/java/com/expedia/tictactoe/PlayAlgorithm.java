package com.expedia.tictactoe;

/**
 * This interface represent the algorithm used by play to 
 * play Tictactoe.
 * 
 * @author ezhu
 *
 */
public interface PlayAlgorithm {
	
	public int[] getPosition(GridBoard gridBoard);
	
}
