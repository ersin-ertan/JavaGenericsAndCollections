package com.nullcognition.javagenericsandcollections;

import com.nullcognition.javagenericsandcollections.designpatterns.Functions;
import com.nullcognition.javagenericsandcollections.designpatterns.Interpreter;
import com.nullcognition.javagenericsandcollections.designpatterns.StrategyParallelClassHierarchy;
import com.nullcognition.javagenericsandcollections.designpatterns.StrategyRecursiveGenerics;
import com.nullcognition.javagenericsandcollections.designpatterns.VisitorClass;

import junit.framework.TestCase;

/**
 * Created by ersin on 26/02/15 at 9:48 PM
 */

// Design Patterns - Visitor, Interpreter, Function, Strategy, and Subject-Observer
// a data structure is defined by case analysis and recursion

public class Chapter09 extends TestCase {

   public void testVisitor(){

	  try{
		 VisitorClass.makeGenericTree();
		 VisitorClass.makeVisitorTree();
	  }
	  catch(Exception e){e.getMessage();}
   }

   public void testInterpreter(){

	  try{Interpreter.makeExpression();}
	  catch(Exception e){e.getMessage();}
   }

   public void testFunction(){

	  try{Functions.makeFunction(new String[]{"this", "is", "a", "str"});}
	  catch(Exception e){e.getMessage();}
   }

   public void testStrategyParallel(){

	  try{new StrategyParallelClassHierarchy().clientAssignStrategy();}
	  catch(Exception e){e.getMessage();}
   }

   public void testStrategyRecursive(){

	  try{StrategyRecursiveGenerics.clientProvideStrategy();}
	  catch(Exception e){e.getMessage();}
   }

   public void testSubjectObserver(){

   }


}
