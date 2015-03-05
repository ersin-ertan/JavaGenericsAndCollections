package com.nullcognition.javagenericsandcollections.designpatterns;

/**
 * Created by ersin on 02/03/15 at 10:44 PM
 */

// specifies how to evaluate sentences in a language
// have a class for each symbol, syntax tree of a sentence in the language is an instance of the composite pattern and is used to evaluate
// (interpret) the sentence for a client - composite pattern describes that a group of objects is to be treated in the same
// way as a single instance of an object

public class Interpreter {

   public static void makeExpression(){
	  Expression<Integer> expression = // expression
		Expression.left( // left of
						 Expression.pair( // the pair of
										  Expression.plus(Expression.literal(3), Expression.literal(4)), // literal a
										  Expression.literal(5))); // literal b
   }
}

class Pair <A, B> {

   private final A a;
   private final B b;

   public Pair(A aa, B bb){
	  a = aa;
	  b = bb;
   }

   public A getLeft(){return a;}

   public B getRight(){return b;}
}

abstract class Expression <T> {

   public abstract T evaluate();

   static public Expression<Integer> literal(final int i){

	  return new Expression<Integer>() {

		 @Override
		 public Integer evaluate(){return i;}
	  };
   }

   static public Expression<Integer> plus(final Expression<Integer> a, final Expression<Integer> b){

	  return new Expression<Integer>() {

		 @Override
		 public Integer evaluate(){return a.evaluate() + b.evaluate();}
	  };
   }

   static public <A, B> Expression<Pair<A, B>> pair(final Expression<A> a, final Expression<B> b){

	  return new Expression<Pair<A, B>>() {

		 @Override
		 public Pair<A, B> evaluate(){
			return new Pair<>(a.evaluate(), b.evaluate());
		 }
	  };
   }

   static public <A, B> Expression<A> left(final Expression<Pair<A, B>> a){

	  return new Expression<A>() {

		 @Override
		 public A evaluate(){
			return a.evaluate()
					.getLeft();
		 }
	  };
   }

   static public <A, B> Expression<B> right(final Expression<Pair<A, B>> b){

	  return new Expression<B>() {

		 @Override
		 public B evaluate(){
			return b.evaluate()
					.getRight();
		 }
	  };
   }
}
