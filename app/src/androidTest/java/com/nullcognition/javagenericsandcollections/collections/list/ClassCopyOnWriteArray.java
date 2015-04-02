package com.nullcognition.javagenericsandcollections.collections.list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ersin on 01/04/15 at 7:23 PM
 */
public class ClassCopyOnWriteArray { // lists are free to order how you want, can get subsections

   CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3, 4, 55, 5, 5, 5, 3, 32});

   // use to perform multi threaded reads, and rare writes

   public void meth(){
	  new Thread(new Runnable() {

		 @Override
		 public void run(){
			for(Integer _copyOnWriteArrayList : copyOnWriteArrayList){
			   int i = _copyOnWriteArrayList;
			}
		 }
	  }).start();

	  new Thread(new Runnable() {

		 @Override
		 public void run(){
			for(Iterator<Integer> itt = copyOnWriteArrayList.iterator(); itt.hasNext(); ){
			   int i = itt.next();
			}
		 }
	  }).start();

	  copyOnWriteArrayList.add(5, 2); // requires a re creation

	  copyOnWriteArrayList.add(5, 2);
	  copyOnWriteArrayList.add(5, 2);
	  copyOnWriteArrayList.add(3, 2);
	  copyOnWriteArrayList.add(2, 2);
	  copyOnWriteArrayList.add(100, 2); // moved to one position towards the end of the list



   }

}
