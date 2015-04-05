package com.nullcognition.javagenericsandcollections.collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by ersin on 05/04/15 at 4:41 PM
 */
public class ClassHashMap {

   HashMap<String, Integer> hashMap = new HashMap<>();

   public void hash(){

	  hashMap.put("a", 1);
	  hashMap.put("b", 2);

	  hashMap.remove("a");

	  hashMap.size();

	  Collection<Integer> c = hashMap.values();

	  boolean b = hashMap.containsValue(2);

	  hashMap.get("b");

	  Set<String> set = hashMap.keySet();
   }
}
