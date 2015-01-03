package com.nullcognition.javagenericsandcollections;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  generics();
   }

   private void generics(){
	  List<Integer> ints = Arrays.asList(1, 2, 3);

	  for(int n : ints){
		 Log.e(getClass().getSimpleName(), Integer.toString(n));
		 if(((Integer)(ints.indexOf(n) + 1)).equals(null)){
			ints.remove(n); // should remove the last element, unless there is a null evaluation error
		 }
	  }

	  // unless one of the elements give the type for the compiler to infer
	  // List<Comparable> list = Arrays.asList(new SomeComparable(1), new SomeComparable(2), (Comparable)new SomeComparable(3));

	  // an explicit type must be given to the creation of the list
	  List<Comparable> list = Arrays.<Comparable>asList(new SomeComparable(1), new SomeComparable(2), new SomeComparable(3));

	  genMethod(list);

   }

   private Comparable genMethod(List<Comparable> inTs){

	  Comparable largestT = inTs.get(0); // can be null, what do you return if it is?

	  for(Comparable _inTs : inTs){
		 if(_inTs.compareTo(largestT) == 1){
			largestT = _inTs; // cant compare because your don't know if the element is comparable
		 }
	  }
	  return largestT;
   }


   @Override
   public boolean onCreateOptionsMenu(Menu menu){
	  // Inflate the menu; this adds items to the action bar if it is present.
	  getMenuInflater().inflate(R.menu.menu_main, menu);
	  return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
	  // Handle action bar item clicks here. The action bar will
	  // automatically handle clicks on the Home/Up button, so long
	  // as you specify a parent activity in AndroidManifest.xml.
	  int id = item.getItemId();

	  //noinspection SimplifiableIfStatement
	  if(id == R.id.action_settings){
		 return true;
	  }

	  return super.onOptionsItemSelected(item);
   }
}

class SomeComparable implements Comparable {

   SomeComparable(int inI){ i = inI; }

   int i = 0;

   @Override
   public int compareTo(Object another){
	  int anotherI = (((SomeComparable)another).i);

	  if(anotherI > i){ return - 1; }
	  else if(anotherI < i){ return 1; }
	  else if(anotherI != i){
		 throw new InvalidParameterException(); // neither equal or comparable
	  }
	  return 0;   // equal
   }
}
