package com.nullcognition.javagenericsandcollections.designpatterns;

/**
 * Created by ersin on 02/03/15 at 10:44 PM
 */

// used to decouple a method from an object, allowing you supply many possible instances of the method
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

public class Strategy {}
