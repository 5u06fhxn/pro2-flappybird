package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends JPanel {
	
	
	public static final int UP_BOUND = 50;
	public static final int DOWN_BOUND = 70;
	
	private World world;
	private BufferedImage  imageBird,imageHeart, imageTube,imageTop,imageBottom, imageBackground;
	
	public GameCanvas(World world) {
		this.world = world;
		try	 {
			imageBird = ImageIO.read(new File("Assets/bird.png"));
			imageHeart = ImageIO.read(new File("Assets/heart.png"));
			imageTube= ImageIO.read(new File("Assets/tube.png"));
			imageTop = ImageIO.read(new File("Assets/top.png"));
			imageBottom = ImageIO.read(new File("Assets/bottom.png"));
			imageBackground  = ImageIO.read(new File("Assets/background.png"));
		}
		catch (IOException e){
			
		}
	
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//g.setColor(Color.CYAN);
		//g.fillRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		
		//ImageIcon image = new ImageIcon("C:\\Users\\nemecta1\\Downloads\\bg.png");
	g.drawImage(imageBackground, 0, 0, null);
	g.drawImage(imageTop, 0, 0,  MainFrame.WIDTH, UP_BOUND, null);
	g.drawImage(imageBottom,  MainFrame.HEIGHT- 100, 0, 20 , MainFrame.WIDTH, null);
		Bird bird = world.getBird();
		
		bird.paint(g, imageBird);
		
		List<Heart> hearts = world.getHearts();
		for(Heart heart : hearts) {
			heart.paint(g, imageHeart);
		}
		
		List<Tube> tubes = world.getTubes();
		for(Tube tube : tubes) {
			tube.paint(g, imageTube);
		}
		

		
	}
}
