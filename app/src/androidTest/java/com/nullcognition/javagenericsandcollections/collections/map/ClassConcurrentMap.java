package com.nullcognition.javagenericsandcollections.collections.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ersin on 05/04/15 at 4:42 PM
 */
public class ClassConcurrentMap { // another interface, high preformance server applications ase a thread safe cache
//   serial access, putIfAbsent if value does not have key associations

   ConcurrentMap<String, Integer> concurrentMap = new ConcurrentMap<String, Integer>() {

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
	  public Set<Entry<String, Integer>> entrySet(){

		 return null;
	  }

	  @Override
	  public Integer get(Object key){

		 return null;
	  }

	  @Override
	  public boolean isEmpty(){

		 return false;
	  }

	  @Override
	  public Set<String> keySet(){

		 return null;
	  }

	  @Override
	  public Integer put(String key, Integer value){

		 return null;
	  }

	  @Override
	  public void putAll(Map<? extends String, ? extends Integer> map){

	  }

	  @Override
	  public Integer remove(Object key){

		 return null;
	  }

	  @Override
	  public int size(){

		 return 0;
	  }

	  @Override
	  public Collection<Integer> values(){

		 return null;
	  }

	  @Override
	  public Integer putIfAbsent(String key, Integer value){

		 return null;
	  }

	  @Override
	  public boolean remove(Object key, Object value){

		 return false;
	  }

	  @Override
	  public boolean replace(String key, Integer oldValue, Integer newValue){

		 return false;
	  }

	  @Override
	  public Integer replace(String key, Integer value){

		 return null;
	  }
   };
}
