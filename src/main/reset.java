package main;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class reset implements ActionListener {
	JFrame reset = new JFrame();
	JLabel warning = new JLabel("Do you really want to reset all you progress?");
	JButton yesButton = new JButton("YES");
	JButton noButton = new JButton("NO");
	
	player player = new player();
	public reset(){
		reset.setAlwaysOnTop(true);
		
		reset.setTitle("Reset?");
		reset.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		reset.setSize(300, 200);
		reset.setLocationRelativeTo(null);
		reset.setVisible(true);
		reset.getContentPane().setLayout(null);
		

		warning.setBounds(12, 13, 258, 70);
		reset.getContentPane().add(warning);
		
		
		yesButton.setBounds(12, 96, 110, 44);
		yesButton.addActionListener(this);
		reset.getContentPane().add(yesButton);
		
		
		noButton.setBounds(160, 96, 110, 44);
		noButton.addActionListener(this);
		reset.getContentPane().add(noButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==yesButton){
			player.setScore(1000);
			player.setSpeed(0);
			player.setCut(0);
			player.setCook(0);
			player.setDish(0);
			player.setDrink(0);
			player.setDeco(0);
			new save();
			
			reset.dispose();
		}
		if(e.getSource()==noButton){
			reset.dispose();
		}
		
	}
}
