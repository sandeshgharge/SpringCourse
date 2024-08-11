package concepts.collections.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListConcepts {

	public static void main(String[] args) {
		
		/**
		 * The LinkedList class is a collection just like the ArrayList.
		 * It also stores same type of Object
		 * It can also be used to store multiple type of objects by defining the type "Object"
		 * 
		 * The ArrayList class has a regular array inside it.
		 * The LinkedList stores its items in "containers."
		 * The list has a link to the first container.
		 * And each container has a link to the next container in the list.
		 * To add an element to the list, the element is placed into a new container
		 * and that container is linked to one of the other containers in the list.
		 * 
		 * Use an ArrayList for storing and accessing data, and LinkedList to manipulate data.
		 * 
		 * LinkedList provides several methods to do certain operations more efficiently :
		 * addFirst()	Adds an item to the beginning of the list.
		 * 
		 * addFirst()	Adds an item to the beginning of the list.	
		 * addLast()	Add an item to the end of the list	
		 * removeFirst()	Remove an item from the beginning of the list.	
		 * removeLast()	Remove an item from the end of the list	
		 * getFirst()	Get the item at the beginning of the list	
		 * getLast()	Get the item at the end of the list
		 */
		System.out.println("LinkedList implementation :");
		System.out.println();
		
		/**
		 * ArrayList Initialization with type of object to be stored
		 * Few predefined operations are used to modify the list
		 * Many operations exists apart from below specified ones
		 */
		LinkedList<String> cars = new LinkedList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    
	    
	    System.out.println(cars);
	    
	    System.out.println();
	    System.out.println("Size of LinkedList : ");
	    System.out.println(cars.size());
	    
	    System.out.println();
	    System.out.println("Print Last Element");
	    System.out.println(cars.getLast());
	    
	    System.out.println();
	    System.out.println("Add before first Element : ");
	    cars.addFirst("Opel");
	    printUsingForEach(cars);
	    
	    System.out.println();
	    System.out.println("Removing first element");
	    cars.removeFirst();
	    printUsingFor(cars);
	    
	    
	    cars.clear();
	    System.out.println();
	    
	    
	    
	    List<Integer> myNumbers = new LinkedList<Integer>();
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
//	 * @param l - Arraylist/LinkedList object to be iterated
	 */
	public static void printUsingFor(List l) {
		for (int i = 0; i < l.size(); i++) {
		      System.out.println(l.get(i));
		    }
	}
	
	/**
	 * Iteration using foreach loop
	 * @param l - Arraylist/LinkedList object to be iterated
	 */
	public static void printUsingForEach(List l) {
		for (Object i : l) {
		      System.out.println(i);
		    }
	}

}
