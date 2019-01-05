package com.san.stack;

public class Stacks {
	
	/****
	 * 
	 * This class represents the stack implementation of the class stack
	 * Lifo that last in first out, almost similar to the Queue Implementation
	 *  
	 * **/
	
	private Object data[];
	private static final int DEFAULT_SIZE = 5;
	private int index;
	
	public Stacks(){
		this.data = new Object[DEFAULT_SIZE];
	}
	
	public boolean isEmpty(){
		
		return index ==0;
	}

	public void add(Object obj) throws Exception{
		
		if(index > DEFAULT_SIZE -1) throw new Exception("Stack is Full, remove some object");
		this.data[index] = obj;
		index++;
		
	}
	
	public Object remove() throws Exception{
		
		if(isEmpty()) throw new Exception("Stack is Empty, cannot remove");
		
		Object obj=this.data[index-1];
		
		this.data[index-1] = null;
		return obj;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stacks stack = new Stacks();
		try{
			stack.add("1");
			System.out.println("Removed Item" + stack.remove());
			stack.add("2");
			stack.add("3");
			stack.add("4");
			stack.add("5");
			System.out.println("Removed Item" + stack.remove());
		
		}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		
		
	}

}

