
public class TestStr {

	public static void main(String[] args) {
		parseString();
	}
	
	public static void parseString(){
		String S1 = "Rail safety";
		String S2 = "COUNTRYCONFIG.ID_STATUS";
		
		S1 = S1.replaceAll("COUNTRYCONFIG.","");
		S2 = S2.replaceAll("COUNTRYCONFIG.","");
		
		System.out.println("Strings"+S1+" "+S2);
	}
	

}
