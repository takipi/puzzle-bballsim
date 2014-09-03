package com.takipi.puzzles.one.simulator;

import com.takipi.puzzles.one.data.BasketballMatch;
import com.takipi.puzzles.one.data.BoxScore;

public class SimulationVerifier implements Runnable {
	
	@Override
	public void run() {
		try {
			while (true) {
				verifySimulation();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void verifySimulation() {
		BasketballMatch match = BasketballMatch.getInstance();

		BoxScore homeScore = match.getHomeScore();
		BoxScore visitorsScore = match.getVisitorsScore();

		verify(homeScore);
		verify(visitorsScore);
	}

	private void verify(BoxScore boxScore) {
		if (!boxScore.verify()) {
			throw new IllegalStateException("Box score failed verification!");
		}
	}
}
