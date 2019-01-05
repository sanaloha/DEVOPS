package Singleton;

public class SingletonTest {
	
	public static void main(String[] args) {
		
		Singleton insatance = Singleton.getInstance();
		
		insatance.name = insatance.name.toUpperCase();
		System.out.println("Instance x name " + insatance.name);
		
		Singleton y1 = Singleton.getInstance();
		System.out.println("Instance y name " + y1.name);
		
		y1.name = y1.name.toUpperCase();
		System.out.println("Instance x name " + insatance.name);
		System.out.println("Instance y name " + y1.name);
		
		
		//Singleton instance2 = (Singleton) insatanc;
		
		
		
		
	}

}
