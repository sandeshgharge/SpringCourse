package concepts.collections.Set;

import java.util.HashSet;
import java.util.Set;

public class HashSetConcepts {

	public static void main(String[] args) {
		
		/***
		 * 
		 */
		
		System.out.println("Hash Set Implementations : ");
		System.out.println();
		
		HashSet<String> cars = new HashSet<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("BMW");
	    cars.add("Mazda");
	    System.out.println(cars);
	    
	    System.out.println();
	    System.out.println(cars.contains("Mazda"));
	    
	    System.out.println();
	    System.out.println(cars.remove("Mazda"));
	    
	    System.out.println();
	    printHashSetForEach(cars);

	}
	
	static void printHashSetForEach(Set<String> m) {
		for (String i : m) {
			  System.out.println(i);
			}
	}

}
