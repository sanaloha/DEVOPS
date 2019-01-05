
public class ThreadS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("Current running  main Thread " + Thread.currentThread().getName());
		
		MyRunnable r = new MyRunnable();
		Thread foo1 = new Thread(r);
		Thread foo2 = new Thread(r);
		Thread foo3 = new Thread(r);
		foo1.setName("First");
		foo2.setName("Second");
		foo2.setPriority(10);
		foo3.setName("Third");
		foo1.start();
		foo3.start();
		try{
			//foo1.join();
			foo3.join();
		}catch(InterruptedException ex){}
		
		
		foo2.start();
		//
		//foo2.start(); a thread cannot be started twice, IllegalThreadException will
		//be thrown

	}

}
