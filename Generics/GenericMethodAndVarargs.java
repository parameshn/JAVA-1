package Generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class GenericMethodAndVarargs {
    public static <T> List<T> toList(T[] arr)
    {

        List<T> list = new ArrayList<T>();
        for (T elt : arr)
            list.add(elt);
        return list;

        /*The static method toList accepts an array of type T[] and returns a list of type
        List<T>, and does so for any type T. This is indicated by writing <T> at the beginning
        of the method signature, which declares T as a new type variable. A method which
        declares a type variable in this way is called a generic method. The scope of the type
        variable T is local to the method itself; it may appear in the method signature and the 
        method body, but not outside the method.
        */

    }
    
    public static <T> List<T> toList2(T... arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr)
            list.add(elt);
        return list;
    }

    public static <T> void addAll(List<T> list,T... arr)
    {
        for (T elt : arr)
            list.add(elt);
    }
    
    public static void main(String [] args)
    {
        // In the first line, boxing converts 1, 2, 3 from int to Integer
        List<Integer> ints = GenericMethodAndVarargs.toList(new Integer[] { 1, 2, 3 });//
        List<String> words = GenericMethodAndVarargs.toList(new String[] { "hello", "world" });


        //list2
        List<Integer> ints2 = GenericMethodAndVarargs.toList2(1, 2, 3);
        List<String> words2 = GenericMethodAndVarargs.toList2("hello", "world");
        /*This is just shorthand for what we wrote above. At run time, the arguments are packed
        into an array which is passed to the method, just as previously.
        */

        List<Integer> ints3 = new ArrayList<Integer>();
        GenericMethodAndVarargs.addAll(ints, 1, 2);
        GenericMethodAndVarargs.addAll(ints, new Integer[] { 3, 4 });
        assert ints.toString().equals("[1,2,3,4]");



    }
}
