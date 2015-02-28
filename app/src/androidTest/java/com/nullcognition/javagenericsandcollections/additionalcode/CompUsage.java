package com.nullcognition.javagenericsandcollections.additionalcode;

import java.util.Comparator;

/**
 * Created by ersin on 27/02/15 at 7:29 PM
 */
public class CompUsage {

   static int counterForCustomClass = 0;

   static class UseTypedComparator <T> implements Comparator<T> {

	  @Override
	  public int compare(T lhs, T rhs){
		 return lhs.toString()
				   .compareTo(rhs.toString());// remember, when using the type parameter, explicit use of extend methods is not allowed unless
		 // the type is refiable at runtime, either by wildcard capture or by using bound wildcards
	  }
   }

   class A {

	  public String a = "a";
   }

   class B {

	  public String b = "b";
   }

   static class UseExplicitComparator implements Comparator<CustomClass> {

	  @Override
	  public int compare(CustomClass lhs, CustomClass rhs){
		 return lhs.customCompare(rhs);
	  }
   }

   class CustomClass {

	  int i = counterForCustomClass++;

	  public int customCompare(CustomClass inCustomClass){
		 int cci = inCustomClass.i;
		 return this.i == cci ? 0 : this.i > cci ? 1 : - 1;
	  }
   }
}
