package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;

import cz.uhk.fim.pro2.game.interfaces.WorldListener;

public class World {

	public static final int SPEED = 100;
	
	private Bird bird;	
	private List<Tube> tubes;	
	private List<Heart> hearts;
	private WorldListener worldListener;
	
	private static final int SPACE_BETWEEN_TUBES = 300;
	private static final int SPACE_BETWEEN_HEARTS = 450;
	
	public World(Bird bird, WorldListener worldListner) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
		this.worldListener = worldListner;
	}
	
	public void update(float deltaTime){
		bird.update(deltaTime);
		
		if(bird.isOutOf()){
			worldListener.outOf();
		}
		
		for(Heart heart : hearts){
			heart.update(deltaTime);
			
			if(bird.collideWith(heart)){
				worldListener.catchHeart(heart);
			}
		}
		
		for(Tube tube : tubes){
			tube.update(deltaTime);
			
			if(bird.collideWith(tube)){
				worldListener.crashTube(tube);
			}
		}
	}
	private void regenerate() {
		for(Tube tube : tubes) {
			if(tube.getPositionX() < -100) {
				tube.setPositionX(tube.getPositionX() + tubes.size() * SPACE_BETWEEN_TUBES);
				tube.setHeight(Tube.getRandomHeight());
				tube.setFlew(false);
			}
		}
		
		for(Heart heart : hearts) {
			if(heart.getPositionX() < -100) {
				heart.setPositionX(heart.getPositionX() + (hearts.size() + 1) * SPACE_BETWEEN_HEARTS);
				heart.setPositionY(heart.getRandomY());
			}
		}
	}
	public void addTube(Tube tube) {
		tubes.add(tube);
	}
	
	public void addHeart(Heart heart) {
		hearts.add(heart);
	}
	
	public Bird getBird() {
		return bird;
	}
	
	public List<Tube> getTubes() {
		return tubes;
	}

	public List<Heart> getHearts() {
		return hearts;
	}

	@Override
	public String toString() {
		return "Bird: " + bird.getName() 
		+ " [" + bird.getPositionX() 
		+ ";" + bird.getPositionY() + "]\n"
				
		+ "Tubes: " + tubes.size() + "\n"				
		+ "Hearts: " + hearts.size();
	}
	
}
