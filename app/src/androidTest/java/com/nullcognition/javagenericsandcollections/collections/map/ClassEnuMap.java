package com.nullcognition.javagenericsandcollections.collections.map;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ersin on 05/04/15 at 4:42 PM
 */
public class ClassEnuMap {

   enum mapOfEnums {
	  a,
	  b,
	  c,
	  d,
	  e
   }

   EnumMap<mapOfEnums, String> enumMap = new EnumMap<mapOfEnums, String>(mapOfEnums.class); // the type parameter is the enum, the constructor
   // takes in the enum class generated

   public void enumMaps(){

	  enumMap.put(mapOfEnums.a, "a");
	  enumMap.put(mapOfEnums.b, "b");
	  enumMap.put(mapOfEnums.c, "c");

	  String firstValue = enumMap.get(mapOfEnums.a);

	  Set<mapOfEnums> set = enumMap.keySet();

	  Iterator<mapOfEnums> it = enumMap.keySet()
									   .iterator();
	  Iterator<String> itt = enumMap.values()
									.iterator();
	  boolean haveE = enumMap.keySet()
							 .contains(mapOfEnums.e); // can either get the set,

	  boolean haveAString = enumMap.containsValue("a"); // or check the enum map

   }

}
