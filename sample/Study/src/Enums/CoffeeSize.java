package Enums;

public enum CoffeeSize {

	BIG(8), 	MEDIUM(4), 	SMALL(2);
	
	CoffeeSize(int ounces){
		this.ounces = ounces;
	}
	private int ounces;
	
	public int getOunces(){
		return ounces;
	}
}
