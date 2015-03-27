package com.nullcognition.javagenericsandcollections.collections.set;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by ersin on 27/03/15 at 5:57 PM
 */
public class ClassTreeSet { // tree set fast insertion an retrieval of single elements, in sorted order

   // which implments NavigableSet interface, the upgraded version of SortedSet
   NavigableSet<Integer> navigableSet; // see the interface

   // both TreeSet and ConcurrentSkipListSet,


   public void treeSetMeth(){

	  NavigableSet<Integer> treeSet = new TreeSet<>();
	  treeSet.add(1);
	  treeSet.add(3);
	  treeSet.add(8);
	  treeSet.add(51);
	  treeSet.add(71);
	  treeSet.add(61);

	  NavigableSet<Integer> ts = treeSet.descendingSet();

	  int i = treeSet.floor(20); // return 8
	  ts = treeSet.headSet(51, true); // return the head elements from 1 to 51 inclusive
	  i = treeSet.higher(66); // all elements greater, which is 71
	  i = treeSet.pollLast(); // returns 71
	  ts = treeSet.subSet(3, true, 51, false); // returns 3(inclusive),8, (51)exclusive

   }


}
