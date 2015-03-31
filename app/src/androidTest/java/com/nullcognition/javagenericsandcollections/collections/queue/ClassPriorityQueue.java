package com.nullcognition.javagenericsandcollections.collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ersin on 30/03/15 at 10:02 PM
 */
class Task implements Comparator<Task.Pri> {

   Task(int p){setMyPri(p);}

   enum Pri {
	  lo,
	  mid,
	  hi
   }

   Pri myPri;
   public void setMyPri(int i) {myPri = Pri.values()[i];} // that is cool array def

   @Override
   public int compare(Pri lhs, Pri rhs){
	  return lhs.ordinal() < rhs.ordinal() ? - 1 : lhs.ordinal() > rhs.ordinal() ? 1 : 0;
   }

}

public class ClassPriorityQueue {

   PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(6);

   public void withIntegers(){

	  priorityQueue.add(1);
	  priorityQueue.add(2);
	  priorityQueue.add(3);
	  priorityQueue.add(2);
	  priorityQueue.add(6);
	  priorityQueue.add(5);

	  priorityQueue.comparator(); // should return null, since the natural ordering is used
	  // unless integer uses a comparator

	  // priorityQueue.offer(8); // offer does not return false if fail
	  priorityQueue.peek(); // just looking

   }

   public void withEnumForPriority(){

	  PriorityQueue<Task> pq = new PriorityQueue<>();

	  pq.add(new Task(0));
	  pq.add(new Task(0));
	  pq.add(new Task(2));
	  pq.add(new Task(2));
	  pq.add(new Task(1));
	  pq.add(new Task(0));
	  pq.add(new Task(2));

	  priorityQueue.comparator(); // can't do too much right now

   }
}
