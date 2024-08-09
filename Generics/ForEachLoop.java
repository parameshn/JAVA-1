package Generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForEachLoop {

    
    public static void foreach(String[] args) {
        int[] a = { 1, 2, 3, 6 };
        sumArray(a);

        List<Integer> ints = Arrays.asList(1, 2, 3);
        int s = 0;
        for (int n : ints) {
            s += n;
        }
        assert s == 6;

        /*
         * The loop in the third line is called a foreach loop even though it is written
         * with the
         * keyword for. It is equivalent to the following:
         */

        for (Iterator<Integer> it = ints.iterator(); it.hasNext();) {
            int n = it.next();// unboxing
            s += n;
        }

        /*
         * The foreach loop can be applied to any object that implements the interface
         * Iterable<E> (in package java.lang),
         * which in turn refers to the interface Iterator<E> (in package java.util)
         * These define the methods iterator, hasNext, and next, which are used by the
         * translation of the foreach loop (iterators
         * also have a method remove, which is not used by the translation)
         * 
         */
        // interface Iterable<E> {
        // public Iterator<E> iterator();
        // }

        // interface Iterator<E> {
        // public boolean hasNext();

        // public E next();

        // public void remove();
        // }

    }
    // The foreach loop may also be applied to an array:
    public static int sumArray(int[] a) {
        int s = 0;
        for (int n : a) {
            s += n;
        }
        return s;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*The foreach loop was deliberately kept simple and catches only the most common case.
    You need to explicitly introduce an iterator if you wish to use the remove method or to
    iterate over more than one list in parallel.
    */
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*The foreach loop was deliberately kept simple and catches only the most common case.
    You need to explicitly introduce an iterator if you wish to use the remove method or to
    iterate over more than one list in parallel
    */
    public static void removeNegative(List<Double> v) {
        for (Iterator<Double> it = v.iterator(); it.hasNext();) {
            if (it.next() < 0)
                it.remove();
        }
    }

    /*Here is a method to compute the dot product of two vectors, represented as lists of
doubles, both of the same length. Given two vectors, u1, … , un and v1, … , vn, it computes u1*v1> + … + un*vn
: */

    public static double dot(List<Double> u, List<Double> v) {
        if (u.size() != v.size())
            throw new IllegalArgumentException("different sizes");
        double d = 0;
        Iterator<Double> uIt = u.iterator();
        Iterator<Double> vIt = v.iterator();
        while (uIt.hasNext()) {
            assert uIt.hasNext() && vIt.hasNext();
            d += uIt.next() * vIt.next();
        }
        assert !uIt.hasNext() && !vIt.hasNext();
        return d;
    }

   

   
    
    

}
