
public class Palindrome {
	
	/**
	 * Given a String return true if it is a palindrome
	 * or false if it is not, Palindromes are Strings which forms
	 * same words if reversed. Do Include spaces and punctuations
	 * in determining this.
	 * palindrome(abba) true
	 * palindrome(abcd) false
	 * 
	 * **/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	//String [] name = {"abc", "cde","ghf"};	
		palindrom();
	}
	
	public static void palindrom(){
		String name ="abcba";
		
		//String [] nameArr = name.split("");
		//System.out.println(nameArr.toString());
		
		StringBuffer sb = new StringBuffer(name);
		String palin = sb.reverse().toString();
		System.out.println(name);
		System.out.println(palin);
		
		//return name.equals(palin);
		
		if(name.equals(palin))
			System.out.println("Palindromes");	
		else
			System.out.println("Not a Palindroe");
	}

}
