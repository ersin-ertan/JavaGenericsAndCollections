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

class StrategyParallelClassHierarchy { // given a tax strategy, generics will use the type Taxpayer as defined in the TaxStrategy interface, and error if
   // the type is not compatible at compile time

   // the two parallel class hierarchies are the taxyaper, person and trust
   // and the other is of strategies coresponding to: DefaultTaxStrategy and DodgingTaxStrategy, as they apply to TaxPayer, non for Person, and one for Trust

   abstract class TaxPayer {

	  public long income; // value in cents, to avoid floating point error

	  public TaxPayer(long inIncome){income = inIncome;}

	  public long getIncome(){return income;}
   }

   class Person extends TaxPayer {

	  public Person(long income){super(income);}
   }

   class Trust extends TaxPayer {

	  private boolean nonProfit;

	  public Trust(long income, boolean nonProfit){

		 super(income);
		 this.nonProfit = nonProfit;
	  }

	  public boolean isNonProfit(){ return nonProfit; }
   }

   interface TaxStrategy <P extends TaxPayer> {

	  public long computeTax(P p);
   }

   class DefaultTaxStrategy <P extends TaxPayer> implements TaxStrategy<P> {

	  private static final double RATE = 0.04;

	  public long computeTax(P payer){return Math.round(payer.getIncome() * RATE);}
   }

   class DodgingTaxStrategy <P extends TaxPayer> implements TaxStrategy<P> {

	  public long computeTax(P payer){return 0;}
   }

   class TrustTaxStrategy extends DefaultTaxStrategy<Trust> {

	  public long computeTax(Trust trust){
		 return trust.isNonProfit() ? 0 : super.computeTax(trust);
	  }
   }
}
