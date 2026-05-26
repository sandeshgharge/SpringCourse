package com.example.codingChallenges;

import java.util.ArrayList;
import java.util.List;

class Employee{
     String name;
     int salary;

     Employee(String name, int sal){
         this.name = name;
         this.salary = sal;
     }

}
public class CodingChallenge {

    public static void main(String[] args){

        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("Sandesh", 23000));
        employees.add(new Employee("Sandy", 26000));
        employees.add(new Employee("Yogesh", 28000));
        employees.add(new Employee("Himanshu", 30000));
        employees.add(new Employee("Vinit", 28000));

        int max = 0, max2 = 0;

        for(Employee e : employees){
            if(e.salary > max){
                max2 = max;
                max = e.salary;
            }
        }

        for(Employee e : employees){
            if(e.salary == max2){
                System.out.println("Employee name: " + e.name);
            }
        }
    }

}

