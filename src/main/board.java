package main;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class board implements ActionListener{
	//Timers
	Timer gameTimer = new Timer(33,this);
	Timer startMusic = new Timer(1000,this);
	
	
	//variables
	Random rand = new Random();
	int checkpoint = 860;
	int openTables;
	int patience;
	int eatMax = 150;
	int maxTip;
	int tip;//initial tip
	int speed;
	int cuttingSpeed;
	int cookingSpeed;
	int songs=7; //number of bgms in game +1
	int currentBgm=1;
	int[] tableCounter = new int[7];//customer patience 
	int[] eatingCounter = new int[7]; //customer eating time
	boolean[] eating = new boolean[7];//which tables are eating
	boolean[] tableWaiting = new boolean[7];//which tables are waiting
	int dishCounter;
	
	int stars;//how many stars should be displayed
	int multiplierTime;
	double multiplier = 0;
	//spawn
	
	int spawnCounter;
	int spawnTime = 700;// time between customers
	//stove
	int cookingCounter1;//how long the stoves been cooking
	int cookingCounter2;
	boolean cooking1;
	boolean cooking2;
	//chopping
	boolean chopping;
	int choppingCounter;//how long it has been chopping for
	
	//GUIs
	JFrame board = new JFrame();
	
	JLayeredPane main = new JLayeredPane();
	JLayeredPane playerPane = new JLayeredPane();
	JLabel dishCount = new JLabel();
	JLabel dishes = new JLabel();
	JLabel score = new JLabel();
	JLabel scoreCount = new JLabel();
	
	JLabel playerLabel = new JLabel();
	
	JLabel backCounter = new JLabel();
	JLabel background = new JLabel();
	JLabel topCounter = new JLabel();
	
	JLabel scoreCounter = new JLabel();
	
	JButton saveButton = new JButton();
	
	JButton cookBook = new JButton();
	
	//tables
	JButton[] table = new JButton[7];

	//ingredients
	JButton beef = new JButton();
	JButton lettuce = new JButton();
	JButton pork = new JButton();
	JButton chicken = new JButton();
	JButton carrot = new JButton();
	
	//Utility 
	JButton stove1 = new JButton();
	JButton stove2 = new JButton();
	JButton cuttingBoard = new JButton();
	JButton sink = new JButton();
	JButton drink = new JButton();
	JButton trashcan = new JButton();
	JButton dishBin = new JButton();
	JButton backButton = new JButton();
	
	//main hand GUI
	JLayeredPane mainHandPane = new JLayeredPane();
	JButton[] mainHand = new JButton[2];{
	mainHand[0]=new JButton();
	mainHand[1]=new JButton();
	}
	
	
	//objects
	player player = new player();
	audioPlayer audioPlayer = new audioPlayer();
	food[] tableF = new food[7];
	//1 - table1
	//2 - table2
	//3 - table3
	//4 - table4
	//5 - table5
	//6 - table6
	
	food[] hand = new food[2];
	//0 - hand1
	//1 - hand2
	
	food[] stoveF = new food[2];
	//0 - stove1
	//1 - stove2
	
	food choppingBoardF = new food();
	JLabel multiplierIcon = new JLabel();
	JLabel multiplierLbl = new JLabel();

	public board(){
		patience = (player.getDeco()*5)+900;
		dishCounter = (player.getDish()*5)+15;
		maxTip= (player.getDrink()*2)+20;
		tip=maxTip;
		speed = (player.getSpeed()*2)+15;
		cuttingSpeed=90-(player.getCut()*10);
		cookingSpeed=180-(player.getCut()*15);
		startMusic.setRepeats(false);
		startMusic.start();
		
		
		
		gameTimer.start();

		loadBoard();
	}
	
	public void loadBoard(){
		for ( int x=1; x<7; x++) {
			table[x]=new JButton();
			}
		
		for ( int x=1; x<7; x++) {
			tableF[x]=new food();
			}
		
		
		hand[0]=new food();
		hand[1]=new food();
		
		stoveF[0]=new food();
		stoveF[1]=new food();
		board.setAlwaysOnTop(true);
		board.setResizable(false);
		board.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		board.setTitle("Food Rush");
		board.setSize(1024,540);
		board.setLocationRelativeTo(null);
		board.setVisible(true);
		board.getContentPane().setLayout(null);
		
		main.setBounds(0, 0, 1006, 493);
		board.getContentPane().add(main);
		
		main.setLayer(backCounter, 0);
		backCounter.setIcon(new ImageIcon(board.class.getResource("/resource/images/backCounter.png")));
		backCounter.setBounds(150, 0, 640, 120);
		main.add(backCounter);
		
		background.setIcon(new ImageIcon(getClass().getResource("/resource/images/Food Rush Board.png")));
		background.setBounds(0, 0, 1006, 493);
		main.add(background);
		
		main.setLayer(playerPane, 2);
		

		playerLabel.setBounds(0, 0, 100, 200);
		playerPane.setBounds(230, 0, 100, 200);
		main.add(playerPane);
		playerPane.add(playerLabel);
		playerLabel.setIcon(new ImageIcon(getClass().getResource("/resource/images/placeHolderPlayerDown.png")));
		
		JLayeredPane topCounterPane = new JLayeredPane();
		main.setLayer(topCounterPane, 3);
		topCounterPane.setBounds(150, 120, 640, 95);
		main.add(topCounterPane);
		
		topCounterPane.setLayer(topCounter, 1);
		topCounter.setIcon(new ImageIcon(board.class.getResource("/resource/images/frontCounter.png")));
		topCounter.setBounds(0, 0, 640, 95);
		topCounterPane.add(topCounter);
		

		topCounterPane.setLayer(chicken, 2);
		chicken.setIcon(new ImageIcon(board.class.getResource("/resource/images/chicken.png")));
		chicken.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/chickenRollover.png")));
		chicken.setBorderPainted(false);
		chicken.setContentAreaFilled(false);
		chicken.setBounds(89, 6, 90, 40);
		chicken.addActionListener(this);
		topCounterPane.add(chicken);
		
		topCounterPane.setLayer(pork, 2);
		pork.setIcon(new ImageIcon(board.class.getResource("/resource/images/pork.png")));
		pork.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/porkRollover.png")));
		pork.setBorderPainted(false);
		pork.setContentAreaFilled(false);
		pork.setBounds(190, 6, 90, 40);
		pork.addActionListener(this);
		topCounterPane.add(pork);
		
		topCounterPane.setLayer(lettuce, 2);
		lettuce.setIcon(new ImageIcon(board.class.getResource("/resource/images/lettuce.png")));
		lettuce.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/lettuceRollover.png")));
		lettuce.setBorderPainted(false);
		lettuce.setContentAreaFilled(false);
		lettuce.setBounds(290, 6, 90, 40);
		lettuce.addActionListener(this);
		topCounterPane.add(lettuce);
		
		topCounterPane.setLayer(carrot, 2);
		carrot.setIcon(new ImageIcon(board.class.getResource("/resource/images/carrot.png")));
		carrot.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/carrotRollover.png")));
		carrot.setBorderPainted(false);
		carrot.setContentAreaFilled(false);
		topCounterPane.add(carrot);
		carrot.addActionListener(this);
		carrot.setBounds(390, 6, 90, 40);
		
		topCounterPane.setLayer(sink, 2);
		sink.setIcon(new ImageIcon(board.class.getResource("/resource/images/sink.png")));
		sink.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/sinkRollover.png")));
		sink.setBorderPainted(false);
		sink.setBounds(517, 6, 90, 40);
		sink.addActionListener(this);
		topCounterPane.add(sink);
		
		main.setLayer(beef, 1);
		beef.setIcon(new ImageIcon(board.class.getResource("/resource/images/beefButton.png")));
		beef.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/beefButtonRollover.png")));
		beef.setContentAreaFilled(false);
		beef.setBorderPainted(false);
		beef.setBounds(190, 55, 40, 60);
		beef.addActionListener(this);
		main.add(beef);
		
		main.setLayer(drink, 1);
		drink.setIcon(new ImageIcon(board.class.getResource("/resource/images/radio.png")));
		drink.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/radioRollover.png")));
		drink.setContentAreaFilled(false);
		drink.setBorderPainted(false);
		drink.setBounds(240, 5, 90, 40);
		drink.addActionListener(this);
		main.add(drink);
		
		main.setLayer(cuttingBoard, 1);
		cuttingBoard.setIcon(new ImageIcon(board.class.getResource("/resource/images/cuttingBoard.png")));
		cuttingBoard.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/cuttingBoardRollover.png")));
		cuttingBoard.setBorderPainted(false);
		cuttingBoard.setContentAreaFilled(false);
		cuttingBoard.setBounds(665, 5, 90, 40);
		cuttingBoard.addActionListener(this);
		main.add(cuttingBoard);
		
		main.setLayer(stove1, 1);
		stove1.setIcon(new ImageIcon(board.class.getResource("/resource/images/stove1.png")));
		stove1.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/stove1Rollover.png")));
		stove1.setBorderPainted(false);
		stove1.setBounds(385, 0, 90, 47);
		stove1.addActionListener(this);
		main.add(stove1);
		
		main.setLayer(stove2, 1);
		stove2.setIcon(new ImageIcon(board.class.getResource("/resource/images/stove2.png")));
		stove2.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/stove2Rollover.png")));
		stove2.setBorderPainted(false);
		stove2.setBounds(487, 0, 90, 47);
		stove2.addActionListener(this);
		main.add(stove2);
		

		main.setLayer(dishBin, 1);
		dishBin.setIcon(new ImageIcon(board.class.getResource("/resource/images/dishBin.png")));
		dishBin.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/dishBinRollover.png")));
		dishBin.setBounds(925, 10, 70, 105);
		dishBin.setContentAreaFilled(false);
		dishBin.setBorderPainted(false);
		dishBin.addActionListener(this);
		main.add(dishBin);
		
		trashcan.setIcon(new ImageIcon(board.class.getResource("/resource/images/trashcan.png")));
		main.setLayer(trashcan, 1);
		trashcan.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/trashcanRollover.png")));
		trashcan.setContentAreaFilled(false);
		trashcan.setBorderPainted(false);
		trashcan.setBounds(825, 10, 70, 105);
		trashcan.addActionListener(this);
		main.add(trashcan);
		
		main.setLayer(table[1], 5);
		table[1].setBounds(190, 228, 145, 105);
		table[1].addActionListener(this);
		main.add(table[1]);
		
		main.setLayer(table[2], 5);
		table[2].setBounds(435, 228, 145, 105);
		table[2].addActionListener(this);
		main.add(table[2]);
		
		main.setLayer(table[3], 5);
		table[3].setBounds(680, 230, 145, 104);
		table[3].addActionListener(this);
		main.add(table[3]);
		
		main.setLayer(table[4], 5);
		table[4].setBounds(190, 370, 145, 105);
		table[4].addActionListener(this);
		main.add(table[4]);
		
		main.setLayer(table[5], 5);
		table[5].setBounds(435, 370, 145, 104);
		table[5].addActionListener(this);
		main.add(table[5]);
		
		main.setLayer(table[6], 5);
		table[6].setBounds(685, 370, 145, 104);
		table[6].addActionListener(this);
		main.add(table[6]);
		
		main.setLayer(mainHandPane, 6);
		mainHandPane.setBounds(805, 403, 200, 90);
		main.add(mainHandPane);
		
		mainHand[0].setIcon((new ImageIcon(getClass().getResource("/resource/images/handEmpty.png"))));	
		mainHandPane.setLayer(mainHand[0], 1);
		mainHand[0].setBounds(0, 0, 110, 90);
		mainHand[0].setContentAreaFilled(false);
		mainHand[0].addActionListener(this);
		mainHandPane.add(mainHand[0]);
		
		mainHand[1].setIcon((new ImageIcon(getClass().getResource("/resource/images/handEmpty.png"))));
		mainHandPane.setLayer(mainHand[1], 0);
		mainHand[1].setBounds(90, 0, 110, 90);
		mainHand[1].setContentAreaFilled(false);
		mainHand[1].addActionListener(this);
		mainHandPane.add(mainHand[1]);
		
		scoreCounter.setHorizontalAlignment(SwingConstants.LEFT);
		scoreCounter.setFont(new Font("Arial Black", Font.BOLD, 18));
		main.setLayer(scoreCounter, 10);
		scoreCounter.setBounds(60, 0, 95, 30);
		main.add(scoreCounter);
		
		score.setIcon(new ImageIcon(board.class.getResource("/resource/images/scoreCounter.png")));
		main.setLayer(score, 10);
		score.setBounds(15, 0, 45, 30);
		main.add(score);
		
		main.setLayer(dishes, 10);
		dishes.setIcon(new ImageIcon(board.class.getResource("/resource/images/plateCounter.png")));
		dishes.setHorizontalAlignment(SwingConstants.LEFT);
		dishes.setFont(new Font("Arial Black", Font.BOLD, 18));
		dishes.setBounds(15, 32, 45, 30);
		main.add(dishes);
		
		dishCount.setFont(new Font("Arial Black", Font.BOLD, 18));
		main.setLayer(dishCount, 10);
		dishCount.setBounds(60, 32, 95, 30);
		main.add(dishCount);
		

		main.setLayer(saveButton, 10);
		saveButton.setToolTipText("Saves the game");
		saveButton.setIcon(new ImageIcon(board.class.getResource("/resource/images/save.png")));
		saveButton.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/saveRollover.png")));
		saveButton.setContentAreaFilled(false);
		saveButton.setBorderPainted(false);
		saveButton.setBounds(15, 347, 60, 60);
		saveButton.addActionListener(this);
		main.add(saveButton);
		
		backButton.setIcon(new ImageIcon(board.class.getResource("/resource/images/back1.png")));
		backButton.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/back1Rollover.png")));
		backButton.setToolTipText("Return to the menu");
		main.setLayer(backButton, 10);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setBounds(15, 420, 60, 60);
		backButton.addActionListener(this);
		main.add(backButton);
		
		main.setLayer(multiplierIcon, 10);
		multiplierIcon.setIcon(new ImageIcon(board.class.getResource("/resource/images/multiplierLogo.png")));
		multiplierIcon.setHorizontalAlignment(SwingConstants.LEFT);
		multiplierIcon.setFont(new Font("Arial Black", Font.BOLD, 18));
		multiplierIcon.setBounds(15, 65, 45, 30);
		
		main.add(multiplierIcon);
		main.setLayer(multiplierLbl, 10);
		multiplierLbl.setHorizontalAlignment(SwingConstants.LEFT);
		multiplierLbl.setFont(new Font("Arial Black", Font.BOLD, 24));
		multiplierLbl.setBounds(60, 65, 95, 30);
		main.add(multiplierLbl);
		
		main.setLayer(cookBook, 10);
		cookBook.setIcon(new ImageIcon(board.class.getResource("/resource/images/cookbook.png")));
		cookBook.setToolTipText("Tells you how to make each dish");
		cookBook.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/cookbookRollover.png")));
		cookBook.setContentAreaFilled(false);
		cookBook.setBorderPainted(false);
		cookBook.setBounds(15, 265, 60, 60);
		cookBook.addActionListener(this);
		main.add(cookBook);

		
		
	
		spawnTable();
		
	}
	
	private void randomSong(){//picks a random song
			Random rand = new Random();
			int bgm;
			
			do{
				bgm= rand.nextInt((songs-1)+1)+1;
			}while(bgm==currentBgm);//next song cannot be current song
			
			audioPlayer.playBgm(bgm);
			currentBgm=bgm;
	}
	
	private void move(){//moves player
		if(playerPane.getY()>126){
			main.setLayer(table[1],1);
			main.setLayer(table[2],1);
			main.setLayer(table[3],1);
		}
		else if(playerPane.getY()>0){
			main.setLayer(playerPane, 4);

		}
		
		if(playerPane.getY()<126){
			main.setLayer(table[1],5);
			main.setLayer(table[2],5);
			main.setLayer(table[3],5);

		}
		if(playerPane.getY()==0){
			main.setLayer(playerPane, 2);
		}

		if(playerPane.getY()==player.getGoalY() && playerPane.getX() == player.getGoalX()){
			action();
			player.setGoal("null");
		}
		else if (playerPane.getY()==player.getGoalY()){
			moveX();
		}
		else if(playerPane.getX()==checkpoint){
			moveY();
		}
		else{
			moveCheckpoint();
		}
	}	
	
	private void moveCheckpoint(){//move player to center checkpoint
		if(playerPane.getX()<checkpoint){
			if((checkpoint-playerPane.getX())<speed){ //right
				playerPane.setBounds(playerPane.getX()+(checkpoint-playerPane.getX()),playerPane.getY(),playerPane.getWidth(),playerPane.getHeight());
			}
			else{
			playerPane.setBounds(playerPane.getX()+speed,playerPane.getY(),playerPane.getWidth(),playerPane.getHeight());
			}
			player.setDirection(2);
		}
		if(playerPane.getX()>checkpoint){
			if((playerPane.getX()-checkpoint)<speed){ //left
				playerPane.setBounds(playerPane.getX()-(playerPane.getX()-checkpoint),playerPane.getY(),playerPane.getWidth(),playerPane.getHeight());
			}
			else{
			playerPane.setBounds(playerPane.getX()-speed,playerPane.getY(),playerPane.getWidth(),playerPane.getHeight());
			}
			player.setDirection(4);
		}
		
	}
	private void moveY(){//move player vertically
		if(playerPane.getY()<player.getGoalY()){
			if((player.getGoalY()-playerPane.getY())<speed){ //down
				playerPane.setBounds(playerPane.getX(),playerPane.getY()+(player.getGoalY()-playerPane.getY()),playerPane.getWidth(),playerPane.getHeight());
			}
			else{
			playerPane.setBounds(playerPane.getX(),playerPane.getY()+speed,playerPane.getWidth(),playerPane.getHeight());
			}
			player.setDirection(3);
		}
		if(playerPane.getY()>player.getGoalY()){
			if((playerPane.getY()-player.getGoalY())<speed){ //up
				playerPane.setBounds(playerPane.getX(),playerPane.getY()-(playerPane.getY()-player.getGoalY()),playerPane.getWidth(),playerPane.getHeight());
			}
			else{
			playerPane.setBounds(playerPane.getX(),playerPane.getY()-speed,playerPane.getWidth(),playerPane.getHeight());
			}
			player.setDirection(1);
		}
		
	}
	private void moveX(){//move player horozonzally
		if(playerPane.getX()<player.getGoalX()){//right
			if((player.getGoalX()-playerPane.getX())<speed){ //right
				playerPane.setBounds(playerPane.getX()+(player.getGoalX()-playerPane.getX()),playerPane.getY(),playerPane.getWidth(),playerPane.getHeight());
			}
			else{
			playerPane.setBounds(playerPane.getX()+speed,playerPane.getY(),playerPane.getWidth(),playerPane.getHeight());
			}
			player.setDirection(2);
		}
		if(playerPane.getX()>player.getGoalX()){//left
			if((playerPane.getX()-player.getGoalX())<speed){ //left
				playerPane.setBounds(playerPane.getX()-(playerPane.getX()-player.getGoalX()),playerPane.getY(),playerPane.getWidth(),playerPane.getHeight());
			}
			else{
			playerPane.setBounds(playerPane.getX()-speed,playerPane.getY(),playerPane.getWidth(),playerPane.getHeight());
			}
			player.setDirection(4);
		}
	}
	
	public void action(){//preforms actions
		
		//set looking direction
		if(player.getGoal().equalsIgnoreCase("table1")||player.getGoal().equalsIgnoreCase("table2")||player.getGoal().equalsIgnoreCase("table3")||player.getGoal().equalsIgnoreCase("table4")||player.getGoal().equalsIgnoreCase("table5")||player.getGoal().equalsIgnoreCase("table6")){
			player.setDirection(3);//down
			tableAction();
		}
		else if(player.getGoal().equalsIgnoreCase("pork")||player.getGoal().equalsIgnoreCase("chicken")||player.getGoal().equalsIgnoreCase("carrot")||player.getGoal().equalsIgnoreCase("lettuce")||player.getGoal().equalsIgnoreCase("sink")){
			player.setDirection(3);//down
			sinkAction();
			ingredientsAction();
		}
		else if(player.getGoal().equalsIgnoreCase("beef")){
			player.setDirection(4);//left
			ingredientsAction();
		}
		else if(player.getGoal().equalsIgnoreCase("drink")||player.getGoal().equalsIgnoreCase("stove1")||player.getGoal().equalsIgnoreCase("stove2")||player.getGoal().equalsIgnoreCase("cuttingBoard")||player.getGoal().equalsIgnoreCase("trashcan")||player.getGoal().equalsIgnoreCase("dishBin")){
			player.setDirection(1);//up
			trashcanAction();
			stoveAction();
			dishBinAction();
			choppingAction();
		}
	}
	
	public void choppingAction(){//preforms chopping board specific actions
		if(player.getGoal().equalsIgnoreCase("cuttingBoard")){
			if(hand[player.getMainHand()].isChopped()==false){
				if(chopping==false && choppingBoardF.isEmpty()==true&&hand[player.getMainHand()].isEmpty()==false&&hand[player.getMainHand()].onlyDish()==false&&hand[player.getMainHand()].isDrink()==false){
					copy(choppingBoardF,hand[player.getMainHand()]);
					hand[player.getMainHand()].reset();
					audioPlayer.play("/resource/audio/chopSFX.wav");
					chopping=true;
					
				}
				else if(chopping==false && choppingBoardF.isEmpty()==false&&hand[player.getMainHand()].isEmpty()==true){
					copy(hand[player.getMainHand()],choppingBoardF);
					choppingBoardF.reset();
				}
			}
		}
	}
	
	public void stoveAction(){//preforms stove specific actions
		if(player.getGoal().equalsIgnoreCase("stove1")||player.getGoal().equalsIgnoreCase("stove2")){
			
			if(hand[player.getMainHand()].isCooked()==false){
				
				if(player.getGoal().equalsIgnoreCase("stove1")){
					
					if(cooking1==false&&hand[player.getMainHand()].onlyDish()==false&&hand[player.getMainHand()].isEmpty()==false&&hand[player.getMainHand()].isDrink()==false){
						copy(stoveF[0] , hand[player.getMainHand()]);
						hand[player.getMainHand()].reset();
						audioPlayer.play("/resource/audio/cookSFX.wav");
						player.setScore(player.getScore()-10);
						cooking1=true;
					}
					if(cooking1==false&&hand[player.getMainHand()].isEmpty()==true){
						copy(hand[player.getMainHand()],stoveF[0]);
						stoveF[0].reset();
					}
				}
				if(player.getGoal().equalsIgnoreCase("stove2")){
					
					if(cooking2==false&&hand[player.getMainHand()].onlyDish()==false&&hand[player.getMainHand()].isEmpty()==false&&hand[player.getMainHand()].isDrink()==false){
						copy(stoveF[1] , hand[player.getMainHand()]);
						audioPlayer.play("/resource/audio/cookSFX.wav");
						hand[player.getMainHand()].reset();
						player.setScore(player.getScore()-20);
						cooking2=true;
					}
					if(cooking2==false&&hand[player.getMainHand()].isEmpty()==true){
						copy(hand[player.getMainHand()],stoveF[1]);
						stoveF[1].reset();
					}
				}
			}
		}
	}
	
	
	public void ingredientsAction(){//preforms ingredients specific actions

		if(hand[player.getMainHand()].isDish()==true){
			if(hand[player.getMainHand()].onlyDish()==true){
				if(player.getGoal().equalsIgnoreCase("pork")){
					hand[player.getMainHand()].reset();
					hand[player.getMainHand()].setPork(true);
					player.setScore(player.getScore()-50);
				}
				else if(player.getGoal().equalsIgnoreCase("beef")){
					
					hand[player.getMainHand()].reset();
					hand[player.getMainHand()].setBeef(true);
					player.setScore(player.getScore()-50);
				}
				else if(player.getGoal().equalsIgnoreCase("chicken")){
					
					hand[player.getMainHand()].reset();
					hand[player.getMainHand()].setChicken(true);
					player.setScore(player.getScore()-50);
				}
				else if(player.getGoal().equalsIgnoreCase("carrot")){
					
					hand[player.getMainHand()].reset();
					hand[player.getMainHand()].setCarrot(true);
					player.setScore(player.getScore()-50);
				}
				else if(player.getGoal().equalsIgnoreCase("lettuce")){
					
					hand[player.getMainHand()].reset();
					hand[player.getMainHand()].setLettuce(true);
					player.setScore(player.getScore()-50);
				}
				else if(player.getGoal().equalsIgnoreCase("drink")){
					
					hand[player.getMainHand()].reset();
					hand[player.getMainHand()].setDrink(true);
					player.setScore(player.getScore()-50);
				}
				hand[player.getMainHand()].setEmpty(false);
				audioPlayer.play("/resource/audio/openSFX.wav");
			}
		}
	}
	
	public void dishBinAction(){//preforms dishBin specific actions
		
		if(player.getGoal().equalsIgnoreCase("dishBin")){
			if(hand[player.getMainHand()].isDish()==false){
				hand[player.getMainHand()].setDish(true);
				hand[player.getMainHand()].setEmpty(false);
				int sfx = rand.nextInt(2)+1;
				for(int y = 1;y<3;y++){//play random audio
					if(sfx==y){
						audioPlayer.play("/resource/audio/dishSFX"+Integer.toString(y)+".wav");
					}
				}
				dishCounter--;
				if(dishCounter<0){
					player.setScore(player.getScore()-10);
				}
			}
		}
	}
	
	public void trashcanAction(){//preforms trashcan specific actions
		if(player.getGoal().equalsIgnoreCase("trashcan")){
			hand[player.getMainHand()].reset();
			audioPlayer.play("/resource/audio/trashSFX.wav");

		}
	}
	
	public void animatePlayer(){//checks player direction and updates the player icon
		if(player.getDirection()==1){
			playerLabel.setIcon(new ImageIcon(getClass().getResource("/resource/images/placeHolderPlayerUp.png")));
		}
		else if(player.getDirection()==2){
			playerLabel.setIcon(new ImageIcon(getClass().getResource("/resource/images/placeHolderPlayerRight.png")));
		}
		else if(player.getDirection()==3){
			playerLabel.setIcon(new ImageIcon(getClass().getResource("/resource/images/placeHolderPlayerDown.png")));
		}
		else if(player.getDirection()==4){
			playerLabel.setIcon(new ImageIcon(getClass().getResource("/resource/images/placeHolderPlayerLeft.png")));
		}
		
	}
	
	public void refreshImage(){//checks the conditions for some icons and refreshes them
		dishCount.setText("X" + Integer.toString(dishCounter));
		
		stars=(int)(5*((multiplier*100)/60));
		multiplierLbl.setIcon(new ImageIcon(board.class.getResource("/resource/images/"+stars+"star.png")));//updates the multiplier label
		
		if(stoveF[0].isEmpty()==true){//updates stoves icon based on whats happening
			stove1.setIcon(new ImageIcon(board.class.getResource("/resource/images/stove1.png")));
			stove1.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/stove1Rollover.png")));
		}
		else if(cooking1==true){
			stove1.setIcon(new ImageIcon(board.class.getResource("/resource/images/cook.gif")));
			stove1.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/cookRollover.gif")));
			
		}
		else{
			stove1.setIcon(new ImageIcon(board.class.getResource("/resource/images/cooked.png")));
			stove1.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/cookedRollover.png")));
		}
		if(stoveF[1].isEmpty()==true){
			stove2.setIcon(new ImageIcon(board.class.getResource("/resource/images/stove2.png")));
			stove2.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/stove2Rollover.png")));
		}
		else if(cooking2==true){
			stove2.setIcon(new ImageIcon(board.class.getResource("/resource/images/cook.gif")));
			stove2.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/cookRollover.gif")));
			
		}
		else{
			stove2.setIcon(new ImageIcon(board.class.getResource("/resource/images/cooked.png")));
			stove2.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/cookedRollover.png")));
		}
		if(choppingBoardF.isEmpty()==true){
			cuttingBoard.setIcon(new ImageIcon(board.class.getResource("/resource/images/cuttingBoard.png")));
			cuttingBoard.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/cuttingBoardRollover.png")));
		}
		else if(chopping==true){
			cuttingBoard.setIcon(new ImageIcon(board.class.getResource("/resource/images/chop.gif")));
			cuttingBoard.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/chopRollover.gif")));
			
		}
		else{
			cuttingBoard.setIcon(new ImageIcon(board.class.getResource("/resource/images/chopped.png")));
			cuttingBoard.setRolloverIcon(new ImageIcon(board.class.getResource("/resource/images/choppedRollover.png")));
		}
		for(int x =0;x<2;x++){//updates hand image based on whats in hand

			if(hand[x].isDish()==true){
				mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handDish.png")));
			}
			if(hand[x].isDishDirty()==true){
				mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handDirtyDish.png")));
			}
			if(hand[x].isEmpty()==true){
				if(x==0){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handEmptyRight.png")));
				}
				if(x==1){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handEmptyLeft.png")));
				}
			}
			if(hand[x].isBeef()==true){
				if(hand[x].isCooked()==true&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handBeef11.png")));
				}
				else if(hand[x].isCooked()==true&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handBeef10.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handBeef01.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handBeef00.png")));
				}
				else{
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handEmpty.png")));
				}
			}
			if(hand[x].isChicken()==true){
				if(hand[x].isCooked()==true&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handChicken11.png")));
				}
				else if(hand[x].isCooked()==true&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handChicken10.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handChicken01.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handChicken00.png")));
				}
				else{
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handEmpty.png")));
				}
			}
			if(hand[x].isPork()==true){
				if(hand[x].isCooked()==true&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handPork11.png")));
				}
				else if(hand[x].isCooked()==true&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handPork10.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handPork01.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handPork00.png")));
				}
				else{
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handEmpty.png")));
				}
			}
			if(hand[x].isCarrot()==true){
				if(hand[x].isCooked()==true&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handCarrot11.png")));
				}
				else if(hand[x].isCooked()==true&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handCarrot10.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handCarrot01.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handCarrot00.png")));
				}
				else{
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handEmpty.png")));
				}
			}
			if(hand[x].isLettuce()==true){
				if(hand[x].isCooked()==true&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handLettuce11.png")));
				}
				else if(hand[x].isCooked()==true&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handLettuce10.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==true){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handLettuce01.png")));
				}
				else if(hand[x].isCooked()==false&&hand[x].isChopped()==false){
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handLettuce00.png")));
				}
				else{
					mainHand[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/handEmpty.png")));
				}
			}	
		}
		for(int x =1;x<7;x++){//updates table image based on what each table wants
			
			if(tableF[x].isDish()==true){
				table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableDish.png")));
			}
			if(tableF[x].isDishDirty()==true){
				table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableDirtyDish.png")));
			}
			if(tableF[x].isEmpty()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableEmpty.png")));

				}
			if(tableF[x].isBeef()==true){
				if(tableF[x].isCooked()==true&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableBeef11.png")));
				}
				else if(tableF[x].isCooked()==true&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableBeef10.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableBeef01.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableBeef00.png")));
				}
				else{
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableEmpty.png")));
				}
			}
			if(tableF[x].isChicken()==true){
				if(tableF[x].isCooked()==true&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableChicken11.png")));
				}
				else if(tableF[x].isCooked()==true&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableChicken10.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableChicken01.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableChicken00.png")));
				}
				else{
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableEmpty.png")));
				}
			}
			if(tableF[x].isPork()==true){
				if(tableF[x].isCooked()==true&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tablePork11.png")));
				}
				else if(tableF[x].isCooked()==true&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tablePork10.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tablePork01.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tablePork00.png")));
				}
				else{
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableEmpty.png")));
				}
			}
			if(tableF[x].isCarrot()==true){
				if(tableF[x].isCooked()==true&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableCarrot11.png")));
				}
				else if(tableF[x].isCooked()==true&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableCarrot10.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableCarrot01.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableCarrot00.png")));
				}
				else{
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableEmpty.png")));
				}
			}
			if(tableF[x].isLettuce()==true){
				if(tableF[x].isCooked()==true&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableLettuce11.png")));
				}
				else if(tableF[x].isCooked()==true&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableLettuce10.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==true){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableLettuce01.png")));
				}
				else if(tableF[x].isCooked()==false&&tableF[x].isChopped()==false){
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableLettuce00.png")));
				}
				else{
					table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableEmpty.png")));
				}
			}
			if(eating[x]==true){
				table[x].setIcon(new ImageIcon(getClass().getResource("/resource/images/tableEat.gif")));
			}
		}
		scoreCounter.setText("$"+Integer.toString(player.getScore()));
	}
	
	public void tableAction(){//preforms actions specific to tables
		for(int x = 1;x<7;x++){
			if(player.getGoal().equalsIgnoreCase("table"+x)){
				if (compare(hand[player.getMainHand()],tableF[x])&&tableF[x].isDishDirty()==false&&tableF[x].isEmpty()==false){
					eating[x] = true;
					tableWaiting[x]=false;
					tableCounter[x]=0;
					hand[player.getMainHand()].reset();
					int sfx = rand.nextInt(4)+1;
					for(int y = 1;y<5;y++){//play random audio
						if(sfx==y){
							audioPlayer.play("/resource/audio/eatSFX"+Integer.toString(y)+".wav");
						}
					}
				}
				if(hand[player.getMainHand()].isEmpty()==true&&tableF[x].isDishDirty()==true){
					hand[player.getMainHand()].setEmpty(false);
					hand[player.getMainHand()].setDishDirty(true);
					tableF[x].reset();
				}
			}
			
		}
	}
	
	public void sinkAction(){//performs actions specific to the sink
		if(player.getGoal().equalsIgnoreCase("sink")){
			if(hand[player.getMainHand()].isDishDirty()==true){
				dishCounter++;
						audioPlayer.play("/resource/audio/sinkSFX.wav");
				hand[player.getMainHand()].reset();
			}
		}
	}
	
	public boolean compare(food a , food b){
		if(a.isBeef()==b.isBeef()&&a.isPork()==b.isPork()&&a.isChicken()==b.isChicken()
			&&a.isLettuce()==b.isLettuce()&&a.isCarrot()==b.isCarrot()
			&&a.isCooked()==b.isCooked()&&a.isChopped()==b.isChopped()&&a.isDishDirty()==b.isDishDirty()){
			return true;
		}
		else
			return false;
	}
	
	public void spawnTable(){//randomly picks a table 

		int tableNumber;
		
		do{
			tableNumber= rand.nextInt((6-1)+1)+1;
		}while(tableF[tableNumber].isEmpty()==false);
			
			tableWaiting[tableNumber]=true;
			order(tableNumber);
			audioPlayer.play("/resource/audio/enterSFX.wav");
			
	}
	
	public void order(int x){//randomly generates a order
		int mainIng = rand.nextInt((5-1)+1)+1;
		int chopped = rand.nextInt((2-1)+1)+1;
		tableF[x].setCooked(true);
		tableF[x].setEmpty(false);
		if(mainIng==1){
			tableF[x].setBeef(true);
		}
		else if(mainIng==2){
			tableF[x].setPork(true);
		}
		else if(mainIng==3){
			tableF[x].setChicken(true);
		}
		else if(mainIng==4){
			tableF[x].setLettuce(true);
		}
		else if(mainIng==5){
			tableF[x].setCarrot(true);
		}
		if(chopped==2){
			tableF[x].setChopped(true);
		}
		
	}
	
	public void copy(food a, food b){//copies one food object properties to another
		a.setBeef(b.isBeef());
		a.setPork(b.isPork());
		a.setChicken(b.isChicken());
		a.setLettuce(b.isLettuce());
		a.setCarrot(b.isCarrot());
		a.setDish(b.isDish());
		a.setDishDirty(b.isDishDirty());
		a.setEmpty(b.isEmpty());
		a.setChopped(b.isChopped());
		a.setCooked(b.isCooked());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== saveButton){
			new save();
		}
		
		if(e.getSource()== mainHand[0]){
			mainHandPane.setLayer(mainHand[0], 1);
			mainHandPane.setLayer(mainHand[1], 0);
			player.setMainHand(0);
		}
		
		if(e.getSource()== mainHand[1]){
			mainHandPane.setLayer(mainHand[1], 1);
			mainHandPane.setLayer(mainHand[0], 0);
			player.setMainHand(1);
		}
		
		for(int x =1;x<7;x++){
			if(e.getSource()== table[x]){
				player.setGoal("table"+x);
			}
		}
		
		if(e.getSource()== backButton){
			audioPlayer.playBgm(1);
			board.dispose();
		}
		
		if(e.getSource()== beef){
			player.setGoal("beef");
		}
		if(e.getSource()== drink){
			randomSong();
		}
		if(e.getSource()== stove1){
			player.setGoal("stove1");
			
		}if(e.getSource()== stove2){
			player.setGoal("stove2");
		}
		
		if(e.getSource()== cuttingBoard){
			player.setGoal("cuttingBoard");
		}
		
		if(e.getSource()== pork){
			player.setGoal("pork");
		}
		
		if(e.getSource()== chicken){
			player.setGoal("chicken");
		}
		
		if(e.getSource()== lettuce){
			player.setGoal("lettuce");
		}
		
		if(e.getSource()== carrot){
			player.setGoal("carrot");
		}
		
		if(e.getSource()== sink){
			player.setGoal("sink");
		}
		
		if(e.getSource()== trashcan){
			player.setGoal("trashcan");
		}
		
		if(e.getSource()== dishBin){
			player.setGoal("dishBin");
		}
		if(e.getSource()== cookBook){
			new cookbook();
		}
		

		if(e.getSource()==gameTimer){
			openTables=6;
			animatePlayer();
			refreshImage();
			
			if(multiplierTime<600){//multiplier goes up every 1 min
				multiplierTime++;

				
		}
			else if(multiplier<0.6&&multiplierTime==600){
				multiplier= multiplier+0.05;
				spawnTime=spawnTime-(int)(0.05*700);
				maxTip=maxTip+(int)(0.05*tip);
				multiplierTime=0;
			}
			for(int x = 1; x<7;x++){
				if(tableF[x].isEmpty()==false)
					openTables--;
			}
				if(spawnCounter<spawnTime&&openTables>0){
					spawnCounter++;

				}
				else if (spawnCounter==spawnTime){
					spawnTable();
					spawnCounter=0;
				
			}
			for(int x = 1; x<7;x++){
				if(tableWaiting[x]==true&&tableCounter[x]<patience){
					tableCounter[x]++;
				}
				else if(tableCounter[x]==patience){
					tableF[x].reset();
					tableWaiting[x]=false;
					tableCounter[x]=0;
					
					spawnTime=spawnTime+(int)(0.1*700);//multiplier goes down when u miss a customer
					maxTip=maxTip-(int)(0.1*tip);
					multiplierTime=0;
					if(multiplier-0.1>0){
						multiplier= multiplier-0.1;
						
					}
					int sfx = rand.nextInt(3)+1;
					for(int y = 1;y<4;y++){//play random audio
						if(sfx==y){
							audioPlayer.play("/resource/audio/leaveSFX"+Integer.toString(y)+".wav");
						}
					}
				}
			}	
			for(int x = 1; x<7;x++){
				if(eating[x]==true&&eatingCounter[x]<eatMax){
					eatingCounter[x]++;
				}
				if(eating[x]==true&&eatingCounter[x]==eatMax){
					eating[x]=false;
					eatingCounter[x]=0;
					player.setScore(player.getScore()+100+rand.nextInt((maxTip-5)+1)+5);
					tableF[x].reset();
					tableF[x].setDishDirty(true);
					tableF[x].setEmpty(false);
					audioPlayer.play("/resource/audio/moneySFX.wav");

				}
			}	
			
			if(player.getGoal()!= "null"){
				move();
			}
			
			if(cooking1==true&&cookingCounter1<cookingSpeed){
				cookingCounter1++;
			}
			else if(cookingCounter1==cookingSpeed){
				cooking1=false;
				audioPlayer.play("/resource/audio/doneSFX.wav");
				cookingCounter1=0;
				stoveF[0].setCooked(true);
			}
			if(cooking2==true&&cookingCounter2<cookingSpeed){
				cookingCounter2++;
			}
			else if(cookingCounter2==cookingSpeed){
				cooking2=false;
				audioPlayer.play("/resource/audio/doneSFX.wav");
				cookingCounter2=0;
				stoveF[1].setCooked(true);
			}
			
			if(chopping==true&&choppingCounter<cuttingSpeed){
				choppingCounter++;
			}
			else if(choppingCounter==cuttingSpeed){
				chopping=false;
				audioPlayer.play("/resource/audio/doneSFX.wav");
				choppingCounter=0;
				choppingBoardF.setChopped(true);
			}
			
		}
		if(e.getSource()==startMusic){
			randomSong();
		}
	}
}


