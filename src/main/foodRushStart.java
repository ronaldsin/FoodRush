package main;
//Food Rush - Ronald Sin
//
//Features:
//saveing
//loading
//upgrades
//cookbook
//how to play(cookbook)
//sound effects
//animations
//button rollovers
//music player(jukebox)
//movement
//looking direction
//loading screen
//score/difficulty multiplier
//plates count
//score reduction
//cook foods
//chop food
//get raw food
//get plates
//throw things away
//wash dishes
//hand switching
//random customer spawning
//
//how to play
//click on object to interact and move to them
//click on the bottom right to select main hand
//

public class foodRushStart {
	
	public static void main(String[] args) {
		int test =0;
		
		new SplashScreen();
		
		while (test !=100){//wait untill loading is done
			test = SplashScreen.done();
			System.out.println();
		}
		
		
		new menu();
		new load();

	}

}
