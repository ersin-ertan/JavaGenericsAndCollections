package com.nullcognition.javagenericsandcollections.collections.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ersin on 27/03/15 at 12:56 AM
 */
public class ClassHashSet {

   HashSet<String> hashSet; // implemented by hash table via HashMap, store by content hence the hash

   public void hashSetMethod(){

	  hashSet.add("a");
	  hashSet.add("b");
	  hashSet.addAll(Arrays.asList("c", "d", "e"));

	  Set<String> aSet = new HashSet<>(6); // initial capacity
	  aSet.addAll(hashSet);
	  aSet.add("six");
	  aSet.add("seven");

	  boolean doesContain = aSet.containsAll(hashSet);

	  int i = aSet.hashCode();

	  aSet.remove("six");

	  aSet.size();

	  String [] strings = new String[10];
	  aSet.toArray(strings); // no need to = asignment, as the elements in aSet is put directly into the strings array

	  Iterator<String> it = aSet.iterator();
	  String s = it.next();
	  boolean b = it.hasNext();
	  it.remove();;

	  aSet.clear();

   }

}
