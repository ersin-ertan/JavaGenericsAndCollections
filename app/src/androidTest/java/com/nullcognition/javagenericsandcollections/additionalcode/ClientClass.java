package com.nullcognition.javagenericsandcollections.additionalcode;

/**
 * Created by ersin on 03/03/15 at 2:18 PM
 */
public class ClientClass {

   public Tree<Double> makeTree(){ // the type of the leaf paramaters are subject to the return type, explicity type parameters on Tree.<Integer>leaf,
	  // and the inferred type, along with the type taken in, if bound, by any static methods defined

	  // start
	  return Tree.branch( // branch							       S
						  Tree.leaf(1.4),// leaf		   		   /\
						  Tree.branch( // branch				    /\
									   Tree.leaf(2.2), // leaf
									   Tree.<Double>leaf(3.6))); // leaf, the type is automatically inferred based on the input

	  // or Tree<Double> tree = Tree.leaf(3.6)...

   }

   public static <TreeOfType> String toString(Tree<TreeOfType> TreeOfType){

	  return TreeOfType.visit(new Tree.Visitor<TreeOfType, String>() {

		 public String leaf(TreeOfType e){
			return e.toString();
		 }

		 public String branch(String l, String r){
			return "(" + l + "^" + r + ")";
		 }
	  });
   }

   public static <NumberSubType extends Number> double sum(Tree<NumberSubType> t){

	  return t.visit(new Tree.Visitor<NumberSubType, Double>() {

		 public Double leaf(NumberSubType e){
			return e.doubleValue();
		 }

		 public Double branch(Double l, Double r){
			return l + r;
		 }
	  });
   }
}

abstract class Tree <TreeOf> {

   public abstract <ReturnTypeOfVisitMethod> ReturnTypeOfVisitMethod visit(Visitor<TreeOf, ReturnTypeOfVisitMethod> visitor);

   public interface Visitor <TreesType, ReturnTypeOfVisitor> {

	  ReturnTypeOfVisitor leaf(TreesType aValue);

	  ReturnTypeOfVisitor branch(ReturnTypeOfVisitor leftTree, ReturnTypeOfVisitor rightTree);

   }

   public static <T> Tree<T> leaf(final T aValue){

	  return new Tree<T>() {

		 public <ReturnType> ReturnType visit(Visitor<T, ReturnType> visitor){
			return visitor.leaf(aValue);
		 }
	  };
   }

   // should take in an input parameter?? why not use the one from the structures initial definition, because it is not type safe, and these
   // static methods can be acessed outside of the Tree's life time/scope thus there would be no type to use
   public static <T> Tree<T> branch(final Tree<T> leftTree, final Tree<T> rightTree){

	  return new Tree<T>() {

		 public <ReturnType> ReturnType visit(Visitor<T, ReturnType> visitor){
			return visitor.branch(leftTree.visit(visitor), rightTree.visit(visitor));
		 }
	  };
   }
}
