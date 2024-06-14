//import java.util.regex.*;
//import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matcher1 {
    public static void main (String [] args)
    {
        /* The Matcher
        A Matcher associates a pattern with a string and provides tools for testing, finding,
        and iterating over matches of the pattern against it. The Matcher is “stateful.” For
        example, the find() method tries to find the next match each time it is called. But
        you can clear the Matcher and start over by calling its reset() method.
        If you’re just interested in “one big match”—that is, you’re expecting your string to
        either match the pattern or not—you can use matches() or lookingAt(). These cor
        respond roughly to the methods equals() and startsWith() of the String class. The
        matches() method asks if the string matches the pattern in its entirety (with no string
        characters left over) and returns true or false. The lookingAt() method does the
        same, except that it asks only whether the string starts with the pattern and doesn’t
        care if the pattern uses up all the string’s characters.
        More generally, you’ll want to be able to search through the string and find one or
        more matches. To do this, you can use the find() method. Each call to find()
        returns true or false for the next match of the pattern and internally notes the posi
        tion of the matching text. You can get the starting and ending character positions
        with the Matcher start() and end() methods, or you can simply retrieve the
        matched text with the group() method. For example:
        
        */


        String text = "A horse is a horse of course of course...";
        String pattern = "horse|course";
        // Matcher matcher = Pattern.complie(pattern).matcher(text);
        Pattern compiledPattern = Pattern.compile(pattern);
        System.out.println(compiledPattern);
        Matcher matcher = compiledPattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Matched:" + matcher.group() + " at the position" + matcher.start());
        }

        String test = "loop king darama is a loop drama king hahaha";
        String pattern2 = "loop|king|drama";

        Pattern compliedPattern2 = Pattern.compile(pattern2);
        matcher = compliedPattern2.matcher(test);
        while (matcher.find()) {
            System.out.println("Matched:" + matcher.group() + " at the position" + matcher.start());
        }
        for (int i=1; i < matcher.groupCount(); i++)
            System.out.println(matcher.group(i));
            
            /* Splitting and tokenizing strings
            A very common need is to parse a string into a bunch of fields based on some delim
            iter, such as a comma. It’s such a common problem that the String class contains a
            method for doing just this. The split() method accepts a regular expression and
            returns an array of substrings broken around that pattern. Consider the following
            string and split() calls:
            */
            String text2 = "Foo, bar ,   blah";
            String[] badfields = text2.split(",");
            String[] goodfields = text2.split("\\s*,\\s*");
            int lo = goodfields.length;
            int lo2 = badfields.length;
            int n = 0;
            System.out.println(lo);
            System.out.println(lo2);
            while(n < lo)
                System.out.println(goodfields[n++]);
             n = 0;
            while (n < lo2)
                System.out.println(badfields[n++]);

        /* The first split() returns a String array, but the naive use of “,” to separate the string
        means the space in our text variable remains stuck to the more interesting charac
        ters. We get Foo as a single word as expected, but then we get bar<space> and finally
        <space><space><space>blah. Yikes! The second split() also yields a String array,
        but this time containing the expected Foo, bar (with no trailing space), and blah
        (with no leading spaces).
        */
        /*If you are going to use an operation like this more than a few times in your code, you
        should probably compile the pattern and use its split() method, which is identical
        to the version in String. The String split() method is equivalent to:
        */

        //Pattern com = Pattern.compile("\\s*,\\s*");
        String field[] = Pattern.compile("\\s*,\\s*").split(text2);
        n = 0;
        while (n<3)
        System.out.println(field[n++]);



    }
}
