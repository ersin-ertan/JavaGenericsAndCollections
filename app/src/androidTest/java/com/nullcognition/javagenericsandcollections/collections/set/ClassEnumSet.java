package com.nullcognition.javagenericsandcollections.collections.set;

import junit.framework.TestCase;

import java.util.EnumSet;

/**
 * Created by ersin on 26/03/15 at 10:53 PM
 */
public class ClassEnumSet extends TestCase {

   enum AEnum {
	  A,
	  B,
	  C,
	  D
   }

   // field defiinitions --------------------
   EnumSet<AEnum> enumSet;

   AEnum me = AEnum.A;

   public void enumSetMethod(){

	  enumSet.add(AEnum.C);
	  enumSet.add(AEnum.B);
	  enumSet.add(me);

	  EnumSet<AEnum> es = EnumSet.of(AEnum.A); // only has a element
	  es = EnumSet.of(me); // same thing

	  es = EnumSet.complementOf(enumSet); // will contain all but D

	  es = EnumSet.range(AEnum.A, AEnum.C); // inclusive?
	  // .noneOf, .allOf

	  es = EnumSet.of(AEnum.D, new AEnum[]{AEnum.A, AEnum.B}); // first, and varargs
   }


}
