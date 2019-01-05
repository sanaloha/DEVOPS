package CollectionEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showList();
		//showDuplicate();
		//showDuplicateSorted();
		
	}
	
	public static void showList(){
		
		List<String> test = new ArrayList();
		
		String s = "Hi";
		
		test.add("String");
		test.add(s);
		test.add(s+s);
		
		System.out.println(test.size());
		System.out.println(test.contains(42));
		System.out.println(test.contains("HiHi"));
		System.out.println(test.remove("Hi"));
		System.out.println(test.size());
	}
	
	/**
	 * Find the duplicate item in the arrayList
	 * 	 * 
	 * ***/
	public static void showDuplicate(){
		
		List<Integer> dupList = new ArrayList();
		dupList.add(20);
		dupList.add(40);
		dupList.add(30);
		dupList.add(40);
		dupList.add(20);
		dupList.add(50);
		
		Integer dup;
		
		for(int i=0; i <dupList.size() -1;i++){
			for(int j=i+1; j <dupList.size();j++){
				if(dupList.get(i) == dupList.get(j)){
					System.out.println("Duplicate" + dupList.get(i)); 
					System.out.println("Elements at" +i + " and " +j + " are duplicate");
					break;
				}
			}
 			
		}
				
	}
	
	/**
	 * Find the duplicate item in the arrayList
	 * Using Sorting, single loop
	 * 	 * 
	 * ***/
public static void showDuplicateSorted(){
		
		List<Integer> dupList = new ArrayList();
		dupList.add(20);
		dupList.add(40);
		dupList.add(30);
		dupList.add(40);
		dupList.add(20);
		dupList.add(50);
		dupList.add(50);
		
		Collections.sort(dupList);
		System.out.println(dupList);
		Integer dup;
		
		for(int i=0; i <dupList.size() -1;i++){
			
		if(dupList.get(i) == dupList.get(i+1)){
			System.out.println("Duplicate" + dupList.get(i)); 
		}
			
		}
				
	}
	
}
