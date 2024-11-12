package Generics;

import java.util.*;

//https://chatgpt.com/c/6723db4e-507c-800b-b57a-94438634034f
public class Arraylist1 {

    public static<E> List<E> singleton(E elt) {
        return Arrays.asList(elt); // generic array creation
    }
    public static void main(String [] args)
    {

        List<Integer>  a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);
        List<List<Integer>> c = Arrays.asList(a, b); // generic array creation
        
        System.out.println(c);


        // Array Approach:
        
        // List<List<Integer>> z = Arrays.asList(new List<Integer>[] { a, b });
        List<List<Integer>> y = new ArrayList<>();
        y.add(a);
        y.add(b);
        System.out.println(y);


    }
}
