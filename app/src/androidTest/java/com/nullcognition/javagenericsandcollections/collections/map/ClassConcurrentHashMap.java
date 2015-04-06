package com.nullcognition.javagenericsandcollections.collections.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ersin on 05/04/15 at 4:42 PM
 */
public class ClassConcurrentHashMap {

   ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
   // all operations are thread safe, retrieval do not entail locking and there is not support for locking the entire table
   // update operation for a given key bears a happens-before relation with non null retreivals for the key reporting the updated value
   // iterators are designed to be used onely one thread at a time
//   size isempty and containsvalue are used for peek into transient values, thus are used for monitoring and not logic control

   //dynamically expandede when there are too many collisions, 2 bins per mapping, is 0.5 load factor threshold
   // use Comparable keys to help break ties for comparisions, does not allow null to be used as key/value


   public void method(){
      concurrentHashMap.putIfAbsent("a", 1); // if specified key is not associated with a given key then associate it
   }

}
