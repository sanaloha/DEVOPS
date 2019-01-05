package Java8Ex;

import java.util.Arrays;

public class ParallelArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test2();

	}
	/**It sorts the specified array into ascending numerical order.***/
	public static void Test1(){
		
		 // Creating an integer array   
        int[] arr = {5,8,1,0,6,9};  
        // Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }  
        // Sorting array elements parallel  
        Arrays.parallelSort(arr);  
        System.out.println("\nArray elements after sorting");  
        // Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }  
    }  
	
	/*** Passing Start and End Index
		In the following example, we are passing starting and end index of the array. 
		The first index is inclusive and end index is exclusive i.e. 
		if we pass 0 as start index and 4 as end index, only 0 to 3 index elements will be sorted.
		It throws IllegalArgumentException if start index > end index.
		It throws ArrayIndexOutOfBoundsException if start index < 0 or end index > a.length.
	***/
	
	public static void Test2(){
		
		// Creating an integer array   
        int[] arr = {5,8,1,0,6,9,50,-3};  
        // Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }  
        // Sorting array elements parallel and passing start, end index  
        Arrays.parallelSort(arr,0,4);  
        System.out.println("\nArray elements after sorting");  
        // Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }  
	}
}

