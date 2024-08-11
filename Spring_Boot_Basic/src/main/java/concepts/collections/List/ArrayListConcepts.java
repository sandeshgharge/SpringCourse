package concepts.collections.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListConcepts {
	
	public static void main(String [] args) {
		
		/**
		 * ArrayList is similar to Array but with variable size
		 * It also stores same type of Object
		 * It can also be used to store multiple type of objects by defining the type "Object"
		 * 
		 * The ArrayList class has a regular array inside it.
		 * When an element is added, it is placed into the array.
		 * If the array is not big enough,
		 * a new, larger array is created to replace the old one and the old one is removed.
		 */
		System.out.println("Array List implementation :");
		System.out.println();
		
		/**
		 * ArrayList Initialization with type of object to be stored
		 * Few predefined operations are used to modify the list
		 * Many operations exists apart from below specified ones
		 */
		ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    
	    
	    System.out.println(cars);
	    
	    System.out.println();
	    System.out.println("Size of ArrayList : ");
	    System.out.println(cars.size());
	    
	    System.out.println();
	    System.out.println("Print First Element");
	    System.out.println(cars.get(0));
	    
	    System.out.println();
	    System.out.println("Edting first Element : ");
	    cars.set(0, "Opel");
	    printUsingForEach(cars);
	    
	    System.out.println();
	    System.out.println("Removing first element");
	    cars.remove(0);
	    printUsingFor(cars);
	    
	    
	    cars.clear();
	    System.out.println();
	    
	    
	    
	    List<Integer> myNumbers = new ArrayList<Integer>();
	    myNumbers.add(33);
	    myNumbers.add(15);
	    myNumbers.add(20);
	    myNumbers.add(34);
	    myNumbers.add(8);
	    myNumbers.add(12);
	    System.out.println();
	    printUsingFor(myNumbers);

	    Collections.sort(myNumbers);
	    
	    System.out.println();
	    System.out.println("After Sorting");
	    printUsingForEach(myNumbers);
	    
	}
	
	/**
	 * Iteration using for loop
	 * @param l - Arraylist object to be iterated
	 */
	public static void printUsingFor(List l) {
		for (int i = 0; i < l.size(); i++) {
		      System.out.println(l.get(i));
		    }
	}
	
	/**
	 * Iteration using foreach loop
	 * @param l - Arraylist object to be iterated
	 */
	public static void printUsingForEach(List l) {
		for (Object i : l) {
		      System.out.println(i);
		    }
	}

}
