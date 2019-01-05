/**
 * 
 */
package com.san.dinning;

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
	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = null;
		Philosopher[] philosphers = null;

		try {
			philosphers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHER];

			ChopStick[] chopsticks = new ChopStick[Constants.NUMBER_OF_CHOPSTICK];

			for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICK; i++)
				chopsticks[i] = new ChopStick(i);

			executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHER);

			for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHER; i++) {

				philosphers[i] = new Philosopher(i, chopsticks[i], chopsticks[i + 1 % Constants.NUMBER_OF_CHOPSTICK]);
				executorService.execute(philosphers[i]);
			}
			
			Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
			
			for(Philosopher p:philosphers)
				p.setFull(true);

		} finally {
			executorService.shutdown();
			
			while(!executorService.isTerminated())
				Thread.sleep(1000);
			
			for(Philosopher p:philosphers){
				if(p!=null)
				System.out.println(p+" eats " + p.getCounter());
			}

		}

	}

}
