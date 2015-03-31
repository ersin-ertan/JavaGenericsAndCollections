package com.nullcognition.javagenericsandcollections.collections.queue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by ersin on 30/03/15 at 11:08 PM
 */

class D implements Delayed {

   long delay;

   D(long inDelay){delay = inDelay;}

   @Override
   public long getDelay(TimeUnit unit){
	  // assume the time units are in nanoseconds
	  return delay;
   }

   @Override
   public int compareTo(Delayed another){
	  long ad = another.getDelay(TimeUnit.NANOSECONDS);
	  return this.delay > ad ? 1 : this.delay < ad ? - 1 : 0;
   }
}

public class ClassDelayQueue {

   DelayQueue<D> delayQueue = new DelayQueue<>();

   public void delay() throws InterruptedException{

	  delayQueue.offer(new D(-123)); // should be first one in the queue

	  for(int i = 0; i < 100; i++){
		 delayQueue.offer(new D(new Random(1).nextInt()));
	  }

	  // delay queue will hold the elements in the queue until the delay is up and becoming more negative

	  while(!delayQueue.isEmpty()){
		 delayQueue.take(); // will wait untill an experation
	  }

   }

}
