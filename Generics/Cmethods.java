package Generics;

import java.util.*;

public class Cmethods {

    public static final String[] EMPTY_STRINGS = new String[0];
    public static void main(String[] args) {
        Collection<String> cs = new ArrayList<>();
        cs.add("hello");
        cs.add("java");

        //String[] beak = cs.toArray(new String[0]);
        String[] beak = cs.toArray(EMPTY_STRINGS);

        //System.out.println(cs+"\n"+beak);
        //[hello, java]
        //[Ljava.lang.String;@372f7a8d

         System.out.println(cs);
        System.out.println(Arrays.toString(beak)); 

    }
}
