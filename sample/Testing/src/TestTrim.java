
public class TestTrim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 trimSpaces();

	}
	
public static void trimSpaces(){
		
		String name = " NZ ";
		name = name.trim();
		
		if("NZ".equals(name))
			System.out.println("Name Trimmed");
			
		
	}
	

}
