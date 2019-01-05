

/**
 * Assertion is a statement in java. It can be used to test your assumptions about the program.
 * While executing assertion, it is believed to be true. If it fails, JVM will throw an error named AssertionError.
 * It is mainly used for testing purpose.
 * It provides an effective way to detect and correct programming errors.
 * There are two ways to use assertion. First way is: assert expression;  
 * and second way is:assert expression1 : expression2;  
 **/

public class Assert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1();

	}
	
	public static void Test1(){
		
		int a = 20;
		int b = 30;
		boolean isGreater =  true;
		
		assert isGreater =  a > b;
		System.out.println(isGreater);
		
	}

}
