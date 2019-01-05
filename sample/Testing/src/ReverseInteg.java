
public class ReverseInteg {

	
	/***
	 * Given an Integer write a function to reverse it
	 * i.e reverse an ordering of numbers
	 * eg
	 * reverseint(15) == 51
	 * reverseint(-15) == -51
	 * reverseint(500) == 5 //ignore 0 es
	 * 
	 * ***/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//reverseUsingModulo();
		//reverseInt();
		reverseUsingModulo();

	}
	
	public static void reverseInt(){
		
		//1) Take the number
		//2) Check for negative number
		//3) Convert it to string using Integer.toString and store it to string buffer
		//4) Reverse it using string buffer's reverse method
		//5) COnvert it to Integer again using Integer.valueOf
		
		//Take a value
		int number = -51;
		int toRevers = number;
	//	System.out.println("Math" + Math.signum(number));
		
		if(number < 0)
			toRevers =  number*-1; 
		
		System.out.println("Number to Reverse " +number);
		String numb = Integer.toString(toRevers);
		//String numberAsString = String.valueOf(number);
		System.out.println("Reverse "+numb);
		
		StringBuffer sb = new StringBuffer(numb).reverse();
		String revString = sb.toString();
		//int reverserInt =  Integer.parseInt(revString);
		Integer result = Integer.valueOf(revString);	
		if(number < 0)
			result =  result*-1; 
		System.out.println("Result "+result);
	
	}

	/*Reverse Using Modulo*/
	public static void reverseUsingModulo(){
		
		int number = -56;
		int reverse = 0;
		int lastDigit = 0;
	
		boolean isNegative = number < 0 ? true: false;
	
		if(isNegative)
			number = number * -1;
	
		while(number > 1){
		
			lastDigit = number%10;
			reverse = reverse * 10 + lastDigit;
			number = number/10;
		}
	
		if(isNegative)
			reverse = reverse*-1;
	
		System.out.println("Reverse" + reverse);
	}
}
