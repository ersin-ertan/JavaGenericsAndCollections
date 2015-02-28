package com.nullcognition.javagenericsandcollections;

import junit.framework.TestCase;

/**
 * Created by ersin on 26/02/15 at 9:48 PM
 */

// Design Patterns - Visitor, Interpreter, Function, Strategy, and Subject-Observer
// a data structure is defined by case analysis and recursion

public class Chapter09 extends TestCase {

   public void testVisitor(){ // provide new operations without modifying the classes that define the data structure
	  //  way of separating an algorithm from an object structure on which it operates

   }

   public void testInterpreter(){ // specifies how to evaluate sentences in a language
	  // have a class for each symbol, syntax tree of a sentence in the language is an instance of the composite pattern and is used to evaluate
	  // (interpret) the sentence for a client - composite pattern composite pattern describes that a group of objects is to be treated in the same
	  // way as a single instance of an object

   }

   public void testFunction(){ // converts an arbitrary method into an object, similar to the relation between Comparator and the compareTo method
	  // use a type variable in the throws clause of a method declaration

   }

   public void testStrategy(){ // used to decouple a method from an object, allowing you supply many possible instances of the method
	  // Type00 - Parallel Class Hierarchies - Generics allow us to specialize a given tax strategy to a given type of tax payer, and
	  // allow the compiler to detect when a tax strategy is applied to the wrong type of tax payer

	  // Type01 - Advanced Strategy Pattern with Recursive Generics - an object contains the strategy to be applied to it, getThis trick is useful
	  // in this situation whenever one wants to use this in the base type with the more specific type provided by the type parameter
	  // protected abstract P getThis();
	  /*
	  	abstract class Trust<T extends Trust<T>> extends TaxPayer<T> { ... }
		final class NonProfitTrust extends Trust<NonProfitTrust> { ... }
		final class ForProfitTrust extends Trust<ForProfitTrust> { ... }
	  */
   }

   public void testSubjectObserver(){// Subject-Observer pattern uses parallel class hierarchies, but this time we require two type variables with
   // mutually recursive bounds, one to stand for the specific kind of subject and one to stand for the specific kind of observer


   }


}
