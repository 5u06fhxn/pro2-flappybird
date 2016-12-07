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
