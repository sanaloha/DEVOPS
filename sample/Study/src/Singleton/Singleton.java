package Singleton;

/**
 *1. Create a singleton class
 *2. Access this class from out side
 * 
 * One can break Singleton using 
 * Clone, Threads, Reflection and Serialization
 *  
**/
public class Singleton {

	
	public String name;
	
	//Private static variable of the same class that is the only instance of the class.
	private static  Singleton singleObj;
	
	
	//public static method that returns the instance of the class, this is the global 
	//access point for outer world to get the instance of the singleton class.
	public  static Singleton getInstance(){
		
		if(singleObj == null)
			singleObj =  new Singleton();
		
		return singleObj;
				
	}
	//Private constructor to restrict instantiation of the class from other classes.
	private Singleton(){
		name = "Welcome to Singleton";
		
	}
	
	//To avoid cloning  you must override the clone method as below:
	
	/*public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Singleton, cannot be clonned");
		}
	*/
	

}
