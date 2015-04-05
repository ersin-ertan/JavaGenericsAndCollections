package com.nullcognition.javagenericsandcollections.collections.map;

import android.util.ArrayMap;

import junit.framework.TestCase;

import java.util.Map;

import hugo.weaving.DebugLog;

/**
 * Created by ersin on 01/04/15 at 10:34 PM
 */
public class TestMap extends TestCase {

   @DebugLog
   public void testMap(){

	  Map<Integer, Integer> map = new ArrayMap<>(100);

	  Integer i = map.put(1, 1);
	  assertEquals(null, i);

	  Integer ii = map.put(1, 2);
	  assertEquals(1, (int)ii);

	  // testing the returns from put when there is no key-value associations, and when there is

   }
}
