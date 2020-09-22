package main;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class shop implements ActionListener  {
	//gui
	JFrame shop = new JFrame();
	JButton speedButton = new JButton();//faster char speed
	JButton dishButton = new JButton();//how many dishes you start the game with
	JButton stoveButton = new JButton();//how long it takes to cook
	JButton decorationsButton = new JButton();//how much tip you get
	JButton drinksButton = new JButton();//how long untill the customer gets angery
	JButton cuttingButton = new JButton();//how long it takes to cut things
	JButton backButton = new JButton();//return to the menu
	JLabel score = new JLabel();//displays current money
	JLabel scoreImage = new JLabel();
	
	JLabel speedCost = new JLabel();
	JLabel stoveCost = new JLabel();
	JLabel cuttingCost = new JLabel();
	JLabel drinksCost = new JLabel();
	JLabel decoCost = new JLabel();
	JLabel dishCost = new JLabel();
	
	player player= new player();
	audioPlayer audioPlayer = new audioPlayer();
	
	public shop(){
		refreshMoney();
		loadShop();
	}
	
	public void loadShop(){
		shop.setResizable(false);
		shop.setAlwaysOnTop(true);
		shop.setTitle("Shop");
		shop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		shop.setSize(600,600);
		shop.setLocationRelativeTo(null);
		shop.setVisible(true);
		shop.getContentPane().setLayout(null);
		speedButton.setIcon(new ImageIcon(shop.class.getResource("/resource/images/speed.png")));
		
		speedButton.setToolTipText("Makes you move faster");
		speedButton.setBounds(30, 90, 150, 160);
		speedButton.setContentAreaFilled(false);
		speedButton.setBorderPainted(false);
		speedButton.setRolloverIcon(new ImageIcon(shop.class.getResource("/resource/images/speedRollover.png")));
		shop.getContentPane().add(speedButton);
		speedButton.addActionListener(this);
		dishButton.setIcon(new ImageIcon(shop.class.getResource("/resource/images/dish.png")));
		
		dishButton.setToolTipText("Gives you more dishes");
		dishButton.setBounds(29, 324, 150, 160);
		dishButton.setContentAreaFilled(false);
		dishButton.setBorderPainted(false);
		dishButton.setRolloverIcon(new ImageIcon(shop.class.getResource("/resource/images/dishRollover.png")));
		shop.getContentPane().add(dishButton);
		dishButton.addActionListener(this);
		
		stoveButton.setIcon(new ImageIcon(shop.class.getResource("/resource/images/cook.png")));
		stoveButton.setToolTipText("Makes you cook faster");
		stoveButton.setBounds(222, 90, 150, 160);
		stoveButton.setContentAreaFilled(false);
		stoveButton.setBorderPainted(false);
		stoveButton.setRolloverIcon(new ImageIcon(shop.class.getResource("/resource/images/cookRollover.png")));
		shop.getContentPane().add(stoveButton);
		stoveButton.addActionListener(this);
		decorationsButton.setIcon(new ImageIcon(shop.class.getResource("/resource/images/deco.png")));
		
		decorationsButton.setToolTipText("Makes customers leave a bigger tip");
		decorationsButton.setBounds(222, 324, 150, 160);
		decorationsButton.setContentAreaFilled(false);
		decorationsButton.setBorderPainted(false);
		decorationsButton.setRolloverIcon(new ImageIcon(shop.class.getResource("/resource/images/decoRollover.gif")));
		shop.getContentPane().add(decorationsButton);
		decorationsButton.addActionListener(this);
		
		drinksButton.setIcon(new ImageIcon(shop.class.getResource("/resource/images/drink.png")));
		drinksButton.setToolTipText("Makes customers stay longer ");
		drinksButton.setBounds(410, 324, 150, 160);
		drinksButton.setContentAreaFilled(false);
		drinksButton.setBorderPainted(false);
		drinksButton.setRolloverIcon(new ImageIcon(shop.class.getResource("/resource/images/drinkRollover.png")));
		shop.getContentPane().add(drinksButton);
		drinksButton.addActionListener(this);
		
		cuttingButton.setIcon(new ImageIcon(shop.class.getResource("/resource/images/cut.png")));
		cuttingButton.setToolTipText("Makes you cut faster");
		cuttingButton.setBounds(410, 90, 150, 160);
		cuttingButton.setContentAreaFilled(false);
		cuttingButton.setBorderPainted(false);
		cuttingButton.setRolloverIcon(new ImageIcon(shop.class.getResource("/resource/images/cutRollover.png")));
		shop.getContentPane().add(cuttingButton);
		cuttingButton.addActionListener(this);
		backButton.setIcon(new ImageIcon(shop.class.getResource("/resource/images/back.png")));
		
		backButton.setToolTipText("Go back to the main menu");
		backButton.setBounds(449, 13, 110, 60);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setRolloverIcon(new ImageIcon(shop.class.getResource("/resource/images/backRollover.png")));
		shop.getContentPane().add(backButton);
		backButton.addActionListener(this);

		scoreImage.setIcon(new ImageIcon(shop.class.getResource("/resource/images/scoreCounter.png")));
		scoreImage.setBounds(12, 13, 45, 30);
		shop.getContentPane().add(scoreImage);
		
		score.setHorizontalAlignment(SwingConstants.LEFT);
		score.setFont(new Font("Arial Black", Font.BOLD, 18));
		score.setBounds(58, 13, 95, 30);
		shop.getContentPane().add(score);
		speedCost.setFont(new Font("Arial Black", Font.BOLD, 18));
		speedCost.setHorizontalAlignment(SwingConstants.CENTER);
		
		speedCost.setBounds(30, 250, 150, 40);
		shop.getContentPane().add(speedCost);
		stoveCost.setFont(new Font("Arial Black", Font.BOLD, 18));
		stoveCost.setHorizontalAlignment(SwingConstants.CENTER);
		
		stoveCost.setBounds(222, 250, 150, 40);		
		shop.getContentPane().add(stoveCost);
		cuttingCost.setFont(new Font("Arial Black", Font.BOLD, 18));
		cuttingCost.setHorizontalAlignment(SwingConstants.CENTER);
		
		cuttingCost.setBounds(410, 250, 150, 40);	
		shop.getContentPane().add(cuttingCost);
		drinksCost.setFont(new Font("Arial Black", Font.BOLD, 18));
		drinksCost.setHorizontalAlignment(SwingConstants.CENTER);
		
		drinksCost.setBounds(410, 484, 150, 40);
		shop.getContentPane().add(drinksCost);
		decoCost.setFont(new Font("Arial Black", Font.BOLD, 18));
		decoCost.setHorizontalAlignment(SwingConstants.CENTER);
		
		decoCost.setBounds(222, 484, 150, 40);
		shop.getContentPane().add(decoCost);
		dishCost.setFont(new Font("Arial Black", Font.BOLD, 18));
		dishCost.setHorizontalAlignment(SwingConstants.CENTER);
		
		dishCost.setBounds(30, 485, 150, 40);
		shop.getContentPane().add(dishCost);
		


	}
	public void refreshMoney(){//refresh all money values
		score.setText("$" + Integer.toString(player.getScore()));
		speedCost.setText("$"+Integer.toString(1000+(1000*(player.getSpeed()*2))));
		stoveCost.setText("$"+Integer.toString(1000+(1000*(player.getCook()*2))));
		cuttingCost.setText("$"+Integer.toString(1000+(1000*(player.getCut()*2))));
		decoCost.setText("$"+Integer.toString(1000+(1000*(player.getDeco()*2))));
		drinksCost.setText("$"+Integer.toString(1000+(1000*(player.getDrink()*2))));
		dishCost.setText("$"+Integer.toString(1000+(1000*(player.getDish()*2))));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==speedButton){
			if(player.getScore()>= 1000+(1000*(player.getSpeed()*2))){//checks if you have enough money
				player.setScore(player.getScore()-(1000+(1000*(player.getSpeed()*2))));
				player.setSpeed(player.getSpeed()+1);
				new save();
				refreshMoney();
				audioPlayer.play("/resource/audio/moneySFX.wav");
			}
		}
		if(e.getSource()==cuttingButton){
			if(player.getScore()>= 1000+(1000*(player.getCut()*2))){
				player.setScore(player.getScore()-(1000+(1000*(player.getCut()*2))));
				player.setSpeed(player.getCut()+1);
				new save();
				refreshMoney();
				audioPlayer.play("/resource/audio/moneySFX.wav");
			}
		}
		if(e.getSource()==stoveButton){
			if(player.getScore()>= 1000+(1000*(player.getCook()*2))){
				player.setScore(player.getScore()-(1000+(1000*(player.getCook()*2))));
				player.setSpeed(player.getCook()+1);
				new save();
				refreshMoney();
				audioPlayer.play("/resource/audio/moneySFX.wav");
			}
		}
		if(e.getSource()==dishButton){
			if(player.getScore()>= 1000+(1000*(player.getDish()*2))){
				player.setScore(player.getScore()-(1000+(1000*(player.getDish()*2))));
				player.setSpeed(player.getDish()+1);
				new save();
				refreshMoney();
				audioPlayer.play("/resource/audio/moneySFX.wav");
			}
		}
		if(e.getSource()==decorationsButton){
			if(player.getScore()>= 1000+(1000*(player.getDeco()*2))){
				player.setScore(player.getScore()-(1000+(1000*(player.getDeco()*2))));
				player.setSpeed(player.getDeco()+1);
				new save();
				refreshMoney();
				audioPlayer.play("/resource/audio/moneySFX.wav");
			}
		}
		if(e.getSource()==drinksButton){
			if(player.getScore()>= 1000+(1000*(player.getDrink()*2))){
				player.setScore(player.getScore()-(1000+(1000*(player.getDrink()*2))));
				player.setSpeed(player.getDrink()+1);
				new save();
				refreshMoney();
				audioPlayer.play("/resource/audio/moneySFX.wav");
			}
		}
		if(e.getSource()==speedButton){
			if(player.getScore()>= 1000+(1000*(player.getSpeed()*2))){
				player.setScore(player.getScore()-(1000+(1000*(player.getSpeed()*2))));
				player.setSpeed(player.getSpeed()+1);
				new save();
				refreshMoney();
				audioPlayer.play("/resource/audio/moneySFX.wav");

			}
		}
		
		if(e.getSource()==backButton){
			shop.dispose();
		}
		
	}
}
