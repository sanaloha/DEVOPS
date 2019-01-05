package com.san.queue;
/****
 * 
 * Queue Implementation using Arrays
 * 
 * **/
public class Queue {
	
	private Object data[];
	private static final int DEFAULT_SIZE = 10;
	private int index;
	
	
	public Queue(){
		this.data = new Object[DEFAULT_SIZE];
	}

	public boolean isEmpty(){
		
		return index ==0;
	}
	
	public void enqueue(Object obj) throws Exception{
		
		if(index > DEFAULT_SIZE -1) throw new Exception("Queue is Full, Dequeue some object");
		this.data[index] = obj;
		index++;
		
	}
	
	public Object Dequeue() throws Exception{
		
		if(isEmpty()) throw new Exception("Queue is Empty, cannot Dequeue");
		
		Object obj=this.data[0];
		
		for(int i =0; i<this.index-1; i++){
			data[i]=data[i+1];
		}
		this.index--;
		return obj;
		
	}
	
	public Object peek(){
		
		return this.data[0];
	}
	public static void main(String[] args) {
			
		Queue queue = new Queue();
		try{
			queue.enqueue("1");
			System.out.println(queue.Dequeue());
			queue.enqueue("2");
			queue.enqueue("3");
			queue.enqueue("4");
			queue.enqueue("5");
			System.out.println(queue.Dequeue());
		//	System.out.println(queue.toString());
		}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
	}

}
