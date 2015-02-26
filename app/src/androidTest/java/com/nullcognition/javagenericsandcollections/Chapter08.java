package com.nullcognition.javagenericsandcollections;

import junit.framework.TestCase;

import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/**
 * Created by ersin on 26/02/15 at 8:02 AM
 */

// Effective Generics pg 108 *important re-read* - checked collections, security issues, specialized classes, and binary compatibility

public class Chapter08 extends TestCase {

   // because type safety is not guaranteed from legacy libraries - an unchecked cast may be ocurring while receiving the incorrectly stated type
   // this solution is specific to reifiable types

   static class LegacyLib {

	  static List list = new ArrayList();

	  public LegacyLib(){
		 list.add(new Integer(3));
		 list.add("shouldBeAnInt");
	  }

	  public static void addList(List inList){list.addAll(inList);}

	  public static List getList(){return list;}
   }

   public void testCheckedList(){

	  List<Integer> list = new ArrayList<>();
	  List<Integer> view = Collections.checkedList(list, Integer.class);

	  /* adding an element to the checked view, reflection is used to check that the element belongs to the specified class before adding it to list
	   checked list view will cause a class cast exception to be raised inside the method addList when it attempts to add a string to the list.*/

	  LegacyLib.addList(view); // will be a class cast exception

	  List<Integer> list1 = LegacyLib.getList(); // unchecked, to catch getList's improper additions if any, use the data verification trick below
	  for(int _list1 : list1){} // will itterate through each item, and when a non-int is hit, will throw a class cast exception - error proximity to ^
   }

   /*
	This means that generic types are useless for ensuring security in code written by others, since you have no way of knowing whether that code
	raised unchecked warnings when it was compiled
	*/

   // if a suplier is offering raw collections - the verification type cannot be inferred by the receiving code with type parameters
   // using supplier.addOrders(Collections.checkedList(orders, AuthenticatedOrder.class)); with the class token will ensure correct type


   // Specialize To Create Reifiable Types - instance tests, casting, and array creation apply only to reifiable types - but Parameterized types are not reifiable
   // Specialized versions of the parameratized type can be created via delegation(wrapper) or by inheritance(subclassing)


}

interface ListString extends List<String> {}

class ListStrings { //

   public static ListString wrap(final List<String> list){ // method containing two innerclasses, as different ways of completing the same operation
	  // while implementing the ListString(reifiable) interface, which is the subtype of List<String>(non-reifiable), as a bypass, to specialize the String type

	  // Method 1 - helper class
	  class Random extends AbstractList<String> implements ListString,
														   RandomAccess {

		 @Override
		 public String get(int location){return null;}

		 @Override
		 public int size(){return 0;}
	  }

	  // Method 2 - helper class
	  class Sequential extends AbstractSequentialList<String> implements ListString {

		 @Override
		 public ListIterator<String> listIterator(int location){return null;}

		 @Override
		 public int size(){return 0;}
	  }

	  return list instanceof RandomAccess ? new Random() : new Sequential(); // returning specialized List(type specific)
   }
}

class ArrayListString extends ArrayList<String> implements ListString { // now our list class using the string type use the specialized implementation

   public ArrayListString(){ super(); }

   public ArrayListString(Collection<? extends String> c){ super(c); }

   public ArrayListString(int capacity){ super(capacity); }
}

/* Usage - for wrap the relevant casts are inserted by the compiler (one reason for implementing the nine
methods of the listIterator interface by delegation is to ensure that these casts are
inserted), while for checked lists the casts are performed by reflection. Generics usually
render these checks redundant, but they can be helpful in the presence of legacy code
or unchecked warnings, or when dealing with security issues

Specialization by delegation creates a view of an underlying list, can create a view of any list

List<? extends List<?>> lists = Arrays.asList( ListStrings.wrap(Arrays.asList("one","two")),
Arrays.asList(3,4),
Arrays.asList("five","six"),
ListStrings.wrap(Arrays.asList("seven","eight")));

	ListString[] array = new ListString[2];
	int i = 0;
	for (List<?> list : lists)
	if (list instanceof ListString)
	array[i++] = (ListString)list;
	assert Arrays.toString(array).equals("[[one, two], [seven, eight]]");


Specialization by inheritance constructs a new list, can only be applied to a public implementation that can be subclassed

List<String> original = new ArrayList<String>();
ListString delegated = ListStrings.wrap(original);
ListString inherited = new ArrayListString(original);

delegated.add("one");
inherited.add("two");

try {
((List)delegated).add(3); // unchecked, class cast error
} catch (ClassCastException e) {}
((List)inherited).add(4); // unchecked, no class cast error!
*/

// avoid specialization of types containing wildcards
// evolving legacy code to generics look at - Maintaining Binary Compatibility

