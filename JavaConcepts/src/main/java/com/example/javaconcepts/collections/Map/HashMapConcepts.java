package concepts.collections.Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapConcepts {

	public static void main(String[] args) {
		
		System.out.println("HashMap Implementaions : ");
		System.out.println();
		/*
		 * ArrayList is accessed with index number
		 * 
		 * HashMap store items in "key/value" pairs
		 * You can access them by an index of another type e.g. Integer, String
		 */
		
		HashMap<String, String> capitalCities = new HashMap<String, String>();

	    // Add keys and values (Country, City)
	    capitalCities.put("England", "London");
	    capitalCities.put("Germany", "Berlin");
	    capitalCities.put("Norway", "Oslo");
	    capitalCities.put("USA", "Washington DC");
	    System.out.println(capitalCities);
	    
	    System.out.println();
	    System.out.println(capitalCities.get("England"));
	    
	    System.out.println();
	    System.out.println(capitalCities.size());
	    
	    capitalCities.remove("England");
	    
	    System.out.println();
	    System.out.println("Print all keys : ");
	    printKeys(capitalCities);
	    
	    System.out.println();
	    System.out.println("Print all values : ");
	    printValues(capitalCities);
	    
	    System.out.println();
	    capitalCities.clear();
	    System.out.println(capitalCities);
	    
	    System.out.println();
	    Map<Integer, String> people = new HashMap<Integer, String>();

	    // Add keys and values (Id, Name)
	    people.put(32, "John");
	    people.put(30, "Steve");
	    people.put(33, "Angie");
	    
	    printKeyAndValue(people);

	}
	
	// Print both keys
	static void printKeys(Map m){
		for (Object i : m.keySet()) {
		      System.out.println("key: " + i);
		    }
	}
	
	// Print Values
	static void printValues(Map m){
		for (Object i : m.values()) {
		      System.out.println("key: " + i);
		    }
	}
	
	// Print both key and Value
	static void printKeyAndValue(Map<Integer, String> m){
		for (Integer i : m.keySet()) {
		      System.out.println("key: " + i + " value: " + m.get(i));
		    }
	}

}
