package com.nullcognition.javagenericsandcollections.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ersin on 02/03/15 at 10:44 PM
 */

// converts an arbitrary method into an object, similar to the relation between Comparator and the compareTo method
// use a type variable in the throws clause of a method declaration

interface FunctionInterface <A, B, C extends Throwable> {

   B apply(A a) throws C;
}

public class Function {

   public static <A, B, C extends Throwable> List<B> applyAll(FunctionInterface<A, B, C> function, List<A> list) throws C{
	  List<B> result = new ArrayList<>(list.size());

	  for(A a : list){ result.add(function.apply(a)); }
	  return result;
   }

}
