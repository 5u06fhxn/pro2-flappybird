package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

public class Heart {
	
	private float positionX, positionY;

	public Heart(float positionX, float positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public void paint(Graphics g, Image obrazek){
		g.setColor(Color.RED);
		
		Rectangle rectangle = getRectangle();
		
		 g.drawImage(obrazek, 
				  (int) rectangle.getX(), 
					(int) rectangle.getY(),
					(int) rectangle.getWidth(),
					(int) rectangle.getHeight(),
					null
				);
	
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(
			(int) (getPositionX()) - 25,
			(int) getPositionY() - 25,
			50,
			50
		);
	}	public static float getRandomY() {
		return (new Random().nextFloat() * 300) + 200;
	}

	public void update(float deltaTime){
		positionX -= World.SPEED * deltaTime;
	}
	
	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}	
}
