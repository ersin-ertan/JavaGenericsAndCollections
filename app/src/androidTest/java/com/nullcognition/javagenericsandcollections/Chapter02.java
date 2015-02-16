package com.nullcognition.javagenericsandcollections;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ersin on 16/02/15 at 3:32 PM
 */
public class Chapter02 extends TestCase {

   public Chapter02(){}

   public void testAddAll(){

	  List<Number> nums = new ArrayList<>();
	  List<Integer> ints = Arrays.asList(1, 4);
	  List<Double> doubs = Arrays.asList(2.3, 2.2);

	  nums.addAll(ints); // argument Collection<? extends Number>
	  nums.addAll(doubs);

	  assertEquals(nums.size(), 4);
   }

   public void testCopy(){

	  List<Object> obs = Arrays.<Object>asList("a", "b", "c"); // use of type of list
	  List<Integer> ints = Arrays.asList(1, 3);

	  Collections.copy(obs, ints);

	  assertEquals("[1, 3, c]", obs.toString());

   }

   public void testExtends(){

	  List<Integer> ints = Arrays.asList(1, 3); // Arrays.asList: Returns a fixed-size list backed by the specified array.
	  //You can't add to it; you can't remove from it. You can't structurally modify the List.
	  List<? extends Number> exNum = new LinkedList<>(ints);

	  exNum.remove(1);

	  assertEquals("[1]", exNum.toString());
   }

   // array subtyping is covarient, generics subtyping is not
   // Type parameters prevent you from creating a list of ints with the type obj and comparing it to another list of ints, as the list of type object may
   // be modified to have non int values, therefor forcing the compile time error

   public void testWildCardCapture(){

	  List<Object> list = new ArrayList<>(Arrays.<Object>asList(1, 2, 3, 4, 5));

	  capture(list);

	  assertEquals("[5, 4, 3, 2, 1]", list.toString());
   }

   public void capture(List<?> list){ rev(list);} // this is used to capture the type, allowing for the method to do type specific operations

   public <T> void rev(List<T> list){

	  // instead of List<?> list
	  List<T> tmpList = new ArrayList<T>(list);

	  int num = list.size();
	  for(T _tmpList : tmpList){
		 list.set(-- num, _tmpList); // to use set we have to know the type is safe to use the method, hence the wildcard type capture
	  }
   }

   // Wildcard restrictions, not with instance creation, generic method calls(they must be inferrable meth.do() or explicit meth.<Object>do())
   // and with super types - extends ArrayList<?>, but in all three cases List<List<?>> nested generics are fine
}



















