import java.util.LinkedHashMap;

import org.apache.commons.lang3.StringUtils;

public class Steps {

	public static void main(String[] args) {

		/*makeSteps();
		steps();*/
		stepsRec(3,0,"");
	}

	/**
	 * Create Function for the following implementation With N Levels with using
	 * the # character, make sure Step has spaces for the right hand side Steps
	 * 2 "# " "#""#" Steps 3 "#    " "#""# " "#""#""#" 
	 * Take N as a Total no of rows loop through i= 1 to N 
	 * loop through j =1 to N if j<=i print "#" else
	 * print spaces
	 *  
	 **/
	public static void makeSteps() {

		int n = 5;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j <= i)
					System.out.print("*");
				else
					System.out.print("#");
			}
			System.out.println("");
		}

	}
	
	public static void steps() {

		int n = 5;
		
		String str = "";

		for (int row = 0; row <= n; row++) {
			for (int column = 0; column <= n; column++) {
				if (column <= row){
				str = str + "*";
				System.out.println(str);
				}
				else{
				str = str + "#";
				System.out.println(str);
				}
			}
			
		}
		System.out.println(str);
	}
	/* Using Recursion 
	 * 1) if row = n we have hit the end of our problem
	 * 2) if a step string has length == n then we are at the end of the row
	 * 3) if the length of the steps string is less than or equal to the row
	 * number we are working on, we add a '#', otherwise add a space.
	 * 
	 * 
	 * */
	public static void stepsRec(int n, int row, String steps){
			
		
		//System.out.println("length" + steps.length());
		
		//base case
		if(row==n-1)
			return;
		
		if(steps.length() == n-1){
			
			System.out.println(steps);
			steps = "";
			row = row + 1;
			stepsRec(n,row,steps);
		}
		
		if(steps.length() <= row)
			steps = steps + "#";
		else
			steps = steps+"*";
		
		stepsRec(n,row,steps);
		
	}

}
