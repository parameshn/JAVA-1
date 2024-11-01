package Generics;


//https://chatgpt.com/c/6723db4e-507c-800b-b57a-94438634034f
import java.util.*;

public class GenericArrayExample<E> {
    private E[] array;
    private int size; // Keep track of the current number of elements in the array

    @SuppressWarnings("unchecked")
    public GenericArrayExample(int size) {
        array = (E[]) new Object[size]; // Create an array of Object and cast it to E[]
        this.size = 0; // Initialize size to 0
    }

    public void set(int index, E element) {
        if (index >= 0 && index < array.length) {
            array[index] = element; // Store the element
            size = Math.max(size, index + 1); // Update size if necessary
        } else {
            System.out.println("Index out of bounds");
        }
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            return array[index]; // Retrieve the element
        } else {
            System.out.println("Index out of bounds");
            return null; // Return null if index is out of bounds
        }
    }

    // // Varargs method to add multiple elements
    // public void addElements(E... elements) {
    // for (E element : elements) {
    // // Check if there's space in the array
    // if (size < array.length) {
    // array[size++] = element; // Add element and increment size
    // } else {
    // System.out.println("Array is full, cannot add more elements.");
    // break; // Stop adding if the array is full
    // }
    // }
    // Using a List instead of varargs
    public void addElements(List<E> elements) {
        for (E element : elements) {
            if (size < array.length) {
                array[size++] = element; // Add element and increment size
            } else {
                System.out.println("Array is full, cannot add more elements.");
                break; // Stop adding if the array is full
            }
        }
    }

  

    public static void main(String[] args) {
        GenericArrayExample<String> stringArray = new GenericArrayExample<>(10);
        stringArray.set(0, "Hello");
        System.out.println(stringArray.get(0)); // Output: Hello

        // Add multiple elements using varargs
        // stringArray.addElements("World", "Java", "Generics");
        stringArray.addElements(Arrays.asList("World", "Java", "Generics"));

        // Display added elements
        for (int i = 0; i < 3; i++) {
            System.out.println(stringArray.get(i)); // Output: World, Java, Generics
        }

        // Uncommenting the following line would cause a compile-time error
        // stringArray.set(1, 42); // Error: incompatible types: int cannot be converted
        // to String
    }
}
