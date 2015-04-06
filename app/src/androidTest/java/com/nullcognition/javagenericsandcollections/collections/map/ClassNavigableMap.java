package com.nullcognition.javagenericsandcollections.collections.map;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/**
 * Created by ersin on 05/04/15 at 4:42 PM
 */
// is an interface, not an implementation
public class ClassNavigableMap { // et first/last, retreieve comparator find subseqeunces, associations are Map.Entry, snapshot objects, closest matches

   NavigableMap<Integer, String> navigableMap = new NavigableMap<Integer, String>() {

	  @Override
	  public void clear(){

	  }

	  @Override
	  public boolean containsKey(Object key){

		 return false;
	  }

	  @Override
	  public boolean containsValue(Object value){

		 return false;
	  }

	  @Override
	  public Set<Entry<Integer, String>> entrySet(){

		 return null;
	  }

	  @Override
	  public boolean equals(Object object){

		 return false;
	  }

	  @Override
	  public String get(Object key){

		 return null;
	  }

	  @Override
	  public int hashCode(){

		 return 0;
	  }

	  @Override
	  public boolean isEmpty(){

		 return false;
	  }

	  @Override
	  public Set<Integer> keySet(){

		 return null;
	  }

	  @Override
	  public String put(Integer key, String value){

		 return null;
	  }

	  @Override
	  public void putAll(Map<? extends Integer, ? extends String> map){

	  }

	  @Override
	  public String remove(Object key){

		 return null;
	  }

	  @Override
	  public int size(){

		 return 0;
	  }

	  @Override
	  public Collection<String> values(){

		 return null;
	  }

	  @Override
	  public Entry<Integer, String> lowerEntry(Integer key){

		 return null;
	  }

	  @Override
	  public Integer lowerKey(Integer key){

		 return null;
	  }

	  @Override
	  public Entry<Integer, String> floorEntry(Integer key){

		 return null;
	  }

	  @Override
	  public Integer floorKey(Integer key){

		 return null;
	  }

	  @Override
	  public Entry<Integer, String> ceilingEntry(Integer key){

		 return null;
	  }

	  @Override
	  public Integer ceilingKey(Integer key){

		 return null;
	  }

	  @Override
	  public Entry<Integer, String> higherEntry(Integer key){

		 return null;
	  }

	  @Override
	  public Integer higherKey(Integer key){

		 return null;
	  }

	  @Override
	  public Entry<Integer, String> firstEntry(){

		 return null;
	  }

	  @Override
	  public Entry<Integer, String> lastEntry(){

		 return null;
	  }

	  @Override
	  public Entry<Integer, String> pollFirstEntry(){

		 return null;
	  }

	  @Override
	  public Entry<Integer, String> pollLastEntry(){

		 return null;
	  }

	  @Override
	  public NavigableMap<Integer, String> descendingMap(){

		 return null;
	  }

	  @Override
	  public NavigableSet<Integer> navigableKeySet(){

		 return null;
	  }

	  @Override
	  public NavigableSet<Integer> descendingKeySet(){

		 return null;
	  }

	  @Override
	  public NavigableMap<Integer, String> subMap(Integer fromKey, boolean fromInclusive, Integer toKey, boolean toInclusive){

		 return null;
	  }

	  @Override
	  public NavigableMap<Integer, String> headMap(Integer toKey, boolean inclusive){

		 return null;
	  }

	  @Override
	  public NavigableMap<Integer, String> tailMap(Integer fromKey, boolean inclusive){

		 return null;
	  }

	  @Override
	  public SortedMap<Integer, String> subMap(Integer fromKey, Integer toKey){

		 return null;
	  }

	  @Override
	  public Comparator<? super Integer> comparator(){

		 return null;
	  }

	  @Override
	  public Integer firstKey(){

		 return null;
	  }

	  @Override
	  public SortedMap<Integer, String> headMap(Integer toKey){

		 return null;
	  }

	  @Override
	  public Integer lastKey(){

		 return null;
	  }

	  @Override
	  public SortedMap<Integer, String> tailMap(Integer fromKey){

		 return null;
	  }
   };

}
