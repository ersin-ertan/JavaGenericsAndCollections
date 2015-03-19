package com.nullcognition.javagenericsandcollections.designpatterns;

/**
 * Created by ersin on 14/03/15 at 8:42 PM
 */

// Advanced Strategy Pattern with Recursive Generics - an object contains the strategy to be applied to it, getThis trick is useful
// in this situation whenever one wants to use this in the base type, the compiler will no inffer the correct type thus,
// protected abstract P getThis(); // which is rename to getThisOfSubClass
// in the abstract TaxPayer class, and the subclasses implementing the method to return its type explicitly, causing the class to be final
// if a subclass is needed, then the base class must take in its type parameter as shown below.
	  /*

	  	abstract class Trust<T extends Trust<T>> extends TaxPayer<T> { ... }
		final class NonProfitTrust extends Trust<NonProfitTrust> { ... }
		final class ForProfitTrust extends Trust<ForProfitTrust> { ... }

	  */

public class StrategyRecursiveGenerics {

   public static void clientProvideStrategy(){

	  long amount = 10000000L;

	  Person person = new Person(amount, new DefaultTaxStrategy<Person>());
	  Person person1 = new Person(amount, new DodgingTaxStrategy<Person>());
	  Trust nonProfit = new Trust(amount, new TrustTaxStrategy(), true);
	  Trust forProfit = new Trust(amount, new TrustTaxStrategy(), false);

	  assert person.computeTax() == 4000000;
	  assert person1.computeTax() == 0;

	  assert nonProfit.computeTax() == 0;
	  assert forProfit.computeTax() == 4000000;
   }
}


abstract class TaxPayer <T extends TaxPayer<T>> {

   long income = 0;

   public long getIncome(){return income;}

   private TaxStrategy<T> taxStrategy;

   public TaxPayer(long inIncome, TaxStrategy inTaxStrategy){
	  income = inIncome;
	  taxStrategy = inTaxStrategy;
   }

   public long computeTax(){ return taxStrategy.computeTax(getThis()); }

   abstract T getThis();
}

class Person extends TaxPayer<Person> {

   Person(long inIncome, TaxStrategy inTaxStrategy){
	  super(inIncome, inTaxStrategy);
   }

   @Override
   Person getThis(){ return this; }

}

final class Trust extends TaxPayer<Trust> {

   private boolean isNonProfit = false;

   public boolean getIsNonProfit(){ return isNonProfit;}

   Trust(long inIncome, TaxStrategy inTaxStrategy, boolean inIsNonProfit){
	  super(inIncome, inTaxStrategy);
	  isNonProfit = inIsNonProfit;
   }

   @Override
   Trust getThis(){ return this; }
}

interface TaxStrategy <TP extends TaxPayer<TP>> {

   public long computeTax(TP t);

}

class DefaultTaxStrategy <TP extends TaxPayer<TP>> implements TaxStrategy<TP> {

   public static final double RATE = 0.04;

   @Override
   public long computeTax(TP t){
	  return Math.round(t.getIncome() * RATE);
   }
}

class DodgingTaxStrategy <TP extends TaxPayer<TP>> implements TaxStrategy<TP> {

   @Override
   public long computeTax(TP t){return 0;}
}

class TrustTaxStrategy extends DefaultTaxStrategy<Trust> { // which already implements TaxStrategy<Trust>{

   @Override
   public long computeTax(Trust t){
	  return t.getIsNonProfit() ? 0 : super.computeTax(t);
   }
}
