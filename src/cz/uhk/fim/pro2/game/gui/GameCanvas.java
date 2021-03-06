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
import javax.swing.JButton;
import javax.swing.JPanel;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends JPanel {
	
	
	public static final int UP_BOUND = 80;
	public static final int DOWN_BOUND = 70;
	
	private World world;
	private BufferedImage  imageBird,imageHeart, imageTubeBottom,imageTop,imageBottom, imageBackground, imageTubeTop;
	
	public GameCanvas(World world) {
		this.world = world;
		try	 {
			imageBird = ImageIO.read(new File("Assets/bird.png"));
			imageHeart = ImageIO.read(new File("Assets/heart.png"));
			imageTubeBottom= ImageIO.read(new File("Assets/tubeBottom.png"));
			imageTubeTop= ImageIO.read(new File("Assets/tubeTop.png"));
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

	g.drawImage(imageBackground, 0, 0, null);
	
		Bird bird = world.getBird();
		
		bird.paint(g, imageBird);
		
		List<Heart> hearts = world.getHearts();
		for(Heart heart : hearts) {
			heart.paint(g, imageHeart);
		}
		
		List<Tube> tubes = world.getTubes();
		for(Tube tube : tubes) {
			tube.paint(g, imageTubeTop, imageTubeBottom);
		}
		
		g.drawImage(imageTop, 0, 0,  MainFrame.WIDTH, UP_BOUND, null);
		g.drawImage(imageBottom, 0, MainFrame.HEIGHT-100, MainFrame.WIDTH , 100, null);
		
	}
}
