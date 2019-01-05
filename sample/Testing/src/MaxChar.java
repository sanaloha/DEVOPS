import java.util.HashMap;
import java.util.Map;

public class MaxChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//getMaxCharUsingMap();
		getMaxCharUsingMap();
		
		
		
	}
	
		
	/**
	 * Declare character,integer map to hold the character as a key and occurrences as value
	 * Declare a  variable named max with the min value 0
	 * Get the String into character array.
	 * Loop through this array
	 * write a code to get the character from the map
	 * 	if the char is present in the map, increase its value by 1
	 * 	else assign 1 to it
	 * 	check if the current value is > the max variable,if yes assign current value to max.
	 * 	
	 **/
	public static void getMaxCharUsingMap(){
		
		Map<Character, Integer> maxMap = new HashMap<>();
		long maxCount = Integer.MIN_VALUE;
		//System.out.println(max);
		String text  = "Hello Therrrrre";
		 //Character maxChar = ' ';
		 char maxChar = ' ';
		char [] textArray = text.toCharArray();
		
		for(char c: textArray){
			if(maxMap.containsKey(c))
				maxMap.put(c, maxMap.get(c)+1);
			else
				maxMap.put(c, 1);
	
			if(maxMap.get(c) > maxCount){
				maxCount = maxMap.get(c);
				maxChar = c;
			}
			
		}
	System.out.println("Max " + maxChar + " Count " + maxCount);	
	}

}