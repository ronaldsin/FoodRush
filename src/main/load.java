package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class load{
	player player = new player();
	String str;
	
	public load(){
		Scanner input;
		
		try {
			input = new Scanner(new File("FoodRushSave.txt")); 
			while(input.hasNext()){
				str = str+" "+input.next();
			}
			
			input.close();
		}
		catch (FileNotFoundException e) {
			player.setScore(1000);
			player.setSpeed(0);
			player.setCut(0);
			player.setCook(0);
			player.setDish(0);
			player.setDrink(0);
			player.setDeco(0);
			new save();
		System.out.println("File not found read");
		}
		String[] data = str.split(" ");
		player.setScore(Integer.valueOf(data[1]));
		player.setSpeed(Integer.valueOf(data[2]));
		player.setCut(Integer.valueOf(data[3]));
		player.setCook(Integer.valueOf(data[4]));
		player.setDeco(Integer.valueOf(data[5]));
		player.setDish(Integer.valueOf(data[6]));
		player.setDrink(Integer.valueOf(data[7]));
	}
}

