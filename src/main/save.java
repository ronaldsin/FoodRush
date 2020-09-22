package main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class save {
	player player = new player();
	public save(){
		 try {
		        BufferedWriter output = new BufferedWriter(new FileWriter("savefilename.txt"));
		            output.write(Integer.toString(player.getScore())+" \n"+Integer.toString(player.getSpeed())+" \n"+Integer.toString(player.getCut())+" \n"+Integer.toString(player.getCook())+" \n"+Integer.toString(player.getDeco())+" \n"+Integer.toString(player.getDish())+" \n"+Integer.toString(player.getDrink()));
		            //write save file
		            output.close();
		        } catch (IOException e) {
		        	System.out.println("Failed to save");
		        }
	}

}
