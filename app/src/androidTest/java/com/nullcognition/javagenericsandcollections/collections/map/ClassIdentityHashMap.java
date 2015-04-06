package com.nullcognition.javagenericsandcollections.collections.map;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Set;

/**
 * Created by ersin on 05/04/15 at 4:41 PM
 */
public class ClassIdentityHashMap extends TestCase {

   IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<>();
   HashMap<Integer, String>         hashMap         = new HashMap<>();

   public void testMeth(){

	  identityHashMap.put(new Integer(1), "a");
	  identityHashMap.put(new Integer(2), "b");
	  identityHashMap.put(new Integer(1), "c"); // identity hash map has the third integer set as a new object,

	  hashMap.put(new Integer(1), "a");
	  hashMap.put(new Integer(2), "b");
	  hashMap.put(new Integer(1), "c"); // that is not so with hash map, which replaces the value of 1

	  Set set = identityHashMap.keySet();
	  int size = set.size();
	  assertEquals(3, size);

	  set = hashMap.keySet();
	  size = set.size();
	  assertEquals(2, size);

   }
}
