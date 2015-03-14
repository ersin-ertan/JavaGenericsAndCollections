package com.nullcognition.javagenericsandcollections.designpatterns;

import android.util.Log;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ersin on 02/03/15 at 10:44 PM
 */

// converts an arbitrary method into an object, similar to the relation between Comparator and the compareTo method
// use a type variable in the throws clause of a method declaration

interface Function <A, B, C extends Throwable> {

   // type parameters of the input, output and throwable

   B apply(A a) throws C;
}

public class Functions {

   // returns the list of B with the result of the function applied to each element of list A
   public static <A, B, C extends Throwable> List<B> applyAll(Function<A, B, C> function, List<A> list) throws C{

	  List<B> result = new ArrayList<>(list.size());

	  for(A a : list){ result.add(function.apply(a)); }

	  return result;
   }

   public static void makeFunction(String[] str){

	  Function<String, Integer, Error> length = new Function<String, Integer, Error>() { // when creating the new anon inner class with type variables
		 // they must be repeated in the instantiation ^

		 public Integer apply(String s){ // take in a String, return and Integer, throw an Error
			return s.length();
		 }
	  };

	  Function<String, Class<?>, ClassNotFoundException> forName = new Function<String, Class<?>, ClassNotFoundException>() {

		 public Class<?> apply(String s) throws ClassNotFoundException{
			return Class.forName(s);
		 }
	  };

	  Function<String, Method, Exception> getRunMethod = new Function<String, Method, Exception>() {

		 public Method apply(String s) throws ClassNotFoundException, NoSuchMethodException{
			return Class.forName(s)
						.getMethod("run");
		 }
	  };

	  List<String> strings = Arrays.asList(str);
	  Log.e("Client of Function", applyAll(length, strings).toString()); // takes the list and since length, as the function was defined, returns the list of lengths

	  try{ Log.e("applyAll forName", applyAll(forName, strings).toString()); } // notice the different catches needed by the differnt functions
	  catch(ClassNotFoundException e){ Log.e("ClassNotFoundException", e.toString());}

	  try{ Log.e("applyAll forName", applyAll(getRunMethod, strings).toString()); }
	  catch(ClassNotFoundException e){ Log.e("ClassNotFoundException", e.toString());}
	  catch(NoSuchMethodException e){ Log.e("NoSuchMethodException", e.toString());}
	  catch(RuntimeException e){ throw e;}
	  catch(Exception e){ throw new AssertionError(); }
   }
}
