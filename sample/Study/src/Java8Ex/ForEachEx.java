package Java8Ex;

import java.util.ArrayList;

/**
 * Java provides a new method forEach() to iterate the elements. It is defined in Iterable and Stream interface.
 * It is a default method defined in the Iterable interface. Collection classes which extends Iterable interface
 * can use forEach loop to iterate elements. This method takes a single parameter which is a functional interface.
 * So, you can pass lambda expression as an argument
 **/
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForEachEx {

	public static void main(String[] args) {
		
		test3();
		
	}
	
	//Consumer implementation
	class MyConsumer implements Consumer<Integer>{
		
		public void accept(Integer t){
			System.out.println("Consumer impl value" + t);
		}
		
	}
	
	public static void test1(){
		
		List<Integer> listInt = new ArrayList<>();
		
		for(int i =0; i < 10; i++)
			listInt.add(i);
		
		System.out.println(listInt);
		
		//Traverse using iterator
		Iterator<Integer> it = listInt.iterator();
		
		while(it.hasNext())
		{
			Integer i = it.next();
			System.out.print(i);
		}
		
		//Traversing through for each method of iterable with anonymous class
		
		listInt.forEach(new Consumer<Integer>(){
			
			public void accept(Integer t){
				System.out.println("For each anonymous class value" + t);
			}
		});
		
	}
	
	/***
	 * General foreach
	 * 
	 * ***/
			
	public static void test2(){
		
		 List<String> gamesList = new ArrayList<String>();  
		 List<String> newList = new ArrayList<String>();
	        gamesList.add("Football");  
	        gamesList.add("Cricket");  
	        gamesList.add("Chess");  
	        gamesList.add("Hocky");  
	        System.out.println("------------Iterating by passing method reference---------------");  
	        gamesList.forEach(System.out::println);
	      
	        
	        System.out.println("------------Iterating by passing lambda expression--------------");  
	        gamesList.forEach(games->System.out.println(games));
	              
	        //gamesList.forEach(games -> System.out.println(games));
		
		
	}
	
	/**Filter Collection Data**/
	public static void test3(){
		
	List<Product> list=new ArrayList<Product>();  
    list.add(new Product(1,"Samsung A5",17000f));  
    list.add(new Product(3,"Iphone 6S",65000f));  
    list.add(new Product(2,"Sony Xperia",25000f));  
    list.add(new Product(4,"Nokia Lumia",15000f));  
    list.add(new Product(5,"Redmi4 ",26000f));  
    list.add(new Product(6,"Lenevo Vibe",19000f));  
    
    List<Float> prodPrice = new ArrayList<Float>();  
    
 // using lambda to filter data  
    Stream<Product> filtered_data = list.stream().filter(p->p.price > 200);  
 // using lambda to iterate through collection  
    /*
    filtered_data.forEach(  
            product -> System.out.println(product.name+": "+product.price)  
    );  */
    
    filtered_data.forEach(
    		
    		p -> System.out.println("name "+p.name)
    		);
    
   // prodPrice = filtered_data.map(p->p.price).collect(Collectors.toList());
    //above statement would give error:java.lang.IllegalStateException: stream has already been operated
    //upon or closed
    //Create new stream
    Stream<Product> stream_data = list.stream().filter(p->p.price > 200); 
    prodPrice = stream_data.map(p->p.price).collect(Collectors.toList());
    
    System.out.println("Prod Price " +prodPrice);  
	
	}
	/***Java Stream forEachOrdered() Method
	 * 
	 * Signature void forEachOrdered(Consumer<? super T> action)  
	 * ***/

	public static void Test5(){
		
		List<String> gamesList = new ArrayList<String>();  
        gamesList.add("Football");  
        gamesList.add("Cricket");  
        gamesList.add("Chess");  
        gamesList.add("Hocky");  
        System.out.println("------------Iterating by passing lambda expression---------------");  
        gamesList.stream().forEachOrdered(games -> System.out.println(games));  
        System.out.println("------------Iterating by passing method reference---------------");  
        gamesList.stream().forEachOrdered(System.out::println);  
   
		
	}
}


class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  