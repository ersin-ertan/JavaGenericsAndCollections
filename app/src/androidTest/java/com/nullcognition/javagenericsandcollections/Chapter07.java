package com.nullcognition.javagenericsandcollections;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ersin on 25/02/15 at 6:50 PM
 */

// Reflection - allows the program to examine its definition, in java 5 the addition of Class<TypeParameter>,

public class Chapter07 extends TestCase {

   public void testClass(){

	  Class<Integer> integerClass = Integer.class;
	  Number num = new Integer(3);
	  Class<? extends Number> classNumber = num.getClass();
	  assertEquals(integerClass, classNumber);
   }

   /* As used in the class class
   class Class<T> {
	  public T newInstance();
	  public T cast(Object o);
	  public Class<? super T> getSuperclass();
	  public <U> Class<? extends U> asSubclass(Class<U> k);
	  public <A extends Annotation> A getAnnotation(Class<A> k);
	  public boolean isAnnotationPresent(Class<? extends Annotation> k);
	  ...
	}
   */

   // reflected types are reifiable types

   public void testReification(){
	  List<Integer> ints = new ArrayList<>();
	  assertEquals(ArrayList.class, ints.getClass());
   }

   // class always represents a reifiable type
   // for class tokens(instances of the Class class), you must supply a raw type; not even unbounded wildcards may appear.

   public void testReflectionPrimitive(){
	  Class<int[]> intarray; // is allowed, but
	  // Class<int> is not a reference type, while int.class is the class token, so when using Class<Integer> and int.class.newInstance() be careful to
	  // what the return type is, as int.class.newInstance() does not return Integer
   }

   // GenericReflection.class generic functions that use reflection in a type safe way

   /*
   The class Class, representing a primitive type or raw type

   interface ParameterizedType, a generic class or interface to parameter types, extract an array of the parameter
	 types

   interface TypeVariable, a type variable, extract the bounds on the type variable

   interface GenericArrayType, an array, extract the array component type

   interface WildcardType,a wildcard, extract a lower or upper bound on the wildcard
   */

}
