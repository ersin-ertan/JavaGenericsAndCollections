package com.nullcognition.javagenericsandcollections.designpatterns;

/**
 * Created by ersin on 14/03/15 at 8:42 PM
 */

// Type01 - Advanced Strategy Pattern with Recursive Generics - an object contains the strategy to be applied to it, getThis trick is useful
// in this situation whenever one wants to use this in the base type with the more specific type provided by the type parameter
// protected abstract P getThis();
	  /*
	  	abstract class Trust<T extends Trust<T>> extends TaxPayer<T> { ... }
		final class NonProfitTrust extends Trust<NonProfitTrust> { ... }
		final class ForProfitTrust extends Trust<ForProfitTrust> { ... }
	  */

public class StrategyRecursiveGenerics {}
