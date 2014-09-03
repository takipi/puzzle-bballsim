package com.takipi.puzzles.one;

import com.takipi.puzzles.one.data.BasketballMatch;
import com.takipi.puzzles.one.data.BoxScore;
import com.takipi.puzzles.one.simulator.MatchSimulator;
import com.takipi.puzzles.one.simulator.SimulationVerifier;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		BasketballMatch.getInstance().setHomeScore(new BoxScore());
		BasketballMatch.getInstance().setVisitorsScore(new BoxScore());

		MatchSimulator simulator = new MatchSimulator();
		SimulationVerifier verifier = new SimulationVerifier();

		Thread simulatorThread = new Thread(simulator);
		simulatorThread.start();

		Thread verifierThread = new Thread(verifier);
		verifierThread.setDaemon(true);
		verifierThread.start();

		simulatorThread.join();
	}
}
