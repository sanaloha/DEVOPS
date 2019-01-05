import Singleton.Singleton;

public class MyRunnable implements Runnable{
	
	public void run(){
	//	System.out.println("Runnable");
		/*for(int i =0; i < 4;i++){
			System.out.println("Current running Thread  " + Thread.currentThread().getName());
		}*/
		Singleton x1 = Singleton.getInstance();
		x1.name =  Thread.currentThread().getName(); 
		
		System.out.println("Instance x name" + x1.name);
		
		
		
	}

}
