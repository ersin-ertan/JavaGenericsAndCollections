package com.nullcognition.javagenericsandcollections;

import junit.framework.TestCase;

/**
 * Created by ersin on 24/02/15 at 6:55 PM
 */
// Chapter04 Declarations - constructors, static, members, and nested classes and some erasure

public class Chapter04 extends TestCase {

   class Con <A, B> {

	  public String s = "";

	  public Con(A a, B b){s = a.toString() + b.toString();}
   }

   public void testConstructor(){
	  Con<String, Integer> con = new Con<>("yo", 1);
	  String s = new Con<>("hi", 4).s; // inferred
   }

   // static members of a generic class may not refer to the type parameter of the class, nor can accessing the static have paramaterized types
   // like AClass<Integer>.staticMethod(); or AClass<?>.staticMeth();
   // but static List<Object> getList()... is allowed

   // the inner class(if not static) shares the fields of the outerclass, including the type parameter
   // but if static, it does not there are two ways to access the type



   public void testInner(){
	  Outer<String>.Inner inner; // second parameter not needed since Inner has the fields from the scope of Outer
	  // vs the better way of:
	  Outerr.Innerr<Integer> innerr; // explicit
   }

}
   class Outer<T>{
	  public class Inner{}
   }
   class Outerr<T>{
	  public static class Innerr<Y>{}
   }

// remember by erasure: List<WhateverType> is a type List even if it is an array List<A>[], raw type's and primatives, and just plain types erasure is itself
// if the type parameter is bound, then it is of the left most type, else it is of Object, unless it is a tie like Comparable & Appendable
// the erasure of the last example is that of the Outer.Inner, regardless of types parameters of either way of access.
