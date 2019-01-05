

/**
 * Write a function that accepts an Integer and returns a N*N
 * spiral matrix
 * 
 * EX: matrix(2)
 * [[1,2],
 * 	[4,3]]
 * 
 * Matix 3
 * 
 * [[1,2,3],
 * 	[8,9,4],
 * 	[7,6,5]]
 * matrix 4
 * [[1,2,3,4],
 * 	[12,13,14,5],
 * 	[11,16,15,6],
 * 	[10,9,8,7]]
 * 
 * So we go in this clockwise spiraling in fashion the last number that we're ever going to print out inside
 * of here will be. And squared. So for example we have four here. So the last number that we will print out
 * inside if you will be 16.Three times three is nine. So that's going to be the last number. And then two times 
 * two is four.
 * 
 * 1) Maintain some variables
 *  startrow, endrow, startcolumn, endcolumn
 *  
 * 2) Create an empty array of arrays called result
 * 3) Create a counter variable starting at 1
 * 4) As long as (startcolumn <= endcolumn) && (startrow<=endrow)
 *  	5) Loop from startcolumn to endcolumn
 *  		6) at result[startrow][i] = counter assign a counter variable
 *  		7) Increment the counter
 *  	8) Increment start row
 *  	9) Loop from start row to end row in this case row=1 to row=3
 *  		10) at result[i][endcolumn] = counter assign the counter
 *  		11) increment the counter
 *  	12) decrement end column
 *  	
 *  Repeat for other two sides
 *  
 *  
 *  
 * **/
public class MatrixSpiral {

	public static void main(String[] args) {

		matrix();

	}
public static void matrix(){
	
	int n = 3;
	int startR = 0;
	int endR = n-1;
	int startC = 0;
	int endC = n-1;
	int [][] result = new int [n][n];
	int counter = 1;
	
	while(startR <= endR && startC <= endC){
		
		//top row
		for(int i=startC;i<=endC;i++){
			result[startR][i] = counter;
			counter++;
		}
		startR++;
		
		//right column
		for(int i=startR;i<=endR;i++){
			result[i][endC] = counter;
			counter++;
		}
		endC--;
		
		//bottom row
		for(int i = endC; i >= startC; i--){
			result[endR][i] = counter;
			counter++;
		}
		endR--;
		//start column
		for(int i = endR; i>=startR;i--){
			result[i][startC] = counter;
			counter++;
		}
		startC++;
	}
System.out.println("Result" + result.toString());	
		
}
}
