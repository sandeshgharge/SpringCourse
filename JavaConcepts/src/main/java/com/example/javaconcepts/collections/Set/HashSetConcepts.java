package com.example.javaconcepts.collections.Set;

import com.example.javaconcepts.collections.demoEntity.Student;

import java.util.HashSet;
import java.util.Set;


public class HashSetConcepts {

	public static void main(String[] args) {

		/**
		 * HashSet is a thin wrapper over HashMap
		 * Elements stored as keys
		 * Value = constant dummy object
		 */


		basicOperations();

		edgeCases();


	}

	static void basicOperations(){
		/***
		 * Hashset do not stores duplicate elements
		 * add method returns a boolean value stating if the value is added
		 * Adding duplicate value adds
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
		System.out.println("If hashset contains Mazda: " + cars.contains("Mazda"));

		System.out.println();
		System.out.println("Add Mazda again as a duplicate entry: " + cars.add("Mazda"));

		System.out.println();
		System.out.println("Remove Mazda from the data: " + cars.remove("Mazda"));

		System.out.println();
		printHashSetForEach(cars);
	}

	static void edgeCases(){

		/**
		 * Edge cases with objects
		 * Add 2 objects
		 * Alter one object to make same as another using public methods
		 * It works as each object has different hash address
		 *
		 * To eliminate this bug, we need to override the equals method to
		 * ensure no duplicacy
		 */

		Student stu1 = new Student("1", "Sandy");
		Student stu2 = new Student("2", "Bunty");

		HashSet<Student> stuCollection = new HashSet<Student>();
		stuCollection.add(stu1);
		stuCollection.add(stu2);

		printHashsetObjects(stuCollection);

		stu2.setId("1");
		stu2.setName("Sandy");
		System.out.println("Adding same object: " + stuCollection.add(stu1));
		System.out.println(stuCollection.add(new Student("1", "Sandy")));

		printHashsetObjects(stuCollection);
	}
	
	static void printHashSetForEach(Set<String> m) {
		for (String i : m) {
			  System.out.println(i);
			}
	}

	static void printHashsetObjects(Set<Student> stuSet){
		stuSet.forEach(s -> {
			System.out.println("ID: " + s.getId() + " Name: " + s.getName());
		});
	}

}
