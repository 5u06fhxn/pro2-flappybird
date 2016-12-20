package cz.uhk.fim.pro2.game;



public class StructureOfScore {

	 int score;
	 String name;
	 String date;
		
	 public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}


	
	public StructureOfScore(int score, String name, String date) {
		super();
		this.score = score;
		this.name = name;
		this.date = date;
	}

}
