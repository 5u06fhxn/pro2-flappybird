package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.StructureOfScore;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.World;

public class FinishScreen extends Screen {
	
	private JLabel lbScore, lbPlayerName;
	private JButton btnStart, btnHome, btnEnterName;
	private JTextArea textName;
	public FinishScreen(MainFrame mainFrame, World world) {
		super(mainFrame);
		
		int score = world.getBird().getScore();
		
		
		textName = new JTextArea(3,16);
		lbScore = new JLabel("Skóre: " + score);
		lbPlayerName = new JLabel("Enter your name");
		
		
		
		btnStart = new JButton("No, I want play again!");
		btnHome = new JButton("No, I want go Home");
		btnEnterName = new JButton("Put Score to table");
		
		
		btnEnterName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StructureOfScore scoreClass = new StructureOfScore(score, textName.getText(), new Date().toGMTString());
				ScoreManager.putScore(scoreClass);
			}
		});
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));				
			}
		});
		
		btnStart.setBounds(100, 400, 280, 50);
		btnHome.setBounds(100, 480, 280, 50);
	
		textName.setText(Bird.name);
		
		
		textName.setBounds(MainFrame.WIDTH/3, MainFrame.HEIGHT/3, 150, 50);
		lbPlayerName.setBounds(MainFrame.WIDTH/3, (MainFrame.HEIGHT/3)- textName.getHeight(), textName.getWidth(), textName.getHeight());
		btnEnterName.setBounds(MainFrame.WIDTH/3, (MainFrame.HEIGHT/3)+ textName.getHeight()+10, textName.getWidth(), textName.getHeight());
		lbScore.setBounds(Integer.valueOf( MainFrame.WIDTH/3), (int) ((MainFrame.HEIGHT/3)- textName.getHeight()*2.5), textName.getWidth(), textName.getHeight());
		
		add(btnEnterName);
		add(lbPlayerName);
		add(textName);
		add(lbScore);
		add(btnStart);
		add(btnHome);
		
	}

}
