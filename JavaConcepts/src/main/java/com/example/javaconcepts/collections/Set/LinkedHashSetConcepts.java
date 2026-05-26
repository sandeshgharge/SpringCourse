package concepts.collections.Set;

import concepts.collections.demoEntity.Student;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetConcepts {

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
         * LinkedHashset extends HashSet
         * Here the chronology of data is maintained
         * Check Same example with HashSet
         */

        System.out.println("Linked Hash Set Implementations : ");
        System.out.println();

        HashSet<String> cars = new LinkedHashSet<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars);

        System.out.println();
        System.out.println("If LinkedHashSet contains Mazda: " + cars.contains("Mazda"));

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

        HashSet<Student> stuCollection = new LinkedHashSet<Student>();
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
