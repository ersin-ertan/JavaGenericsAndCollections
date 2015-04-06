package com.nullcognition.javagenericsandcollections.collections.map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by ersin on 05/04/15 at 4:42 PM
 * <p/>
 * iteration - map does not inherit from Collection
 * <p/>
 * Using entrySet() and for loop
 * Using keyset() and for loop
 * Using Iterator interface
 * <p/>
 * If you want to remove the elements from Hashmap
 * while iterating, then third option suitable for this kind of requirements.
 * The first two will through java.util.ConcurrentModificationException if you remove while iterating.
 */

public class ClassTreeMap {

   TreeMap<String, Integer> treeMap = new TreeMap<>();

   public void puts(){

	  treeMap.put("a", 1);
	  treeMap.put("b", 2);
	  treeMap.put("c", 3);

	  treeMap.keySet();
	  treeMap.isEmpty();
	  TreeMap.Entry<String, Integer> entry = treeMap.lastEntry();
	  TreeMap.Entry<String, Integer> entryMutable = treeMap.ceilingEntry("b");

	  TreeMap.Entry<String, Integer> pollFirstEntry = treeMap.pollFirstEntry(); // removes and returns

	  treeMap.navigableKeySet(); // ascending order, backed by the map thus the values are mutable, do not change values while iterating

	  treeMap.subMap("a", true, "c", false);

	  treeMap.tailMap("b");

	  treeMap.descendingMap();

	  Set<Map.Entry<String, Integer>> setOfMapEntries = treeMap.entrySet();

	  for(Map.Entry<String, Integer> _setOfMapEntries : setOfMapEntries){
		 _setOfMapEntries.setValue(_setOfMapEntries.getValue() + 5);
		 if(_setOfMapEntries.getKey()
							.matches(".")){
			return; // using keys of type string means you can regex them
		 }
//		   int i = _setOfMapEntries.getKey().compareTo("s"); // why can't you assign the value to i?
	  }
   }
}
