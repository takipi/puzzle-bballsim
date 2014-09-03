package com.takipi.puzzles.one.data;

public class BoxScore {
	
	private int score;
	private int pt1Made;
	private int pt2Made;

	public BoxScore() {
		this(0, 0, 0);
	}

	public BoxScore(int score, int pt1Made, int pt2Made) {
		this.score = score;
		this.pt1Made = pt1Made;
		this.pt2Made = pt2Made;
	}

	public int getScore() {
		return score;
	}

	public boolean verify() {
		return (score == pt1Made + (2 * pt2Made));
	}

	public static BoxScore advanceScore(
			BoxScore boxScore,
			int scoreDelta,
			int pt1Delta,
			int pt2Delta) {
		return new BoxScore(
				boxScore.score + scoreDelta,
				boxScore.pt1Made + pt1Delta,
				boxScore.pt2Made + pt2Delta);
	}
}
