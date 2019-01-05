package Java8Ex;

import java.util.ArrayList;
import java.util.List;


/***
 * https://www.javatpoint.com/java-lambda-expressions
Lambda expression is a new and important feature of Java which was included
in Java SE 8. It provides a clear and concise way to represent one method interface
using an expression. 
It is very useful in collection library. It helps to iterate, filter and extract data 
from collection. The Lambda expression is used to provide the implementation of an 
interface which has functional interface. It saves a lot of code. 
In case of lambda expression, we don't need to define the method again for providing
the implementation. Here, we just write the implementation code.
**Java lambda expression is treated as a function, so compiler does not create .class file.
--Functional Interface
Lambda expression provides implementation of functional interface. An interface which has 
only one abstract method is called functional interface.
Java provides an annotation FunctionalInterface, which is used to declare an interface as 
functional interface.
 
Why use Lambda Expression
To provide the implementation of Functional interface.
Less coding.

Syntax: (argument-list) -> {body}  
Java lambda expression is consisted of three components.

1) Argument-list: It can be empty or non-empty as well.
2) Arrow-token: It is used to link arguments-list and body of expression.
3) Body: It contains expressions and statements for lambda expression.
**/

@FunctionalInterface  //It is optional  
interface Drawable{  
    public void draw();  
}  

interface SayHello{  
    public String say(String name);  
}  

interface Addable{
	
	public int add(int a, int b);
		
}

public class LambdaEx {
	
	public static void main(String ... args){
		Test5();
		
	}

	public static void Test6(){
	
}
	
	/**
	 * Without Lambda Expression
	 * 
	 * 
	 **/
	public static void Test(){
		 int width=10;  
		  
	     //without lambda, Drawable implementation using anonymous class  
	      Drawable d = new Drawable(){  
	         public void draw(){System.out.println("Drawing "+width);}  
	      };  
	      d.draw();  
	}
	/** Foreach Loop**/
	public static void Test1(){
		
		
		 List<String> list=new ArrayList<String>();  
	     list.add("ankit");  
	     list.add("mayank");  
	     list.add("irfan");  
	     list.add("jai");  
	     
	     list.forEach((n)->System.out.println(n));
	        
	}
	
	/**Using functional interface**/
	public static void Test2(){
		
		int width=10;
		int height = 15;
		
		Drawable d=()->{
			
			int sum = width + height;
			System.out.println("sum" + sum);
		};
		d.draw();
		
	}
	
	/**Using Single parameter**/
	public static void Test3(){
		
		SayHello say=(first)->{
			return "Hi " + first; 
			
		};
		
		System.out.println(say.say("san"));
	}
	
	/**Using Multiple Parameters
	 * 
	 *  if there is only one statement, 
	 *  you may or may not use return keyword.
	 *  You must use return keyword when lambda expression contains multiple statements.
	 * 
	 * 
	 * **/
	
	public static void Test4(){
		
		 // Lambda expression  return keyword.
		Addable add=(a,b)->{
			return a + b;
		};
		
		System.out.println(add.add(6,6));
		
		 // Lambda expression without return keyword.
		Addable addable=(a,b)->( a + b);
	
		
		System.out.println(addable.add(5,6));
		
		
	}
	
	/**
	 * For Creating Threads
	 * 
	 * 
	 * ***/
	public static void Test5(){
		//Thread Example without lambda  
        Runnable r1=new Runnable(){  
            public void run(){  
                System.out.println("Thread1 is running...");  
            }  
        };  
        Thread t1=new Thread(r1);  
        t1.start();  
        
      //Thread Example with lambda  
        Runnable r2 =()->{
        	
        	System.out.println("Thread 2 is running");
        };
        
        Runnable r3 = ()->{
        	System.out.println("Thread 3 is running");
        };
        
        Thread t2=new Thread(r2);
		t2.start();
		
		Thread t3 = new Thread(r3);
		
		t3.start();
		
		new Thread(
					()->{
						
						System.out.println("Thread 4 is running");
					}
				).start();;
	}
	
/**
 * Java Lambda Expression Example: Comparator
 * 
 * **/
/**Java Lambda Expression Example: Filter Collection Data**/
	
/**Java Lambda Expression Example: Event Listener**/
}




	
	