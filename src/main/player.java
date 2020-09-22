package main;

public class player {
	static int goalX;//goals x 
	static int goalY;//goals y
	static int speed;//the player speed
	static int cook;//cooking speed
	static int cut;//cutting speed
	static int deco;//customer wait time
	static int dish;//number of dishes
	static int drink;//customer tip amount
	static int mainHand = 0; // currently selected hand
	static int score;
	static int direction;
//	1-up
//	2-right
//	3-down
//	4-left
	
	private String goal = "null";
	//what the players current goal is
	//drink
	//stove1
	//stove2
	//cuttingBoard
	//dishBin
	//trashcan
	//beef
	//chicken
	//pork
	//lettuce
	//carrot
	//sink
	//table1(row1 1 table from the left,212,125), table2(row1 2 table from the left), table3...table6(row2 3 table from the left)
	
	private boolean busy = false; //if player is currently performing an action
	public int getScore(){
		return score;
	}
	public void setScore(int score) {
		player.score = score;
	}
	public int getGoalX() {
		return goalX;
	}
	public void setGoalX(int goalX) {
		player.goalX = goalX;
	}
	public int getGoalY() {
		return goalY;
	}
	public void setGoalY(int goalY) {
		player.goalY = goalY;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		player.speed = speed;
	}
	public int getCook() {
		return cook;
	}
	public void setCook(int cook) {
		player.cook = cook;
	}
	public int getCut() {
		return cut;
	}
	public void setCut(int cut) {
		player.cut = cut;
	}
	public int getDeco() {
		return deco;
	}
	public void setDeco(int deco) {
		player.deco = deco;
	}
	public int getDish() {
		return dish;
	}
	public void setDish(int dish) {
		player.dish = dish;
	}
	public int getDrink() {
		return drink;
	}
	public void setDrink(int drink) {
		player.drink = drink;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	public int getMainHand() {
		return mainHand;
	}
	public void setMainHand(int mainHand) {
		player.mainHand = mainHand;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		player.direction = direction;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
		for(int x =1;x<7;x++){
			if(x<4){
				if(goal.equalsIgnoreCase("table"+Integer.toString(x))){
					setGoalY(125);
				}
			}
			else if(x>3){
				if(goal.equalsIgnoreCase("table"+Integer.toString(x))){
					setGoalY(265);
				}
			}
			if(!goal.equalsIgnoreCase("table1")&&!goal.equalsIgnoreCase("table2")&&!goal.equalsIgnoreCase("table3")&&!goal.equalsIgnoreCase("table4")&&!goal.equalsIgnoreCase("table5")&&!goal.equalsIgnoreCase("table6")){
				setGoalY(0);
			}
		}
		if(goal.equalsIgnoreCase("table1")||goal.equalsIgnoreCase("table4")){
			setGoalX(212);
		}
		
		if(goal.equalsIgnoreCase("table2")||goal.equalsIgnoreCase("table5")){
			setGoalX(457);
		}
		
		if(goal.equalsIgnoreCase("table3")||goal.equalsIgnoreCase("table6")){
			setGoalX(702);
		}
		
		if(goal.equalsIgnoreCase("pork")){
			setGoalX(335);
		}
		if(goal.equalsIgnoreCase("chicken")){
			setGoalX(230);
		}
		if(goal.equalsIgnoreCase("beef")){
			setGoalX(225);
		}
		if(goal.equalsIgnoreCase("lettuce")){
			setGoalX(435);
		}
		if(goal.equalsIgnoreCase("carrot")){
			setGoalX(535);
		}
		if(goal.equalsIgnoreCase("sink")){
			setGoalX(660);
		}
		if(goal.equalsIgnoreCase("drink")){
			setGoalX(225);
		}
		if(goal.equalsIgnoreCase("stove1")){
			setGoalX(380);
		}
		if(goal.equalsIgnoreCase("stove2")){
			setGoalX(480);
		}
		if(goal.equalsIgnoreCase("cuttingBoard")){
			setGoalX(660);
		}
		if(goal.equalsIgnoreCase("dishBin")){
			setGoalX(910);
		}
		if(goal.equalsIgnoreCase("trashcan")){
			setGoalX(810);
		}
		
	}
	public boolean isBusy() {
		return busy;
	}
	public void setBusy(String busy) {
		if(busy.equalsIgnoreCase("true")){
			this.busy=true;
		}
		else{
			this.busy=false;
		}
	}
	
	
}
