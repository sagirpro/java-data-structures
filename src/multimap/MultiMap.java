package multimap;

import java.util.Collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MultiMap {
    public static void main(String... args) {
  Multimap<String, String> myMultimap = ArrayListMultimap.create();
   
  // Adding some key/value
  myMultimap.put("Phone Os", "Windows Phone");
  myMultimap.put("Phone Os", "Android");
  myMultimap.put("Phone Os", "Ios 8");
  myMultimap.put("Desktop Os", "Ubuntu");
   
  // Getting the size
  int size = myMultimap.size();
  System.out.println("Size of the MultiMap : " + size);  // 4
   
  // Getting values
  Collection<String> pos = myMultimap.get("Phone Os");
  System.out.println("Phone OSs: " + pos); 
   
  Collection<String> dos = myMultimap.get("Desktop Os");
  System.out.println("Desktop OSs" + dos); 
   
  // Iterating over entire Mutlimap
  System.out.println("All multiMap values : ");
  for(String value : myMultimap.values()) {
   System.out.println(value);
  }
   
  // Removing a single value
  myMultimap.remove("Phone Os","Ios 8");
  System.out.println("After Removing Ios 8 : " + myMultimap.get("Phone Os")); 
   
  // Remove all values for a key
  myMultimap.removeAll("phone Os");
  System.out.println("After Removing All Phone OSs : " + myMultimap.get("Phone Os")); // [] (Empty Collection!)
 }
}
