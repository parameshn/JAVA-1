import java.util.Scanner;
import java.util.StringTokenizer;

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
        


///////////////////////////////////////////////////////////////////////////////////////////////////////////
        /* Tokenizing Text
        A common programming task involves parsing a string of text into words or “tokens”
        that are separated by some set of delimiter characters, such as spaces or commas. The
        first example contains words separated by single spaces. The second, more realistic
        problem involves comma-delimited fields.
        Now is the time for all good men (and women)...
        Check Number, Description,      
        4231,         
        Amount
        Java Programming, 1000.00
        Java has several (unfortunately overlapping) APIs for handling situations like this.
        The most powerful and useful are the String split() and Scanner APIs. Both uti
        lize regular expressions to allow you to break the string on arbitrary patterns. We
        haven’t talked about regular expressions yet, but in order to show you how this works
        we’ll just give you the necessary magic and explain in detail later in this chapter. We’ll
        also mention a legacy utility, java.util.StringTokenizer, which uses simple char
        acter sets to split a string. StringTokenizer is not as powerful, but doesn’t require an
        understanding of regular expressions.
        

        The String split() method accepts a regular expression that describes a delimiter
        and uses it to chop the string into an array of Strings: */

        String text = "546454 lol haha,     king,1000000";
        String[] words = text.split("\\s");
        String[] words2 = text.split("\\s*,\\s*");
        System.out.println(words[0] + words[1] + words[2] + "\n" + words2[0] + words2[1] + words2[2]);
        
        
        /*In the first example, we used the regular expression \\s, which matches a single
        whitespace character (space, tab, or carriage return). The split() method returned
        an array of eight strings. In the second example, we used a more complicated regular
        expression, \\s*,\\s*, which matches a comma surrounded by any number of con
        tiguous spaces (possibly zero). This reduced our text to three nice, tidy fields.
        With the new Scanner API, we could go a step further and parse the numbers of our
        second example as we extract them: */

        String rom = "kokik,24515,  java program ,1000.325";
        Scanner demo = new Scanner(rom).useDelimiter("\\s*,\\s*");
        int checknum = demo.nextInt();// .nextInt() reads the next token from the input as an integer
        String sentence = demo.next();
        float amount = demo.nextFloat();
        System.out.println(demo);
        System.out.println(checknum + sentence + amount);

        String text2 = "now is the time for all good";
        StringTokenizer st = new StringTokenizer(text2);
        System.out.println(st);
        String word = "pppp";
        while (st.hasMoreTokens()) {
            word = st.nextToken();
        
        }
        System.out.println(word);
        

 
    }
    
}
