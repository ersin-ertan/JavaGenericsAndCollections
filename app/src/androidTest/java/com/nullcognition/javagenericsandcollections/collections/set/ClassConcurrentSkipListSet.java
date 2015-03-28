package com.nullcognition.javagenericsandcollections.collections.set;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by ersin on 27/03/15 at 7:55 PM
 */
public class ClassConcurrentSkipListSet { // backed by skip list, the tierd linked list with progressively less elements per level

   NavigableSet<Integer> ns = new ConcurrentSkipListSet<>();

   public void meth(){

	  ns.add(1);
	  ns.size();
	  ns.contains(1);

	  Iterator<Integer> it = ns.iterator(); // weakly consistent
	  // Their compelling advantage for concurrent use is that they have efficient lock-free, insertion and deletion algorithms,
	  // whereas there are none known for binary trees.

   }


   /*
	  Both Fail-safe and Weakly consistent iterators do not throw ConcurrentModificationException.

	  weakly consistent iterators: Collections which rely on CAS(compare-and-swap) have weakly consistent iterators,
	  which reflect some but not necessarily all of the changes that have been made to their backing collection
	  since they were created. For example, if elements in the collection have been modified or removed before the iterator
	  reaches them, it definitely will reflect these changes, but no such guarantee is made for insertions.

	  Fail safe iterator iterator mechanism makes a copy of the internal Collection data structure and uses it
	  to iterate over the elements. This prevents any concurrent modification exceptions from being thrown if the underlying data structure changes.
	  Of course, the overhead of copying the entire array is introduced.*/

}
