package concepts.collections.iteration;

import concepts.collections.demoEntity.Student;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IteratingMethods {

    /**
     * Iteration using for loop
     * @param l - Arraylist object to be iterated
     */
    public void printListUsingFor(List<String> l){

        for(int i=0; i< l.size(); i++){
            System.out.println(l.get(i));
        }

    }

    /**
     * Iteration using foreach loop
     * @param l - Arraylist object to be iterated
     */
    public void printListUsingForEach(List<String> l){

        for(Object obj : l){
            System.out.println(obj);
        }
    }

    public void printUsingIterator(List<Integer> l){
        Iterator<Integer> itr = l.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public void printUsingLambdaForEach(Set<Student> stuSet){
        stuSet.forEach(s -> {
            System.out.println("ID: " + s.getId() + " Name: " + s.getName());
        });
    }
}
