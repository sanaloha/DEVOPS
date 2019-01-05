
public class Fibonacci {

	/**
	 * Print out the nth entry in the fibonacci series
	 * FS is an ordering of numbers where each number is the
	 * sum of previous two numbers eg [0,1,1,2,3,5,8]
	 * 
	 * nth entry fib(4) = 3;
	 * 
	 * 1 Iterative solution
	 * 2 Recursive solution
	 * 
	 * **/
	
	public static long fibArray[]=new long[60];
	
	public static void main(String[] args) {
			
		/*int n =15;
		
		long preTime=System.currentTimeMillis();
		//int number = fibusingRec(n);
		long number = fibusingMem(n);
		long postTime=System.currentTimeMillis();
		 System.out.println("Time taken to compute in milliseconds->"+(postTime-preTime));
		 System.out.println(number);
		*/
		
		//fibIterative();
		System.out.println(fibusingRec(4));
		
	}
	
	/***
	 * Recursive Solution
	 * 
	 * 
	 * ***/
	public static int fibusingRec(int n){
		
		if(n < 2)
			return n;
		return fibusingRec(n-1) + fibusingRec(n-2);
		
		
	}
	/*****
	 * Using Memoization.
	 * 
	 * 
	 * *****/
	public static long fibusingMem(long n){
		long fibValue=0;
		
		if(n < 2){
		
			return n;
		}
		
		if(fibArray[(int)n]!=0){
			 System.out.println("Fib Array for" + n);
			   return fibArray[(int)n];
		}
		
		System.out.println("Out of Fib Array for" + n);
		fibValue=fibusingMem(n-1) + fibusingMem(n-2);
		fibArray[(int) n]=fibValue;
		
		return fibValue;
		
		
	}
	
	/**Iterative solution
	 * 
	 * **/
		
	public static void fibIterative(){
		
		int fibArray[] = {0,1};
				
		int n = 6;
		for(int i=2; i<=n;i++){
			int a = fibArray[i-1];
			int b = fibArray[i-2];
			fibArray[i] = a+b;			
		}
		
System.out.println(fibArray);		
	}
		
}
