
public class Pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//showPyramid();
		int n = 3;
		int row=0;
		String level = "";
		//showPyramidRecursion(n, row, level);
		showPyramid();
	}
	
	public static void showPyramid(){
			
	int n = 5;
	//Use Math floor function
	int midPoint = Math.floorDiv(2*n-1, 2);
	System.out.println("mid point" + midPoint);
		
		for(int row =0; row< n; row++){
			String level = "";
			//Figure out how many columns we need for the n = 5, i.e 5 rows Pyramid
			
			for(int col=0; col < n*2 -1; col++){
			//fill the rows
				
			if(midPoint - row <= col && midPoint + row >= col)
				level += "#";
			else
				level += " ";
			
		}
		System.out.println(level);
		}
	}
	
	public static void showPyramidRecursion(int n, int row, String level){
		
		if(row == n-1)
			return;
		
		if(level.length() == 2*n-1){
			System.out.println(level);
			level = "";
			showPyramidRecursion(n, row, level);
		}
			
		int midPoint = Math.floorDiv(2*n-1, 2);
		String add="";
		
		if(midPoint - row <= level.length() && midPoint + row >= level.length())
			add += "#";
		else
			add += " ";

		showPyramidRecursion(n, row, level + add);
		
	}
}
