package com.expedia.tictactoe;

import java.util.List;
import java.util.Random;

/**
 * A simple implementation of the <code>PlayAlgorithm</code>.
 * It simple pick a random available spot in the GridBoard and 
 * set its symbol on it.
 * 
 * As there is no need to have multiple instances of this class
 * in the application, it is set to be sigleton in the JVM.
 * 
 * @author ezhu
 *
 */
public class PlayAlgorithmRandom implements PlayAlgorithm {
	
	private final static PlayAlgorithm instance = new PlayAlgorithmRandom();

	private PlayAlgorithmRandom() {
	}
	
	public static PlayAlgorithm getInstance() {
		return instance;
	}

	@Override
	public int[] getPosition(GridBoard gridBoard) {
		List<int[]> availabeSpots = gridBoard.getAvailabeSpots();
		Random random = new Random();
		int index = random.nextInt(availabeSpots.size());
		return availabeSpots.get(index);
	}
}
