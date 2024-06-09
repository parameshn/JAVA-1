//Strings

/*A String
 object encapsulates a sequence of Unicode characters. Internally, these characters are
 stored in a regular Java array, but the String object guards this array jealously and
 gives you access to it only through its own API. This is to support the idea that
 Strings are immutable; once you create a String object, you can’t change its value.
 Lots of operations on a String object appear to change the characters or length of a
 string, but what they really do is return a new String object that copies or internally
 references the needed characters of the original. Java implementations make an effort
 to consolidate identical strings used in the same class into a shared-string pool and to
 share parts of Strings where possible */



import java.util.Arrays;
import java.util.Date;
//import java.nio.charset.StandardCharsets;



class demo {

    int de = 1251;
    int rope = 00000;
    /* Constructing Strings
 Literal strings, defined in your source code, are declared with double quotes and can
 be assigned to a String variable: */
    String a = "king to the lows";


    // Java automatically converts the literal string into a String object and assigns it to the
 //variable.
    public int method ()
    {
        
        int mul = 20 * 10;
        return mul;
    }
    
    private String  method2() {
        String c = "working on the erp";
        
        return c;
    }
}
public class Stringss {
    
    public static void main(String [] args)
    {
           String quote = "to be or not to be";


        /* Strings keep track of their own length, so String objects in Java don’t require special
        terminators. You can get the length of a String with the length() method. You can
        also test for a zero-length string by using isEmpty(): */
 

            int length = quote.length();
            System.out.println(length);
            boolean empty = quote.isEmpty();
            System.out.println(empty); 

            String another = "123542154";

        /* Strings can take advantage of the only overloaded operator in Java, the + operator,
        for string concatenation. The following code produces equivalent strings: */
 

            String tests = quote +" "+ another.concat("  ooookkkkkk");
            System.out.println(tests);

            String[] verbs = { "hhhhhaa", "jump", quote.toString() };
            System.out.println(verbs[0] + verbs[1] + verbs[2]);


        /* In addition to making strings from literal expressions, you can construct a String
        directly from an array of characters: */
       char[] data = new char[] { 'L', 'e', 'm', 'm', 'i', 'n', 'g' };
       String lemming = new String(data);
            System.out.println(verbs);
            System.out.println(Arrays.toString(verbs));
            System.out.println(Arrays.deepToString(verbs));



        // You can also construct a String from an array of bytes:
            byte[] data2 = new byte[] { (byte) 97, (byte) 98, (byte) 99 };
            String goo = new String(data2);
            System.out.println(goo);
          

            for ( int i = 0;i < verbs[1].length();i++)
            {
                System.out.println(verbs[1]);

            }
/*Conversely, the charAt() method of the String class lets you access the characters of
 a String in an array-like fashion: */

            for ( int i = 0;i < verbs[1].length();i++)
            {
                System.out.println(verbs[1].charAt(i));
            }



            /* Strings from Things
            Objects and primitive types in Java can be turned into a default textual representation
            as a String. For primitive types like numbers, the string should be fairly obvious; for
            object types, it is under the control of the object itself. We can get the string represen
            tation of an item with the static String.valueOf() method. Various overloaded ver
            sions of this method accept each of the primitive types: */
            String one1 = String.valueOf(1); // integer, "1"
            String two2 = String.valueOf(2.384f); // float, "2.384"
            String notTrue = String.valueOf(false); // boolean, "false"



        /* All objects in Java have a toString() method that is inherited from the Object class.
        For many objects, this method returns a useful result that displays the contents of the
        object. For example, a java.util.Date object’s toString() method returns the date it
        represents formatted as a string. For objects that do not provide a representation, the
        string result is just a unique identifier that can be used for debugging. The
        String.valueOf() method, when called for an object, invokes the object’s
        toString() method and returns the result. The only real difference in using this
 method is that if you pass it a null object reference, it returns the String “null” for
 you, instead of producing a NullPointerException: */
 

        Date date = new Date();
        System.out.println(date);
        String d1 = String.valueOf(date);
        String d2 = date.toString();
        System.out.println(d1);
        System.out.println(d2);
        int d3 = 3626;
        String d4 = String.valueOf(d3);
        System.out.println(d4);

    
        demo test = new demo();

        String d5 = String.valueOf(test);
        System.out.println(d5);

        d5 = String.valueOf(test.de);
        System.out.println(d5);
        d5 = String.valueOf(test.rope);
        System.out.println(d5);
        d5 = String.valueOf(test.a);
        System.out.println(d5);

        d5 = String.valueOf(test.method());
        System.out.println(d5);

    //     d5 = String.valueOf(test.method2());
    //     System.out.println(d5);    //private method


    /* Comparing Strings
 The standard equals() method can compare strings for equality; they contain exactly
 the same characters in the same order. You can use a different method, equalsIgnore
 Case(), to check the equivalence of strings in a case-insensitive way: */
    String one = "LOLO";
    String two = "lolo";

    System.out.println(one.equals(two));
    System.out.println(one.equalsIgnoreCase(two));


    /*A common mistake for novice programmers in Java is to compare strings with the ==
    operator when they intend to use the equals() method. Remember that strings are
    objects in Java, and == tests for object identity; that is, whether the two arguments
    being tested are the same object. In Java, it’s easy to make two strings that have the
    same characters but are not the same string object. For example: */

    String foo1 = String.valueOf("fooo2222");
    System.out.println(foo1);

    String foo2 = String.valueOf(new char[] { 'f', 'o', 'o' });
    System.out.println(foo2);

    //foo1 == foo2;//wrong
    foo1.equals(foo2);

    boolean value = foo1.equals(foo2);
    System.out.println(value);
    /* The compareTo() method compares the lexical value of the String to another
    String, determining whether it sorts alphabetically earlier than, the same as, or later
    than the target string. It returns an integer that is less than, equal to, or greater than
    zero: */
  String abc = "abc";
 String def = "def";
 String num = "123";
 if ( abc.compareTo( def ) < 0 )    ;     // true
if ( abc.compareTo( abc ) == 0 )     ;   // true
if (abc.compareTo(num) > 0)
    ;  // true


/*The compareTo() method compares strings strictly by their characters’ positions in
 the Unicode specification. This works for simple text but does not handle all language
 variations well. The Collator class, discussed next, can be used for more sophistica
ted comparisons. */

/* Searching
 The String class provides several simple methods for finding fixed substrings within
 a string. The startsWith() and endsWith() methods compare an argument string
 with the beginning and end of the String, respectively: */

  String url = "http://foo.bar.com/";
  if (url.startsWith("http:"));
       // true

 /* The indexOf() method searches for the first occurrence of a character or substring
 and returns the starting character position, or -1 if the substring is not found: */


 /* The indexOf() method searches for the first occurrence of a character or substring
 and returns the starting character position, or -1 if the substring is not found: */
String roc = "1243599465";
int i = roc.indexOf('p');//false
System.out.println(i);

i = roc.indexOf('2');
System.out.println(i);

i = roc.lastIndexOf('2');
System.out.println(i);
/*Similarly, lastIndexOf() searches backward through the string for the last occur
rence of a character or substring.


 The contains() method handles the very common task of checking to see whether a
 given substring is contained in the target string: */
String log = "There is an emergency in sector 7!";
if (log.contains("emergency"))
    System.out.print(log);


    }
}