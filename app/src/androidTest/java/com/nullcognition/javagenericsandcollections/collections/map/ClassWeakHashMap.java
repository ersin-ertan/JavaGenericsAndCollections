package com.nullcognition.javagenericsandcollections.collections.map;

import java.util.WeakHashMap;

/**
 * Created by ersin on 05/04/15 at 4:41 PM
 */
public class ClassWeakHashMap {

   WeakHashMap<Integer, Obj> weakHashMap = new WeakHashMap<>();

   public void meth(){

	  new Thread(new Runnable() {

		 @Override
		 public void run(){

			weakHashMap.put(1, new Obj());
		 }
	  }).start();

	  new Thread(new Runnable() {

		 @Override
		 public void run(){

			weakHashMap.put(2, new Obj());
		 }
	  }).start();

	  Runnable r = new Runnable() { // both r and o, obj are hard reachable thus should be found in the weakhash map even after low memory case

		 Obj o = new Obj();

		 @Override
		 public void run(){

			weakHashMap.put(3, o);
		 }
	  };

	  new Thread(r).start();

	  weakHashMap.size();
	  weakHashMap.keySet();

	  // once the new threads have inserted their elements to the array, they will no longer have a strong reference to the value/obj

//	  weakHashMap.clear();
   }
}


class Obj {

   private static int inc = 0;
   protected      int id  = inc++;

   public int getId(){ return id;}
}
