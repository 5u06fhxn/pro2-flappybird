package cz.uhk.fim.pro2.game;


import java.io.File;
import java.io.IOException;

import cz.uhk.fim.pro2.game.gui.GameScreen;
import cz.uhk.fim.pro2.game.gui.HomeScreen;
import cz.uhk.fim.pro2.game.gui.MainFrame;
import cz.uhk.fim.pro2.game.gui.ScoreScreen;

public class Game {
	public static final String SCORE_FILE= "score.cvs";
	public static void main(String[] args) {

		
		
		 File file = new File(SCORE_FILE);
		 if(!file.exists())
		 {
			 try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Nejde vytvorit soubor");
				
			}
			 
		 }
		MainFrame mainFrame = new MainFrame();
		mainFrame.setScreen(new HomeScreen(mainFrame));
		
		
	}
}
