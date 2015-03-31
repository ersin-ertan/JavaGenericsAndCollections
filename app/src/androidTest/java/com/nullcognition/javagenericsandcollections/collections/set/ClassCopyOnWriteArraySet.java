package com.nullcognition.javagenericsandcollections.collections.set;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by ersin on 27/03/15 at 5:37 PM
 */
public class ClassCopyOnWriteArraySet {

   // wraper on copyonwritearraylist, which is turned into an imutable array, and a change in contents will result in a new array creation

   CopyOnWriteArraySet<Integer> copyOnWriteArraySet;

   List<Integer> linkedList = new LinkedList<>();

   public void meth(){

	  copyOnWriteArraySet.add(1); // all add/contains has O(n) complexities, implemented via linear search
	  copyOnWriteArraySet.add(2);

	  copyOnWriteArraySet.contains(1);

	  Iterator<Integer> it = copyOnWriteArraySet.iterator();
	  Integer i = it.next(); // but iteration is via an array which mayes it O(1) fast, and it is thread safe

	  for(int j = 0; j < 5; j++){ // will read and write at the same time putting the elements into the list, specific to the number of objects in the list
		 // at the time of the run, as the array will be altered, not sure if it updates while the read is occurring...
		 new Thread(new Runnable() {

			@Override
			public void run(){
			   copyOnWriteArraySet.add(new Random(3).nextInt());
			}
		 }).start();

		 new Thread(new Runnable() {

			@Override
			public void run(){
			   if(copyOnWriteArraySet.iterator()
									 .hasNext()){
				  linkedList.add(copyOnWriteArraySet.iterator()
													.next());
			   }
			}
		 }).start();
	  }
   }


}
