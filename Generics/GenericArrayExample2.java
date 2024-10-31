package Generics;

import java.util.ArrayList;
import java.util.List;

/*For class-level parameters, the inferred type is determined by how the object is declared.
For method-level parameters, the inferred type is determined by the arguments provided to that method. */

public class GenericArrayExample2<E> {
    private List<E> list;

    // Constructor
    public GenericArrayExample2() {
        list = new ArrayList<>(); // E is inferred from class type parameter
    }

    public void addElement(E element) {
        list.add(element); // Uses the class-level type parameter E
    }

    @SuppressWarnings("unchecked")
    // Generic method with its own type parameter
    public static <T> List<T> createList(T... elements) {
        List<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element); // Uses the method-level type parameter T
        }
        return list;
    }

    public static void main(String[] args) {
        // Class-level type inference
        GenericArrayExample2<String> stringList = new GenericArrayExample2<>(); // E is inferred as String
        stringList.addElement("Hello");
        stringList.addElement("World");

        // Method-level type inference
        List<Integer> integerList = createList(1, 2, 3); // T is inferred as Integer
        List<Double> doubleList = createList(1.1, 2.2, 3.3); // T is inferred as Double

        System.out.println(stringList.getList()); // Output: [Hello, World]
        System.out.println(integerList); // Output: [1, 2, 3]
        System.out.println(doubleList); // Output: [1.1, 2.2, 3.3]
    }

    public List<E> getList() {
        return list;
    }
}
