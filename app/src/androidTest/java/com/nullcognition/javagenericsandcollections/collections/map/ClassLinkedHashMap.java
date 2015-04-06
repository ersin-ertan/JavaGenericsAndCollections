package com.nullcognition.javagenericsandcollections.collections.map;

import java.util.LinkedHashMap;

/**
 * Created by ersin on 05/04/15 at 4:41 PM
 */
public class ClassLinkedHashMap {

   int maxEntries = 5; // implementing LRU least recently used cache, see android.util.LruCache<K, V>
   // http://developer.android.com/reference/android/util/LruCache.html
   // and everything else under android.util

   LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(maxEntries + 1, 1.1F, true) {

	  // efficiency by adding 1, and setting the rehash factor to 1.1, access order should be true to have the eldest in order

	  // this is under advanced data structures, persistance...

	  @Override
	  protected boolean removeEldestEntry(Entry eldest){

		 return size() > maxEntries;
	  }

   };

   public void lh(){

	  linkedHashMap.put(1, "a");
	  linkedHashMap.put(2, "b");
	  linkedHashMap.put(3, "c");

	  linkedHashMap.containsValue("a");

	  linkedHashMap.get(1);
	  linkedHashMap.get(2);

   }
}
