import java.io.UnsupportedEncodingException;
import java.util.Base64;



public class UnicodeTester {

	public UnicodeTester() {
		// TODO Auto-generated constructor stub
	}

	/** There are several implementation of Unicode character, one of the most popular
		one is UTF-8 it contains characters beyond 0-127 range as oppose to the Ascii, 
		the only similarity with Ascii is that both have same character set between 0-127.
		In other words Ascii is a subset of UTF-8 **/
	
	public static void main(String[] args) {
		
		convertUnicodeToUTF();
		checkAscii();
		
		}
	
	static void convertUnicodeToUTF(){
		
		try{
		    String unicodeStr = "AS\u025940";
		    byte[] ISO = unicodeStr.getBytes("iso-8859-1");
		    
		     // Convert from UTF-8 to Unicode
		    unicodeStr = new String(ISO, "iso-8859-1");
		    
		    
		    System.out.println("ISO" + unicodeStr);
		    
		    String string1 = "AS\u025940";
		    byte[] UTF8 = unicodeStr.getBytes("utf-8");
		    
		    string1 = new String(UTF8, "utf-8");
		    
		    System.out.println("UTF-8" + string1);
		
		}catch(Exception ex){
			
		}
		
	}


	/**
	 * Ascii contains character codes from 0-127, any character beyond that cannot belongs to 
	 * ascii. There is another popular character set called UTF-8. 
	 **/
	
	static void checkAscii(){
		
		String nonAsc = "ASU025940";
		
		boolean isAsc = isAsciiCharacters(nonAsc);
		
		if(isAsc)
			System.out.println("This String is an ascii String");
		else 
			System.out.println("This String is a non ascii String");
		
	}
	
	static boolean isAsciiCharacters(String inputField){
		
		String resultPwd = inputField.replaceAll("[^\\x00-\\x7F]", "");
		System.out.println(resultPwd);
		
		if(!resultPwd.equalsIgnoreCase(inputField))		
			return false;
		
		return true;
		
	}

}
