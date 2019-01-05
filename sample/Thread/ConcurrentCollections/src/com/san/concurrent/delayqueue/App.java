package com.san.concurrent.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*******
 * 
 * This is an unbounded BlockingQueue of objects that implement the Delayed
 * Interface
 * 
 * -DelayQueue keeps the elements internally until the certain delay has expired
 * 
 * -an object can only be taken from the queue when its delay is expired!!!
 * 
 * We cannot place null item into the Queue- the Queue is sorted so that the
 * object at the head has the delay that has expired for the longest time
 * (So basically there's an internal order as far as the late queues are concerned.
	And basically it is sorted according to the delay.)
 * 
 * if no delay is expired then there is not head element and poll() will return null
 * size() returns the count of both expired and non expired items!!!
 * 
 * 
 * Are useful for server base application, You are not going to use it for example 
 * if you implement a stock market related application.But if you want to implement a 
 * framework it can prove to be very important.
 * 
 * ********/

public class App {

	public static void main(String[] args) {
		BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
		
		try{
			queue.put(new DelayedWorker(1000, "Thus is the first message"));
			queue.put(new DelayedWorker(10000, "Thus is the second message"));
			queue.put(new DelayedWorker(4000, "Thus is the third message"));
			
			}catch(InterruptedException ex){
			ex.getStackTrace();
		}
		
			while(!queue.isEmpty()){
				try {
					System.out.println(queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}

}


class DelayedWorker implements  Delayed{
	
	//how much time the delayed worker is going to sleep, before we try to take it out from the Queue
	private long duration;
	private String message;
	
	public DelayedWorker(long duration, String message){
		
		
		this.duration = System.currentTimeMillis() + duration;
		this.message = message;
		
	}

	@Override
	public int compareTo(Delayed otherDelay) {
		
		//this delayed worker is smaller than the other delayed worker
		if(this.duration < ((DelayedWorker) otherDelay).getDuration())
			return -1;
		
		if(this.duration > ((DelayedWorker) otherDelay).getDuration())
			return +1;
	
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		
		return unit.convert(duration=System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString(){
		return this.message;
	}
	
}