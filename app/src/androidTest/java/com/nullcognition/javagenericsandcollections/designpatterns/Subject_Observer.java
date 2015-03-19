package com.nullcognition.javagenericsandcollections.designpatterns;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ersin on 02/03/15 at 10:44 PM
 */

// Subject-Observer pattern uses parallel class hierarchies, but this time we require two type variables with
// mutually recursive bounds, one to stand for the specific kind of subject and one to stand for the specific kind of observer

   // provided observer and observable implementation from book is not in sync with the java implementation, as the java implementation does not
   // allow for generics

public class Subject_Observer {

   enum Currency {
	  DOL,
	  EUR,
	  PND
   }

   class StubException extends UnsupportedOperationException {}

   public class Observable <S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {

	  List<Observer> observerList = new LinkedList<>();
	  boolean hasChanged = false;

	  public void addObserver(O o){ observerList.add(o);}

	  protected void clearChanged(){ hasChanged = false;}

	  public int countObservers(){ return observerList.size();}

	  public void deleteObserver(O o){ observerList.remove(o);}

	  public boolean hasChanged(){ return hasChanged;}

	  public void notifyObservers(){
		 for(Observer _observerList : observerList){
			// _observerList.update(); // not sure on how to implement the observer update, which takes in the observable and the type
			// unless there is some kind of data object(ike the EnumMap) that is stored in the observable.
		 }
	  }

	  public void notifyObservers(A a){ throw new StubException();}

	  protected void setChanged(){ }
   }

   public interface Observer <S extends Subject_Observer.Observable<S, O, A>, O extends Observer<S, O, A>, A> {

	  public void update(S o, A a);
   }

   class CModel extends Observable<CModel, CView, Currency> {

	  private final EnumMap<Currency, Double> rates;
	  private long     value    = 0; // cents, euro cents, or pence
	  private Currency currency = Currency.DOL;

	  public CModel(){
		 rates = new EnumMap<Currency, Double>(Currency.class);
	  }

	  public void initialize(double... initialRates){
		 for(int i = 0; i < initialRates.length; i++){ setRate(Currency.values()[i], initialRates[i]); }
	  }

	  public void setRate(Currency currency, double rate){
		 rates.put(currency, rate);
		 setChanged();
		 notifyObservers(currency);
	  }

	  public void setValue(Currency currency, long value){
		 this.currency = currency;
		 this.value = value;
		 setChanged();
		 notifyObservers(null);
	  }

	  public double getRate(Currency currency){
		 return rates.get(currency);
	  }

	  public long getValue(Currency currency){
		 if(currency == this.currency){ return value; }
		 else{ return Math.round(value * getRate(currency) / getRate(this.currency)); }
	  }
   }

   interface CView extends Observer<CModel, CView, Currency> {}

   class RateView implements CView {

	  private final CModel   model;
	  private final Currency currency;

	  public RateView(final CModel model, final Currency currency){
		 this.model = model;
		 this.currency = currency;
		 model.addObserver(this);
	  }

	  public void setRate(double inRate){
		 try{
			double rate = inRate;
			model.setRate(currency, rate);
		 }
		 catch(NumberFormatException x){}
	  }


	  public void update(CModel model, Currency currency){
		 if(this.currency == currency){
			double rate = model.getRate(currency);
			// setText(String.format("%10.6f", rate));
		 }
	  }
   }

   class ValueView implements CView {

	  private final CModel   model;
	  private final Currency currency;

	  public ValueView(final CModel model, final Currency currency){
		 this.model = model;
		 this.currency = currency;
		 model.addObserver(this);
	  }

	  public void setValue(double inValue){
		 try{
			long value = Math.round(100.0 * inValue);
			model.setValue(currency, value);
		 }
		 catch(NumberFormatException x){}
	  }

	  public void update(CModel model, Currency currency){
		 if(currency == null || currency == this.currency){
			long value = model.getValue(this.currency);
			// setText(String.format("%15d.%02d", value / 100, value % 100));
		 }
	  }
   }

   class Converter {

	  public Converter(){
		 CModel model = new CModel();
		 model.initialize(1.0, 0.83, 0.56);
	  }

	  public void runClient(){
		 new Converter();
	  }
   }
}
