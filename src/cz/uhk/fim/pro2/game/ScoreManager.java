package cz.uhk.fim.pro2.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.List;



public class ScoreManager {
	
	//DEFINICE TRIDY
	private List<StructureOfScore> scoreList;

	private ScoreManager() {
		this.scoreList = new ArrayList<StructureOfScore>();
	}


	public static ArrayList<StructureOfScore> bubbleSort( List<StructureOfScore> scoreList2)
	{
		StructureOfScore[] array = (StructureOfScore[]) scoreList2.toArray();
		
		for (int i = 0; i < array.length - 1; i++) 
		{		
		for (int j = 0; j < array.length - i - 1; j++) 
		{
               if(array[j].getScore() < array[j+1].getScore())
               {
            	   StructureOfScore tmp = array[j];
		
	        	array[j] = array[j+1];
		
		        array[j+1] = tmp;
		       }
	
		}
		
		}
		for(StructureOfScore value : array)
		{
			System.out.println(value);
		}
		
		return (ArrayList<StructureOfScore>) Arrays.asList(array);
	}
	
	public void addScore(StructureOfScore score) {
		
		List<StructureOfScore> scoreList = getAll();
		scoreList.add(score);
	bubbleSort(scoreList);
		try {
			FileWriter fileWriter = new FileWriter(Game.SCORE_FILE);
			   BufferedWriter out = new BufferedWriter(fileWriter);
		      

			for(StructureOfScore value : scoreList) {
				  out.write(String.valueOf(value.score));
				  out.write(";");
				  out.write(value.name);
				  out.write(";");
				  out.write(value.date);
				  out.newLine();
			
			}
			out.close();
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Chyba pri zapisovani");
		}
		
	}
	
	public List<StructureOfScore> getAll() {
		
		 scoreList =new ArrayList<StructureOfScore>();
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(Game.SCORE_FILE);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] values = line.split(";");
				scoreList.add(new StructureOfScore(Integer.valueOf(values[0]) ,values[1], values[2]) );
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chyba pri nacitani");
		}
		
		return scoreList;
	}
	
	
	//SINGLETON
	private static ScoreManager instance;
	
	public static ScoreManager getIntstance() {
		
		if(instance == null) {
			instance = new ScoreManager();
		}
		
		return instance;
		
	}
	public static int gePositionInScore(int score) {
		List<StructureOfScore> scoreList = getList();
		FileReader fileReader;
		try {
			fileReader = new FileReader(Game.SCORE_FILE);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int i =0;
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] values = line.split(";");
				i++;
				if(Integer.valueOf(values[0]) < score)
				{
					return i;
				}
					
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chyba pri nacitani");
		}
		
		for(StructureOfScore value : scoreList)
		{
			System.out.println(value);
		}
		return -1;
		
	}
	

	//VEREJNE STATICKE METODY
	public static void putScore(StructureOfScore score) {
		getIntstance().addScore(score);		
	}
	
	public static List getList() {
		return getIntstance().getAll();
	}
	
	public static int size() {
		return getList().size();
	}
	
	public static int get(int i) {
		return (int) getList().get(i);
	}
	
}
