package com.nullcognition.javagenericsandcollections.designpatterns;

/**
 * Created by ersin on 02/03/15 at 10:43 PM
 */

// provide new operations without modifying the classes that define the data structure
// way of separating an algorithm from an object structure on which it operates

public class VisitorClass {

   // static - our custom defined toString, returning the VTree instances function visit's result
   public static <TreeOfType> String toString(VTree<TreeOfType> TreeOfType){ 

	  return TreeOfType.visit(new VTree.Visitor<TreeOfType, String>() {

		 public String leaf(TreeOfType e){
			return e.toString();
		 }

		 public String branch(String l, String r){
			return "(" + l + "^" + r + ")";
		 }
	  });
   }

   public static <NumberSubType extends Number> double sum(VTree<NumberSubType> t){

	  return t.visit(new VTree.Visitor<NumberSubType, Double>() {

		 public Double leaf(NumberSubType e){
			return e.doubleValue();
		 }

		 public Double branch(Double l, Double r){
			return l + r;
		 }
	  });
   }

   public static void makeVisitorTree(){ // same instantiation but methods are defined external to the structure of the tree class
	  VTree<Integer> integerVTree = // start
		VTree.branch( // branch							   S
					  VTree.leaf(1),// leaf				   /\
					  VTree.branch( // branch					/\
									VTree.leaf(2), // leaf
									VTree.leaf(3))); // leaf
   }

   public static void makeGenericTree(){
	  Tree<Integer> integerTree = // start
		Tree.branch( // branch							   S
					 Tree.leaf(1),// leaf				   /\
					 Tree.branch( // branch					/\
								  Tree.leaf(2), // leaf
								  Tree.leaf(3))); // leaf
   }
}

abstract class VTree <TreeOfType> {

   public interface Visitor <TreeOfType, ReturnType> {

	  ReturnType leaf(TreeOfType inE);

	  ReturnType branch(ReturnType left, ReturnType right);
   }


   public abstract <ReturnType> ReturnType visit(Visitor<TreeOfType, ReturnType> v);

   public static <TreeOfType> VTree<TreeOfType> leaf(final TreeOfType e){

	  return new VTree<TreeOfType>() {

		 public <ReturnType> ReturnType visit(Visitor<TreeOfType, ReturnType> v){
			return v.leaf(e);
		 }
	  };
   }

   public static <TreeOfType> VTree<TreeOfType> branch(final VTree<TreeOfType> l, final VTree<TreeOfType> r){

	  return new VTree<TreeOfType>() {

		 public <ReturnType> ReturnType visit(Visitor<TreeOfType, ReturnType> v){
			return v.branch(l.visit(v), r.visit(v));
		 }
	  };
   }


}

abstract class Tree <E> {

   abstract public String toString();

   abstract public double sum();

   public static <E> Tree<E> leaf(final E inTree){
	  return new Tree<E>() {

		 @Override
		 public String toString(){
			return inTree.toString();
		 }

		 @Override
		 public double sum(){
			return ((Number)inTree).doubleValue();
		 }
	  };

   }

   public static <E> Tree<E> branch(final Tree<E> inTree, final Tree<E> inTreee){
	  return new Tree<E>() {

		 @Override
		 public String toString(){
			return inTree.toString() + inTreee;
		 }

		 @Override
		 public double sum(){
			return inTree.sum() + inTreee.sum();
		 }
	  };
   }
}
