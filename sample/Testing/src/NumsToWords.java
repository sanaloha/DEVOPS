
public class NumsToWords {

	private static String [] Units = {"","one","two","three","four","five","six",
						"seven", "eight","nine","ten","eleven","twelve",
						"thirteen","fourteen","fifteen","sixteen","seventeen",
						"eighteen","nineteen"};
	private static String [] tens = {"","","twenty","thirty","fourty","fifty","sixty","seventy",
						"eighty","ninety"};
	
	public static void main(String[] args) {
		
		System.out.println(convert(10227));

	}
	
	public static String convert(int i){

		//negative integer
		//integer  between 0-19
		if(i < 20)
			return Units[i];
		//integer between 20 - 100
		if(i < 100)
			return  tens[i/10] +" "+ Units[i%10];
		//integer between 100 - 1000
		if(i < 1000)
			return Units[i/100] +" "+"Hundred" + " " + convert(i%100);
		//integer between 1000 - 100000
		if(i < 100000)
			return convert(i/10000) + " " + "Lakh " + convert(i%10000); 
		
		return String.valueOf(i);
	}

}
