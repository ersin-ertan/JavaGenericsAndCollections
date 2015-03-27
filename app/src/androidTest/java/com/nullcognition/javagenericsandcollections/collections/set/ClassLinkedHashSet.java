package com.nullcognition.javagenericsandcollections.collections.set;

import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * Created by ersin on 27/03/15 at 2:06 AM
 */
public class ClassLinkedHashSet { // inherits from hashset implemlements set but iterators return with elements in order

   LinkedHashSet<String> linkedHashSet;

   public void linkedHashSetMethod(){

	  Collections.addAll(linkedHashSet, "a", "b", "c"); // remember var args is no limited to arrays but can be muli paramaterized like so
	  // alternate version of linkedHashSet.add()...

	  linkedHashSet.toString(); // displays the list in order of abc

   }

}


