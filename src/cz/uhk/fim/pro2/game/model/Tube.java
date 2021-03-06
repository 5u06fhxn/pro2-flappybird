package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Tube {
	
	private float positionX;
	private float height;
	private Color color;
	private boolean flew;
	private static final int GAP = 200;
	public static final int WIDTH = 50;
   private	Rectangle bottomRectangle;
    private int moveWtihTube =0;
    private boolean onTop = true;
	public Tube(float positionX, float height, Color color) {
		super();
		this.positionX = positionX;
		this.height = height;
		this.color = color;
		flew = false;
	}
	
	public void paint(Graphics g, Image imageTubeTop,Image imageTubeBottom){
		g.setColor(Color.GREEN);
		
		Rectangle topRectangle = getTopRectangle();
	 bottomRectangle = getBottomRectangle();

	

		g.drawImage(imageTubeBottom,
			(int) topRectangle.getX(),
			(int) topRectangle.getY(), 
			(int) topRectangle.getWidth(),
			(int) topRectangle.getHeight(),
			null
		);
		
		//image = new ImageIcon("C:\\Users\\nemecta1\\Downloads\\flappy.png");
	//	obr = image.getImage();
		g.drawImage(imageTubeTop,
			(int) bottomRectangle.getX(),
			(int) bottomRectangle.getY(), 
			(int) bottomRectangle.getWidth(),
			(int) bottomRectangle.getHeight(),
			null
		);
		
	}
	
	public Rectangle getTopRectangle(){
		return new Rectangle(
				(int) (getPositionX()) - 25,
				(int) height - moveWtihTube, 
				50,
				(int) (MainFrame.HEIGHT - height)
			);
	}
	
	public Rectangle getBottomRectangle(){
		return new Rectangle(
				(int)(getPositionX()) - 25,
				- moveWtihTube, 
				50,
				(int) (height - GAP)
			);
	}
	public static float getRandomHeight() {
	return (new Random().nextFloat() * 300) + 200;
	}
	
	public int getCenterY() {
		return (int) (height - (GAP / 2.0));
	}
	
	public int getMinX() {
		return (int) (positionX - (WIDTH / 2));
	}
	
	public int getMaxX() {
		return (int) (positionX + (WIDTH / 2));
	}

	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getHeight() {
		return height;
	}

	public Color getColor() {
		return color;
	}
	public void setHeight(float height) {
		this.height = height;
	}

	public void setFlew(boolean flew) {
		this.flew = flew;
	}
	public void update(float deltaTime){
		positionX -= World.SPEED * deltaTime;
		
		if(moveWtihTube>40)
			onTop = true;
		if(moveWtihTube<1)
			onTop = false;
if(onTop)
 moveWtihTube-=1;
else  moveWtihTube+=1;
	}
	public boolean isFlew() {
		return flew;
	}
	
	// TODO konstruktor, gettery, settery, toString()
	
}
