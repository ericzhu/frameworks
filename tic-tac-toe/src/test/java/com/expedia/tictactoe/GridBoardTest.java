package com.expedia.tictactoe;

import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class GridBoardTest {

	public static final Object[][] gameOverGrids() {

		int[][] grid0 = new int[][] { { GridBoard.X_VALUE, GridBoard.X_VALUE, GridBoard.X_VALUE },//
				{ GridBoard.ZERO, GridBoard.ZERO, GridBoard.ZERO }, //
				{ GridBoard.ZERO, GridBoard.ZERO, GridBoard.ZERO } };

		int[][] grid1 = new int[][] { { GridBoard.ZERO, GridBoard.ZERO, GridBoard.ZERO },//
				{ GridBoard.X_VALUE, GridBoard.X_VALUE, GridBoard.X_VALUE }, //
				{ GridBoard.ZERO, GridBoard.ZERO, GridBoard.ZERO } };

		int[][] grid2 = new int[][] { { GridBoard.ZERO, GridBoard.ZERO, GridBoard.ZERO },//
				{ GridBoard.ZERO, GridBoard.ZERO, GridBoard.ZERO }, //
				{ GridBoard.X_VALUE, GridBoard.X_VALUE, GridBoard.X_VALUE } };

		int[][] grid3 = new int[][] { { GridBoard.X_VALUE, GridBoard.ZERO, GridBoard.ZERO },//
				{ GridBoard.ZERO, GridBoard.X_VALUE, GridBoard.ZERO }, //
				{ GridBoard.ZERO, GridBoard.ZERO, GridBoard.X_VALUE } };

		int[][] grid4 = new int[][] { { GridBoard.X_VALUE, GridBoard.ZERO, GridBoard.X_VALUE },//
				{ GridBoard.ZERO, GridBoard.X_VALUE, GridBoard.ZERO }, //
				{ GridBoard.X_VALUE, GridBoard.ZERO, GridBoard.ZERO } };

		int[][] grid5 = new int[][] { { GridBoard.O_VALUE, GridBoard.X_VALUE, GridBoard.O_VALUE },//
				{ GridBoard.O_VALUE, GridBoard.X_VALUE, GridBoard.X_VALUE }, //
				{ GridBoard.X_VALUE, GridBoard.O_VALUE, GridBoard.X_VALUE } };

		return new Object[][] { { grid0 }, { grid1 }, { grid2 }, { grid3 }, { grid4 }, { grid5 } };
	}

	@Test
	@Parameters(method = "gameOverGrids")
	public void test_updateStatus_statusShouldBeFinishedWhen(int[][] grid) {
		GridBoard gridBoard = new GridBoard(grid);
		gridBoard.checkAndUpdateStatus();
		Assert.assertTrue(gridBoard.isGameOver());
	}
	
	@Test
	public void test_getAvailableSpots() {
		int[][] grid = new int[][] { { GridBoard.X_VALUE, GridBoard.X_VALUE, GridBoard.X_VALUE },//
				{ GridBoard.ZERO, GridBoard.ZERO, GridBoard.ZERO }, //
				{ GridBoard.ZERO, GridBoard.ZERO, GridBoard.ZERO } };
		
		GridBoard gridBoard = new GridBoard(grid);
		List<int[]> availableSpots = gridBoard.getAvailabeSpots();
		Assert.assertEquals(6, availableSpots.size());
	}
	
	
	@Test
	@Parameters(method="gameOverGrids")
	public void test_checkAndUpdateStatus_gameNotOver(int[][] grid) {
		GridBoard gridBoard = new GridBoard(grid);
		gridBoard.checkAndUpdateStatus();
		Assert.assertTrue(gridBoard.isGameOver());
	}
}
