package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class HomeScreen extends Screen {

	public HomeScreen(MainFrame mainFrame)  {
		super(mainFrame);

		JLabel jLabelTitle = new JLabel("FIM BIRD");
		
		JButton jButtonPlay = new JButton("PLAY");
		JButton jButtonScore = new JButton("SCORE");
	
		JLabel back = new JLabel();
	back.setBounds(0,  0, MainFrame.WIDTH, MainFrame.HEIGHT);
		ImageIcon image = new ImageIcon("Assets/background.png");
   	 back.setIcon(image);
	 
		jButtonPlay.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		jButtonScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
			}
		});
		
		jLabelTitle.setFont(new Font("Arial", Font.BOLD, 40));
		

		jLabelTitle.setBounds(10, 10, 460, 100);
		jButtonPlay.setBounds(100, 400, 280, 50);
		jButtonScore.setBounds(100, 460, 280, 50);
		
	
		
	
		add(jLabelTitle);
		add(jButtonPlay);
		add(jButtonScore);
	
		add(back);
	}	
}
