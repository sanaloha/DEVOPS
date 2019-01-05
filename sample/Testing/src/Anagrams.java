import java.util.Arrays;

public class Anagrams {
	/**
	 * Check to see if two provided strings are anagrams of each other
	 * One string is an anagram of another if it uses the same characters
	 * in the same quantity. Only consider characters, not spaces or punctuation
	 * Consider Capital letters to be same as lower case
	 * Examples
	 * anagrams('rail safety', fairy tales) true
	 * anagrams('RAIL! safety!', 'fairy tales') true
	 * anagram('Hi THere','Bye there') false
	 *  
	 * Using char loop
	 * Using CharMap'
	 * Using sorting
	 * **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1 = "Rail safety";
		String S2 = "fairy tales";
		
		//anagram(S1,S2);
		//System.out.println(anagramTest(S1,S2));
	
	}
	
	
	
	/***Using array.sort*/
	
public static boolean anagramTest(String s1,String s2){
	//replace all space, punctuation and special character with blank
	s1 = s1.replaceAll("\\s+","").toLowerCase();
	s2 = s2.replaceAll("\\s+","").toLowerCase();
	
//1. check the length s1 and s2, if it is not equal than don't need to do 
//anything just return with false
	if(s1.length() != s2.length())
		return false;
	
//2. Take character Arrays of the given Strings
	
	char[] ch1 =  s1.toCharArray();
	char[] ch2 = s2.toCharArray();
	
//3. Sort the character arrays
	
	Arrays.sort(ch1);
	Arrays.sort(ch2);
	
//4. Loop through one of the array and check for each characters from both the arrays.
		
	for(int i=0;i<ch1.length;i++){
		if(ch1[i]!=ch2[i])
			return false;
	}
	
	return true;
	
	
}
	
	/**
	 * Using character array loop
	 *  
	 ***/
public static void anagram(String S1, String S2){
	
	
//clear the unwanted character from Strings
	S1 = S1.replaceAll("[^a-zA-Z0-9]", " ");
	S2 = S2.replaceAll("[^a-zA-Z0-9]", " ");
	S1 = S1.replaceAll("\\s+","").toLowerCase();
	S2 = S2.replaceAll("\\s+","").toLowerCase();

//Create character arrays
	char[] ch1 = S1.toCharArray();
	char[] ch2 = S2.toCharArray();
	boolean isAnagram = false;
	
	if(ch1.length == ch2.length){
	
		int j=0;
		for(char c: ch1){
			//run a loop for character array 2
			
			for(int i =0; i< ch2.length; i++){
				
				if(c == ch2[i]){
					isAnagram =  true;
					ch2[i] = ' ';
					break;
				}else{
					isAnagram = false;
				}
			//	j++;
			}
		}
	}
	if(isAnagram)
		System.out.println("Anagram");
	else
		System.out.println("No");
}

}
