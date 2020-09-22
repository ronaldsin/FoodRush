package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class cookbook implements ActionListener{
	JFrame book = new JFrame();
	
	JLayeredPane layeredPane = new JLayeredPane();
	
	JButton beefButton = new JButton("BEEF");
	JButton chickenButton = new JButton("CHICKEN");
	JButton porkButton = new JButton("PORK");
	JButton lettuceButton = new JButton("LETTUCE");
	JButton carrotButton = new JButton("CARROT");
	
	JLabel beefPage = new JLabel();
	JLabel porkPage = new JLabel();
	JLabel chickenPage = new JLabel();
	JLabel lettucePage = new JLabel();
	JLabel carrotPage = new JLabel();
	JButton button = new JButton();
	
	audioPlayer audioPlayer = new audioPlayer();
	
	public cookbook(){
		book.setSize(890,640);
		book.setLocationRelativeTo(null);
		book.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		book.setVisible(true);
		book.getContentPane().setLayout(null);
		

		layeredPane.setBounds(0, 0, 872, 593);
		book.getContentPane().add(layeredPane);
		
		JLabel bookBack = new JLabel();
		bookBack.setIcon(new ImageIcon(cookbook.class.getResource("/resource/images/bookBack.png")));
		bookBack.setBounds(0, 0, 872, 593);
		layeredPane.add(bookBack);
		
		JLabel backPage = new JLabel();
		backPage.setIcon(new ImageIcon(cookbook.class.getResource("/resource/images/backPage.png")));
		layeredPane.setLayer(backPage, 1);
		backPage.setBounds(432, 35, 403, 529);
		layeredPane.add(backPage);
		

		beefPage.setIcon(new ImageIcon(cookbook.class.getResource("/resource/images/beefPage.png")));
		layeredPane.setLayer(beefPage, 2);
		beefPage.setBounds(434, 50, 396, 504);
		layeredPane.add(beefPage);
		
		

		layeredPane.setLayer(porkPage, 3);
		porkPage.setIcon(new ImageIcon(cookbook.class.getResource("/resource/images/porkPage.png")));
		porkPage.setBounds(434, 50, 396, 504);
		layeredPane.add(porkPage);
		
		
		chickenPage.setIcon(new ImageIcon(cookbook.class.getResource("/resource/images/chickenPage.png")));
		layeredPane.setLayer(chickenPage, 4);
		chickenPage.setBounds(434, 50, 396, 504);
		layeredPane.add(chickenPage);
		
	
		lettucePage.setIcon(new ImageIcon(cookbook.class.getResource("/resource/images/lettucePage.png")));
		layeredPane.setLayer(lettucePage, 5);
		lettucePage.setBounds(434, 50, 396, 504);
		layeredPane.add(lettucePage);
		
		
		carrotPage.setIcon(new ImageIcon(cookbook.class.getResource("/resource/images/carrotPage.png")));
		layeredPane.setLayer(carrotPage, 6);
		carrotPage.setBounds(434, 50, 396, 504);
		layeredPane.add(carrotPage);
		
		
		layeredPane.setLayer(beefButton, 20);
		beefButton.setContentAreaFilled(false);
		beefButton.setBorderPainted(false);
		beefButton.setBounds(441, 50, 73, 29);
		layeredPane.add(beefButton);
		beefButton.addActionListener(this);
		
		
		layeredPane.setLayer(chickenButton, 20);
		chickenButton.setHorizontalAlignment(SwingConstants.LEFT);
		chickenButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chickenButton.setContentAreaFilled(false);
		chickenButton.setBorderPainted(false);
		chickenButton.setBounds(525, 50, 94, 29);
		layeredPane.add(chickenButton);
		chickenButton.addActionListener(this);

		layeredPane.setLayer(porkButton, 20);
		porkButton.setContentAreaFilled(false);
		porkButton.setBorderPainted(false);
		porkButton.setBounds(605, 50, 73, 29);
		layeredPane.add(porkButton);
		porkButton.addActionListener(this);

		layeredPane.setLayer(lettuceButton, 20);
		lettuceButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lettuceButton.setHorizontalAlignment(SwingConstants.LEFT);
		lettuceButton.setContentAreaFilled(false);
		lettuceButton.setBorderPainted(false);
		lettuceButton.setBounds(683, 50, 94, 29);
		layeredPane.add(lettuceButton);
		lettuceButton.addActionListener(this);

		layeredPane.setLayer(carrotButton, 20);
		carrotButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		carrotButton.setContentAreaFilled(false);
		carrotButton.setBorderPainted(false);
		carrotButton.setBounds(755, 50, 73, 29);
		layeredPane.add(carrotButton);
		carrotButton.addActionListener(this);
		
		layeredPane.setLayer(button, 10);
		button.setIcon(new ImageIcon(cookbook.class.getResource("/resource/images/back1.png")));
		button.setRolloverIcon(new ImageIcon(cookbook.class.getResource("/resource/images/back1Rollover.png")));
		button.setToolTipText("Return to the menu");
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(46, 489, 60, 60);
		button.addActionListener(this);
		layeredPane.add(button);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==beefButton){
			layeredPane.setLayer(beefPage,6);
			layeredPane.setLayer(porkPage,3);
			layeredPane.setLayer(chickenPage,3);
			layeredPane.setLayer(lettucePage,3);
			layeredPane.setLayer(carrotPage,3);
			audioPlayer.play("/resource/audio/flipPageSFX.wav");
			
		}
		if(e.getSource()==porkButton){
			layeredPane.setLayer(beefPage,3);
			layeredPane.setLayer(porkPage,6);
			layeredPane.setLayer(chickenPage,3);
			layeredPane.setLayer(lettucePage,3);
			layeredPane.setLayer(carrotPage,3);
			audioPlayer.play("/resource/audio/flipPageSFX.wav");
			
		}
		if(e.getSource()==chickenButton){
			layeredPane.setLayer(beefPage,3);
			layeredPane.setLayer(porkPage,3);
			layeredPane.setLayer(chickenPage,6);
			layeredPane.setLayer(lettucePage,3);
			layeredPane.setLayer(carrotPage,3);
			audioPlayer.play("/resource/audio/flipPageSFX.wav");
			
		}
		if(e.getSource()==lettuceButton){
			layeredPane.setLayer(beefPage,3);
			layeredPane.setLayer(porkPage,3);
			layeredPane.setLayer(chickenPage,3);
			layeredPane.setLayer(lettucePage,6);
			layeredPane.setLayer(carrotPage,3);
			audioPlayer.play("/resource/audio/flipPageSFX.wav");
			
		}
		if(e.getSource()==carrotButton){
			layeredPane.setLayer(beefPage,3);
			layeredPane.setLayer(porkPage,3);
			layeredPane.setLayer(chickenPage,3);
			layeredPane.setLayer(lettucePage,3);
			layeredPane.setLayer(carrotPage,6);
			audioPlayer.play("/resource/audio/flipPageSFX.wav");
			
		}
		if(e.getSource()==button){
			 book.setVisible(false);
		}
	}
}
