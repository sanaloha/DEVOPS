
public class MyThread extends Thread {
	/**override run**/
	public void run(){
		
		System.out.println("Running in Thread");
		try{
			Thread.sleep(1000);
			}catch(InterruptedException ex){}
	}
	
	/**
	 * Below is an example of overloaded method
	 * **/
	
	public void run(String S){
		System.out.println("Thread overload" + S);
	
	}

}
