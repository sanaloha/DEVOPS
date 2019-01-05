

/****
 * Write a function that returns the no of vowels in the String
 * Vowels('Hi There') => 3
 */


public class Vowels {
	
	public static enum vowelEn{
		a,e,i,o,u;
		
	}

	public static void main(String[] args) {
		System.out.println(vCount());
		
	}
	
	/**
	 * Using char array and contains method
	 * **/
	public static int vowelCount(){
		
		String str = "Hi there";
		str = str.toLowerCase();
		int count = 0;
		char[] charArr = str.toCharArray();
		String vowel = "aeiou";
		
		for(char c:charArr){
			if(vowel.contains(Character.toString(c)))
				count++;
		}
		
		return count;
		
	}
	
/**
 * 
 * Using Enums
 * 
 * **/
public static int vCount(){
		
		String str = "Hi there";
		str = str.toLowerCase();
			int count = 0;
		char[] charArr = str.toCharArray();
				
		for(char c:charArr){
			try{
			if(vowelEn.valueOf(Character.toString(c)) instanceof vowelEn)
				count++;
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
		
		return count;
		
	}

public static int vowCount(){
	
	String str = "Hi there";
	char[] charArr = str.toLowerCase().toCharArray();
	int count = 0;
		
	for(char c:charArr){
		if(c=='a' || c=='i' || c=='e' || c=='o' || c=='u')
			count++;
	}
	
	return count;
	
}
	
	
	/****
	 *Using Iteration
	 *Using Regular Expression 
	 *Using Enums
	 *Using Contains method
	 * 
	 * 
	 */

}
