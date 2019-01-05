package Enums;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EnumsOutside  enumOut = new EnumsOutside();
		enumOut.size = CoffeeSize.BIG;
		System.out.println(enumOut.size);
		
		EnumInside inside = new EnumInside();
		inside.size = EnumInside.CoffeeSize.SMALL;
		System.out.println(inside.size);
		
		Coffee drink1 = new Coffee();
		Coffee drink2 = new Coffee();
		
		drink1.size = CoffeeSize.BIG;
		drink2.size = CoffeeSize.MEDIUM;
		System.out.println(drink1.size.getOunces());
		System.out.println(drink2.size.getOunces());
		
		for(CoffeeSize cs: CoffeeSize.values()){
			System.out.println(cs +" " +cs.getOunces());
		}
		
		
		

	}

}
