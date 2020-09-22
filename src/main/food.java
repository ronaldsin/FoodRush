package main;

public class food {
	private boolean beef= false;
	private boolean chicken= false;
	private boolean pork= false;
	private boolean lettuce= false;
	private boolean carrot= false;
	private boolean drink= false;
	//the amount of each ingredient is in the dish
	
	private boolean empty=true;
	
	private boolean cooked = false;
	private boolean chopped= false;
	
	private boolean dish= false;
	private boolean dishDirty= false;
	


	public boolean onlyDish() {
		if(!beef&&!chicken&&!pork&&!lettuce&&!carrot&&!drink){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isBeef() {
		return beef;
	}



	public void setBeef(boolean beef) {
		this.beef = beef;
	}



	public boolean isChicken() {
		return chicken;
	}



	public void setChicken(boolean chicken) {
		this.chicken = chicken;
	}



	public boolean isPork() {
		return pork;
	}



	public void setPork(boolean pork) {
		this.pork = pork;
	}



	public boolean isLettuce() {
		return lettuce;
	}



	public void setLettuce(boolean lettuce) {
		this.lettuce = lettuce;
	}



	public boolean isCarrot() {
		return carrot;
	}



	public void setCarrot(boolean carrot) {
		this.carrot = carrot;
	}



	public boolean isDrink() {
		return drink;
	}



	public void setDrink(boolean drink) {
		this.drink = drink;
	}



	public boolean isCooked() {
		return cooked;
	}



	public void setCooked(boolean cooked) {
		this.cooked = cooked;
	}



	public boolean isChopped() {
		return chopped;
	}



	public void setChopped(boolean chopped) {
		this.chopped = chopped;
	}



	public boolean isDish() {
		return dish;
	}



	public void setDish(boolean dish) {
		this.dish = dish;
	}



	public boolean isDishDirty() {
		return dishDirty;
	}



	public void setDishDirty(boolean dishDirty) {
		this.dishDirty = dishDirty;
	}



	public boolean isEmpty() {
		return empty;
	}



	public void setEmpty(boolean empty) {
		this.empty = empty;
	}



	public void reset() {
		empty=true;
		beef=false;
		chicken=false;
		pork=false;
		lettuce=false;
		carrot=false;
		drink =false;
		dish=false;
		dishDirty=false;
		cooked=false;
		chopped=false;
	}
	
}
