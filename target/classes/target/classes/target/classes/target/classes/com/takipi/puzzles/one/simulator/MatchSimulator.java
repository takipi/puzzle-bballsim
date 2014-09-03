package com.takipi.puzzles.one.simulator;

import java.util.Random;

import com.takipi.puzzles.one.data.BasketballMatch;
import com.takipi.puzzles.one.data.BoxScore;

public class MatchSimulator implements Runnable {
	
	private static final int SIMULATION_LENGTH		= 99999;
	private static final int SIMULATION_NOISE_CAP	= 7;

	private int simulationNoise;

	public MatchSimulator() {
		this.simulationNoise = new Random().nextInt(SIMULATION_NOISE_CAP);
	}

	@Override
	public void run() {
		for (int i = 0; i < SIMULATION_LENGTH; i++) {
			advanceSimulation();
		}

		printMatchResults();
	}

	private void advanceSimulation() {
		BasketballMatch match = BasketballMatch.getInstance();

		BoxScore homeScore = match.getHomeScore();
		BoxScore visitorsScore = match.getVisitorsScore();

		advanceSimulation(match, homeScore, visitorsScore);
	}

	private void advanceSimulation(BasketballMatch match, BoxScore homeScore,
			BoxScore visitorsScore) {
		match.setHomeScore(generateNewBoxScore(homeScore));
		match.setVisitorsScore(generateNewBoxScore(visitorsScore));
	}

	private BoxScore generateNewBoxScore(BoxScore boxScore) {
		int successFactor = nextSuccessFactor();

		int pt1Delta = successFactor + 1;
		int pt2Delta = successFactor;

		int scoreDelta = pt1Delta + (2 * pt2Delta);

		return BoxScore.advanceScore(boxScore, scoreDelta, pt1Delta, pt2Delta);
	}

	private int nextSuccessFactor() {
		if (simulationNoise == SIMULATION_NOISE_CAP) {
			simulationNoise = 0;
		}

		return simulationNoise++;
	}

	private void printMatchResults() {
		BasketballMatch match = BasketballMatch.getInstance();

		BoxScore homeScore = match.getHomeScore();
		BoxScore visitorsScore = match.getVisitorsScore();

		int finalHomeScore = homeScore.getScore() % 100;
		int finalVisitorsScore = visitorsScore.getScore() % 100;

		System.out.println("Final score:");
		System.out.println("> Home:     " + finalHomeScore);
		System.out.println("> Visitors: " + finalVisitorsScore);
	}
}
