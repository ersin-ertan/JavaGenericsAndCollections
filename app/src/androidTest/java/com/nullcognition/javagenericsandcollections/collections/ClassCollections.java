package com.nullcognition.javagenericsandcollections.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ersin on 13/04/15 at 8:37 PM
 */

public class ClassCollections {

   List<? extends Comparable<? super String>> list       = new LinkedList<>();
   List<String>                               stringList = new LinkedList<>();

   public void meth(){

	  Collections.addAll(stringList, "a", "b", "c");
	  Collections.sort(stringList);
	  Collections.swap(stringList, 0, 1);
	  String min = Collections.min(stringList);

	  List<String> synchedList = Collections.synchronizedList(stringList); // all acces is synchronized
	  List<String> willThrowUnsporttedOperationExceptionIfModified = Collections.unmodifiableList(stringList);
	  List<String> willThrowClassCastExceptionIfWrongTypeIsEntered = Collections.checkedList(stringList, String.class);

	  Collections.copy(new LinkedList<String>(), stringList); // new list will get garbage collected right away
	  Collections.disjoint(stringList, stringList); // returns false since there is at least one matching element in both sets
	  Collections.fill(stringList, "fillValue");
	  Collections.reverse(stringList);
	  Collections.shuffle(stringList);
	  Collections.singleton(stringList); // singleton set, unmodifiable

	  int theNumberOfTimesFillValueOccurs = Collections.frequency(stringList, "fillvalue");

	  List listOfCopiedValues = Collections.nCopies(4, "copiedValue");
	  List emptyList = Collections.EMPTY_LIST; // immutable
	  List emptyListTypeSafe = Collections.emptyList(); // typesafe immutable

	  Collections.binarySearch(list, "a"); // requires the type to be <? extends Comparable<? super String>>
   }
}
