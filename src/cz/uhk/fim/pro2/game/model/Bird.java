package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Bird {
	
	private static final int GRAVITY = 300;
	private static final int JUMP = 500;
	
	private String name;
	private float positionX, positionY;
	private float speed;
	private int lives;
	
	public Bird(String name, float positionX, float positionY) {
		super();
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
		speed = 0;
		lives = 3;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		
		Rectangle rectangle = getRectangle();
		
		g.fillRect(
			(int) rectangle.getX(),
			(int) rectangle.getY(),
			(int) rectangle.getWidth(),
			(int) rectangle.getHeight()
		);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(
			(int) (getPositionX()) - 25,
			(int) getPositionY() - 25,
			50,
			50
		);
	}
	
	public void update(float deltaTime){
		positionY -= speed * deltaTime;
		positionY += GRAVITY * deltaTime;
		
		speed -= speed * deltaTime; 
	}
	
	public boolean collideWith(Tube tube){
		Rectangle rectangle = getRectangle();
		
		return rectangle.intersects(tube.getBottomRectangle()) || rectangle.intersects(tube.getTopRectangle());
	}
	
	public boolean collideWith(Heart heart){
		return getRectangle().intersects(heart.getRectangle());
	}
	
	public boolean isOutOf(){
		Rectangle rectangle = getRectangle();
		
		// Porovnani min hodnot
		if(rectangle.getMinX() < 0 || rectangle.getMinY() < 0){
			return true;
		}
		
		// Porovnani max hodnot
		if(rectangle.getMaxX() > MainFrame.WIDTH || rectangle.getMaxY() > MainFrame.HEIGHT){
			return true;
		}
		
		return false;
	}
	
	public void goUp() {
		speed = JUMP;
	}
	
	public String getName(){
		return name;
	}
	
	public float getPositionX() {
		return positionX;
	}
	
	public void setPositionX(float x) {
		this.positionX = x;
	}
	
	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public void catchHeart() {
		
	}
	
	public void die() {
		
	}

	public void addLive() {
		
	}
	
	public void removeLive() {
		
	}	
}