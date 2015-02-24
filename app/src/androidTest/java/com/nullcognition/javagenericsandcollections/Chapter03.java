package com.nullcognition.javagenericsandcollections;

import android.util.Log;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by ersin on 16/02/15 at 5:10 PM
 */
public class Chapter03 extends TestCase {


   class C0 implements Comparable<Integer> {

	  public int i = 0;

	  @Override
	  public int compareTo(Integer another){
		 return i > another ? 1 : i < another ? - 1 : 0;
	  }
   }

   class C1 implements Comparable<Integer> {

	  public int i = 1;

	  @Override
	  public int compareTo(Integer another){
		 return i > another ? 1 : i < another ? - 1 : 0;
	  }
   }


   public void testComparison(){

	  String a = "aaa";
	  String b = "bbb";

	  assertEquals(a.compareTo(b), - 1); // b comes after a therefor it is bigger
	  // transitive, natural order is constistant with equals

	  // comparision is explicit: x > y ? 1 : x < y ? -1 :0; nested ternary operator, be explicit with the state of the output

	  assertEquals(new C0().compareTo(new C1().i), - 1); // using comprable interface with custom logic
   }

   public void testFindMax(){
	  List<Integer> list = Arrays.asList(1, 2, 3, 4);
	  assertEquals(findMax(list), list.get(3));

	  List<Comparable<Integer>> list1 = Arrays.asList(new C0(), new C1());
	  // assertEquals(Collections.max(list1),new C1()); how do we compare custom types??
	  // with this <T extends Comparable<? super T>> T max(Collection<? extends T> coll) in the find max sig
	  // and the C classes must extends C which implements Comparable<C>... to be tested

	  // comparable for natural ordering and
	  // comparator for unnatural ordering while overidding compare and equals in the Comparator interface
   }

   // type defined - return of T - parmater of collection of T
   private <T extends Comparable<T>> T findMax(Collection<T> inCollection){

	  Log.e(getClass().getSimpleName(), "findmax"); // will show in android logcat as to which tests are running, but not in the test results

	  T max = inCollection.iterator()
						  .next();

	  for(T _inCollection : inCollection){
		 if(_inCollection.compareTo(max) == 1){ max = _inCollection; }
	  }

	  return max;
   }

   public enum RoboParts { // defined as class Enum<E extends Enum<E>> a recursive typing
	  ARM,
	  LEG,
	  BODY
   } // this corresponds to

//   final class RoboParts extends Enum<RoboParts>{...

// cannot directly extend java.lang.Enum... as the above class code is generated

   interface One {

	  int one();
   }

   interface Onne extends One {

	  int onne();
   }

   interface Two {

	  int two();
   }

   interface Twwo extends Two {

	  int twwo();
   }

   class DoubleImplements implements Onne,
									 Twwo {

	  @Override
	  public int onne(){ return 1;}

	  @Override
	  public int twwo(){ return 2;}

	  @Override
	  public int one(){return 0;}

	  @Override
	  public int two(){return 0;}
   }

   public void testDI(){
	  assertEquals(0, doubleImplements(new DoubleImplements()));
   }

   public <DI extends One & Two> int doubleImplements(DI inDI){
	  return inDI.one() + inDI.two(); // both required methods
   }

   // bridges are the additional methods that are generated when using the paramaritized interface like Comparable<T>

}






















