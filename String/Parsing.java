import java.util.Scanner;

public class Parsing {

    public static void main(String[] args)
    {
        
        /* parsing—reading primitive numbers and values as strings, and chop
        ping long strings into tokens. Then we’ll take a look at regular expressions, the most
        powerful text-parsing tool Java offers. Regular expressions let you define your own
        patterns of arbitrary complexity, search for them, and parse them from text. */
 

        /* Parsing Primitive Numbers
        In Java, numbers, characters, and booleans are primitive types—not objects. But for
        each primitive type, Java also defines a primitive wrapper class. Specifically, the
        java.lang package includes the following classes: Byte, Short, Integer, Long, Float,
        Double, Character, and Boolean. We talked about these in “Wrappers for Primitive
        Types” on page 141, but we bring them up now because these classes hold static utility
        methods that know how to parse their respective types from strings. Each of these
        primitive wrapper classes has a static “parse” method that reads a String and returns
        the corresponding primitive type. For example: */

 

        byte b = Byte.parseByte("5");
        System.out.println(b);
        int n = Integer.parseInt("5648");
        System.out.println(n);
        long l = Long.parseLong("622222222222222");
        System.out.println(l);
        float f = Float.parseFloat("4.2");
        System.out.println(f);
        double d = Double.parseDouble("99.99999999");
        System.out.println(d);
        boolean e = Boolean.parseBoolean("true");
        System.out.println(e);

        Scanner sc = new Scanner(System.in);
        /* Alternatively, the java.util.Scanner provides a single API for not only parsing indi
        vidual primitive types from strings, but reading them from a stream of tokens. This
        example shows how to use it in place of the preceding wrapper classes: */
        // byte b1 = new Scanner("16").nextByte();
        // System.out.println(b1);
        // int n2 = new Scanner("42").nextInt();
        // long l2 = new Scanner("99999999999").nextLong();
        // float f2 = new Scanner("4.2").nextFloat();
        // double d2 = new Scanner("99.99999999").nextDouble();
        // boolean b2 = new Scanner("true").nextBoolean();
        sc.close();
    }
    
}
