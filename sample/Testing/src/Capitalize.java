
public class Capitalize {

	public static void main(String[] args) {

		//Capitalize the first letter of the words
		//A short Sentence. Use of Slice.
		
		//capitalizeStr(); //Working
		//capitalizeUsingCharArray();
		trimSpaces();

	}
	
	public static void trimSpaces(){
		
		String name = " NZ ";
		name = name.trim();
		
		if("NZ".equals(name))
			System.out.println("Name Trimmed");
			
		
	}
	
	/**
	*Take String assigned with one sentence
	*Task is to Make the first letter of each work capital
	*Split the String with space " ", and take it into an String array called nameArr
	*Loop through the array up to length-1
	*Take the string at each index and get the 0th element using substring and make it Capital
	*and add rest of the string as it is.
	*
	**/
	public static void capitalizeStr(){
		
		String name = "hi there hello";
		String result = "";
		String [] nameArr =  name.split(" ");
		
		System.out.println(nameArr[0]);
		System.out.println(nameArr.length);
		
		
		for(int i=0; i < nameArr.length; i++){
			result = result + nameArr[i].substring(0,1).toUpperCase() + nameArr[i].substring(1) + " ";
		}
		
		System.out.println(result);
		
	}
	
	/*
	 * Create an array of strings
	 * loop through the array, check if the previous element is blank then make the current 
	 * element Capital.
	 * 
	 * */
public static void capitalizeUsingCharArray(){
	
	String name = "hi there hello";
	
	char[] result = name.toCharArray();
	String resultName = Character.toString(result[0]).toUpperCase();
	
	for(int i=1; i < result.length;i++){
		//check the space, make the character
		if(result[i-1] == ' '){
			resultName = resultName + Character.toString(result[i]).toUpperCase();
		}else
			resultName = resultName + Character.toString(result[i]);
		
	}
	System.out.println(resultName);	
		
	}

}
