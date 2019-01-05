package com.san.queue;

public class QueueWeaving {

	//Define three Queues and add some values
	private static Queue queue1 = new Queue();
	private static Queue queue2 = new Queue();
	private static Queue queue3 = new Queue();
	
	public static void main(String[] args) {
		
		populateQueues();
		weave();
	}
	
	public static void weave(){
		
		while(queue1.peek() != null || queue2.peek() != null){
			try {
				if(queue1.peek() != null)
					queue3.enqueue(queue1.Dequeue());
				if(queue2.peek() != null)
					queue3.enqueue(queue2.Dequeue());
				
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	public static void populateQueues(){
		
		try {
			queue1.enqueue("1");
			queue1.enqueue("3");
			queue1.enqueue("5");
			queue1.enqueue("7");
			
			queue2.enqueue("2");
			queue2.enqueue("4");
			queue2.enqueue("6");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
