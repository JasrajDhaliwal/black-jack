package termProject;

public class Player {
	private int points = 0;
	private String name;
	
	public Player(String name) {
		points = 0;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	public void addPoints(int pointsToAdd) {
		if (pointsToAdd >= 40) {
			points = points + (pointsToAdd-39);
		}
		else if (pointsToAdd >= 27) {
			points = points + (pointsToAdd-26);
		}
		else if (pointsToAdd >= 14) {
			points = points + (pointsToAdd-13);
		}
		else {
			points = points + pointsToAdd;
		}
	}
	public void resetPoints () {
		points = 0;
	}
}
