
public class FizzBuzz {

	/***
	 * 
	 * Write a program that console logs the number from 1 to n
	 * But for multiples of three print Fizz and for the multiples
	 * of 5 print buzz, For numbers which are multiples of both 3 and 5
	 * print FizzBuzz
	 * ***/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzBuzz();
	}
	
	public static void fizzBuzz(){
		
		int n = 15;
		
		for (int i=1; i<=n;i++){
			System.out.println("number " +i);
			if(i%3 == 0 && i%5==0)
				System.out.println("FIZZBUZZ");
			else if(i%3 == 0)
				System.out.println("Fizz");
			else if(i%5==0 )
				System.out.println("Buzz");
			
		}
	}

}
