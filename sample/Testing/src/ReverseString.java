import java.lang.*;
import java.io.*;
import java.util.*;


public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseUsingBuffer();
		reverseUsingByte();
		reverseUsingChar();
		reverse();
		reverseUsingList();
		reverseUsingBuffer();
		reverseUsingCharAt();
		
	}
	
public static void reverseUsingCharAt(){
	
String name = "Santosh";
System.out.println("===========Using charAt===============");

	for(int i=0; i < name.length(); i++){
		//System.out.print(name.charAt(i));
		System.out.print(name.charAt(name.length()-i-1));
		
	}
	System.out.println("==========================");
}
	
public static void reverseUsingBuffer(){
	/*Reverse String*/
	String name = "Santosh";
	
	System.out.println("========using string buffer========");
	
	StringBuffer sb = new StringBuffer(name);
	
	//StringBuffer reverseSB = sb.reverse();
	//String revString = reverseSB.toString();
	
	String revString = sb.reverse().toString();

	System.out.println("Reversed String " + revString);
	System.out.println("==========================");
	
	
}

	public static void reverseUsingByte(){
	
		String name = "santosh";
		System.out.println("==========Using Byte================");
	
		byte[] nameBytes = name.getBytes();
		
		byte[] result = new byte[nameBytes.length];
		
		for(int i = 0; i < nameBytes.length; i++)
		{
			result[i] = nameBytes[nameBytes.length-i-1];
						
		}
	
		name = new String(result);
		System.out.println("Reversed string " + name);
		System.out.println("==========================");
		
	}
	
	public static void reverseUsingChar(){
		/*Reverse String*/
		System.out.println("===========Using char array===============");
		String name = "Santosh";
		char [] result = name.toCharArray();
		for(int i = result.length-1; i >=0; i--)
		{
			System.out.print(result[i]);
		
		}
		System.out.println("==========================");
	}
	public static void reverse(){
		
		String name = "Santosh";
		System.out.println("===========char Array 2===============");
		
		char[] result = name.toCharArray();
		int left, right=0;
		right = result.length -1;
		for(left = 0; left < right; left++,right--){
			char temp = result[left];
			result[left] = result[right];
			result[right] = temp;
		}
		for(char c: result){
			System.out.print(c);
			//System.out.println();
		}
		System.out.println("==========================");
	}
	
	public static void reverseUsingList(){
		
		String name = "Santosh";
		System.out.println("===========Using List===============");
		
		char[] nameArray = name.toCharArray();
		List<Character> nameList = new ArrayList<>();
		for(char c: nameArray)
			nameList.add(c);
		
		Collections.reverse(nameList);
		
		ListIterator<Character> li = nameList.listIterator();
		while(li.hasNext()){
			System.out.print(li.next());
			
		}
		System.out.println("==========================");
				
	}
	public static void reverseUsingCharArray(){
		
		System.out.println("==========char array 3================");
		String name = "Santosh";
		String reverse = "";
		
		char[] nameArray = name.toCharArray();
	
		for(char c: nameArray){
			reverse = c + reverse;
		}
		System.out.println(reverse);
		System.out.println("==========================");
	}	
	
	
}
