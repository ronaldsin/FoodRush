package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class menu implements ActionListener  {
	JFrame main = new JFrame();
	JButton startButton = new JButton("Start Game");
	JButton shopButton = new JButton("Shop");
	JButton quitButton = new JButton("Quit");
	JButton resetButton = new JButton();//reset all saved data
	JButton saveButton = new JButton();//save progress
	audioPlayer audioPlayer = new audioPlayer();
	JButton helpButton = new JButton("How to Play");
	
	public menu(){

		
		main.setResizable(false);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setTitle("Food Rush Menu");
		main.setSize(600,600);
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		main.getContentPane().setLayout(null);

		startButton.setToolTipText("Start the game in Endless Mode!");
		startButton.setBounds(55,300 , 200,66);
		main.getContentPane().add(startButton);
		startButton.setVisible(true);
		startButton.addActionListener(this);
		
		quitButton.setToolTipText("Closes the game.");
		quitButton.setBounds(191,486 , 200,66);
		main.getContentPane().add(quitButton);
		quitButton.setVisible(true);
		quitButton.addActionListener(this);

		shopButton.setToolTipText("Buy upgrades here");
		shopButton.setBounds(325, 300, 200, 66);
		main.getContentPane().add(shopButton);
		shopButton.addActionListener(this);
		resetButton.setIcon(new ImageIcon(menu.class.getResource("/resource/images/reset.png")));
		
		resetButton.setToolTipText("Resets all progress");
		resetButton.setBounds(10, 10, 50, 50);
		resetButton.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/resetRollover.gif")));//change image when hovered
		resetButton.setContentAreaFilled(false);
		resetButton.setBorderPainted(false);
		main.getContentPane().add(resetButton);
		resetButton.addActionListener(this);
		
		saveButton.setIcon(new ImageIcon(menu.class.getResource("/resource/images/save.png")));
		saveButton.setRolloverIcon(new ImageIcon(menu.class.getResource("/resource/images/saveRollover.png")));
		saveButton.setToolTipText("Saves the game");
		saveButton.setContentAreaFilled(false);
		saveButton.setBorderPainted(false);
		saveButton.setBounds(522, 10, 60, 60);
		main.getContentPane().add(saveButton);
		
		JLabel title = new JLabel();
		title.setIcon(new ImageIcon(menu.class.getResource("/resource/images/logo.png")));
		title.setBounds(173, 34, 230, 200);
		main.getContentPane().add(title);
		
		helpButton.setToolTipText("Learn how to play here");
		helpButton.setBounds(191, 392, 200, 66);
		helpButton.addActionListener(this);
		main.getContentPane().add(helpButton);
		
		main.repaint();
		audioPlayer.playBgm(1);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton){
			audioPlayer.stopBgm();
			//main.hide();
			new board();
			
			
			
		}
		if(e.getSource()==shopButton){
			new shop();

			
		}
		if(e.getSource()==helpButton){
			new help();

		}
		if(e.getSource()==resetButton){
			new reset();
			
		}
		if(e.getSource()==quitButton){
			audioPlayer.stop("/resource/audio/bgm2.wav");
			System.exit(0);
		}
		
		
	}
}
