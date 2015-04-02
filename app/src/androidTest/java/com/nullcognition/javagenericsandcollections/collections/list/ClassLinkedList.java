package com.nullcognition.javagenericsandcollections.collections.list;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by ersin on 01/04/15 at 7:44 PM
 */


public class ClassLinkedList {

   // bad for random access, good for middle list add/remove of constant time to scroll through to the spot

   LinkedList<Integer> linkedList = new LinkedList<>(Collections.asLifoQueue(new ArrayDeque<Integer>(Arrays.asList(1, 2, 3, 4, 5))));

   // very round about way of adding numbers to the list constructor - looking for Arrays.asList

   public void meth(){

	  linkedList.addFirst(1);
	  linkedList.addLast(3);
	  linkedList.add(3, 2);

	  Iterator<Integer> it = linkedList.descendingIterator();

	  it.remove();

	  Integer someint = linkedList.element();

	  ListIterator<Integer> integerListIterator = linkedList.listIterator(1);

	  linkedList.pop();

	  linkedList.size();

	  Object clone = linkedList.clone(); // shallow copy

	  linkedList.clear();


   }

}
