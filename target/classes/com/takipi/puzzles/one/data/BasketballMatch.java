package com.takipi.puzzles.one.data;

public class BasketballMatch {
	
	private static volatile BasketballMatch instance;

	public static BasketballMatch getInstance() {
		if (instance == null) {
			synchronized (BasketballMatch.class) {
				if (instance == null) {
					instance = new BasketballMatch();
				}
			}
		}

		return instance;
	}

	private BoxScore homeScore;
	private BoxScore visitorsScore;

	public void setHomeScore(BoxScore homeScore) {
		this.homeScore = homeScore;
	}

	public void setVisitorsScore(BoxScore visitorsScore) {
		this.visitorsScore = visitorsScore;
	}

	public BoxScore getHomeScore() {
		return homeScore;
	}

	public BoxScore getVisitorsScore() {
		return visitorsScore;
	}
}
