package main;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class help implements ActionListener {
	JFrame help = new JFrame();
	JLabel instruct = new JLabel();
	JButton back = new JButton();
	public help(){
		

		help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		help.setTitle("How To Play");
		help.setSize(619,948);
		help.setLocationRelativeTo(null);
		help.setVisible(true);
		help.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 600, 900);
		help.getContentPane().add(layeredPane);
		instruct.setIcon(new ImageIcon(help.class.getResource("/resource/images/help.png")));
		

		instruct.setBounds(0, 0, 600, 900);
		layeredPane.add(instruct);
		

		back.setIcon(new ImageIcon(help.class.getResource("/resource/images/back1.png")));
		back.setRolloverIcon(new ImageIcon(help.class.getResource("/resource/images/back1Rollover.png")));
		layeredPane.setLayer(back, 1);
		back.setToolTipText("Return to the menu");
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setBounds(12, 827, 60, 60);
		layeredPane.add(back);
		back.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
			help.dispose();
		}
		
	}
}
