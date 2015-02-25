package com.nullcognition.javagenericsandcollections;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ersin on 25/02/15 at 11:43 AM
 */

// reification - explicit runtime type, generic types do not reify information about their type parameters, arrays do

// know the difference between reifiable and non - some tricky ones may be - List<?> and interface is reifiable, while bounded List<? extends I>
// and paramaratized with reifiable type like List<String> is not

public class Chapter06 extends TestCase {

   public void testInstance(Object o){
	  // if(o instanceof List<E>) // compile time error because List<E> is non reifiable, any casts will issue an unchecked warning
	  // however, using
	  if(o instanceof List<?>){ Iterator<?> com = ((List<?>)o).iterator(); }
	  ; // works due to reifiable type, which is of subtype to Object(for casting purposes)

   }

   public void testArrayCreation(){

	  // remember that an array is a reifiable type of which it was given to, but due to covariance and contravariance, going to a super type perserves the typing
	  Integer[] ints = new Integer[]{1, 3, 4};
	  Number[] nums = ints;
	  // thus doing nums[0] = 4.23; assignment will lead to an array store exception, as the Number[] is referencing type Integer[]
	  assertEquals(true, nums instanceof Integer[]); // not a real test, due to always being true... (read more about this)

	  // new List<Integer>[] {a,b} is not allowed, not refiable, new T[3] not allowed due to generic array creation
   }

   // The Principal Of Truth In Advertising - the reified type of an array must be the subtype of... the erasure of its static subtype
   // collections framework has two methods of converting collections to arrays: public Object[] toArray(); public <T> T[] toArray(T[] a)

   // classes may be used as an alternative: String.class has type Class<String>

   public static <T> T[] testToArray(Collection<T> c, Class<T> k){
	  T[] a = (T[])java.lang.reflect.Array. // unchecked cast
		newInstance(k, c.size());
	  int i = 0;
	  for(T x : c){ a[i++] = x; }
	  return a;
   }
   // with the call of List<String> strings = Arrays.asList("one", "two"); String[] a = toArray(strings, String.class);

   // The Principal of Indecent Exposure - never publicly expose an array where the components do not have a reifiable type
   // its an error to create an array of a non refieable type, but one may be declared and perform an unchecked cast
   // since reification is necessary to prevent erronious types entering a super type referencing a subtype see testArrayCreation, the same can be applied to arrays
   // attempting List<? extends Number>[] = List<Integer>[]... // class cast exception
   // note: the reflection library dose violate this principal with getTypeParameters() on methods and classes

   // Varargs should be of a reifiable type. (A vararg of a nonreifiable type will issue an unchecked warning.)

   // arrays as depreciated types? collections offer precise type saftey, flexiblity-array,linkedlist,trees,hashtables, bound elements
}
