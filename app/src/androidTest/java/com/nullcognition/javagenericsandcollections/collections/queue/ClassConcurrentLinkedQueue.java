package com.nullcognition.javagenericsandcollections.collections.queue;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by ersin on 30/03/15 at 10:49 PM
 */
public class ClassConcurrentLinkedQueue {

   ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<>();

   public void add(){
	  for(int i = 0; i < 5; i++){
		 new Thread(new Runnable() {

			@Override
			public void run(){
			   clq.add(new Random(1).nextInt());
			}
		 }).start();

		 new Thread(new Runnable() {

			@Override
			public void run(){
			   clq.remove();
			}
		 }).start();
	  }
   }


}
