/**
 * 
 */
package com.san.studentlibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 311832
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Student [] students = null;
		Book [] books = null;
		
		ExecutorService execService =  Executors.newFixedThreadPool(Constant.NUMBER_OF_STUDENTS);
		
		try{
		
			books = new Book[Constant.NUMBER_OF_BOOKS];
			students =  new Student[Constant.NUMBER_OF_STUDENTS];
			
			for(int i=0; i< Constant.NUMBER_OF_BOOKS;i++)
				books[i] = new Book(i);
			
			for(int i=0; i< Constant.NUMBER_OF_STUDENTS;i++){
				students[i] = new Student(i, books);
				execService.execute(students[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
			execService.shutdown();
			
		}finally{
			execService.shutdownNow();
		}
	}

}
