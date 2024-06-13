import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class ThejavaUtilRegexAPI {
    public static void main(String [] args)
    {
        /*Pattern
        As we’ve said, the regex patterns that we write as strings are, in actuality, little pro
        grams describing how to match text. At runtime, the Java regex package compiles
        these little programs into a form that it can execute against some target text. Several
        simple convenience methods accept strings directly to use as patterns. More generally,
        however, Java allows you to explicitly compile your pattern and encapsulate it in an
        instance of a Pattern object. This is the most efficient way to handle patterns that are
        used more than once, because it eliminates needlessly recompiling the string. To
        compile a pattern, we use the static method Pattern.compile():
        */

        Pattern urlPattern = Pattern.compile("\\w+://[\\w/]*");
        /*Once you have a Pattern, you can ask it to create a Matcher object, which associates
        the pattern with a target string:
        */
       // String myText = "lolpkjk 2153467,8888,hhahaha";
      // String myText = "string";
      Matcher matcher = urlPattern.matcher(null);
        /* The matcher executes the matches. We’ll talk about that next. But before we do, we’ll
        just mention one convenience method of Pattern. The static method Pat
        tern.matches() simply takes two strings—a regex and a target string—and deter
        mines if the target matches the regex. This is very convenient if you want to do a
        quick test once in your application. For example:
        */
        Boolean match = Pattern.matches("\\d+\\.\\d+f?", null);


        /*Much like writing algorithms to solve programming problems, designing a regular
        expression requires you to break down your pattern matching problem into bite
        sized pieces. If we think about email addresses, there are a few patterns that stand out
        right away. The most obvious is the @ in the middle of every address. A naive (but
        better than nothing!) pattern relying on that fact could be built like this:
        */
        String sample = "my.name@some.domain:";
        Boolean vaildEmail = Pattern.matches(".*@.*", sample);
        System.out.println(vaildEmail);

        /*Components of the Regular Expression
        .*:
        
        The . (dot) matches any single character except for newline characters.
        The * (asterisk) is a quantifier that matches zero or more occurrences of the preceding element (in this case, any character).
        @:
        
        This matches the literal @ character, which is commonly found in email addresses.
        .*:
        
        Again, this matches any sequence of characters (zero or more times).
        Full Regex: .*@.*
        Putting it all together, .*@.* can be interpreted as:
        
        Any sequence of characters, followed by
        An @ character, followed by
        Any sequence of characters. 
        */

        /* But that pattern is too permissive. It will certainly recognize valid email addresses, but
        it will also recognize many invalid ones like "bad.address@" or "@also.bad" or even
        "@@". (Test these out in a jshell and maybe cook up a few more bad examples of your
        own!) How can we make better matches? One quick adjustment would be to use the +
        modifier instead of the *. The upgraded pattern now requires at least one character
        on each side of the @. But we know a few other things about email addresses. For
        example, the left “half” of the address (the name portion) cannot contain the @ char
        acter. For that matter, neither can the domain portion. We can use a custom character
        class for this next upgrade:
        */
        sample = "my.name@some.domain";
        Boolean validEmail = Pattern.matches("[^@]+@[^@]+", sample);

        /*Components of the Regular Expression
        [^@]+:
        
        ^ inside brackets [] is a negation symbol, meaning "not".
        [^@] matches any character except the @ character.
        + is a quantifier that matches one or more of the preceding element.
        Thus, [^@]+ matches one or more characters that are not the @ symbol.
        @:
        
        This matches the literal @ character, which is required in email addresses.
        [^@]+:
        
        This matches one or more characters that are not the @ symbol, after the @.
        Full Regex: [^@]+@[^@]+
        Putting it together, [^@]+@[^@]+ can be interpreted as:
        
        One or more characters that are not @, followed by
        An @ character, followed by
        One or more characters that are not @.
        */

        /*That pattern fixes our issue with an address like "still@bad", but we’ve gone a bit
        too far the other way. There are many, many TLDs—too many to reasonably list even
        if we ignore the problem of maintaining that list as new TLDs are added.5 So let’s step
        back a little. We’ll keep the “dot” in the domain portion, but remove the specific TLD
        and just accept a simple run of letters:
        */

        String sample3 = "my.name@some.domain";
        Boolean validEmail1 = Pattern.matches("[^@]+@[^@]+\\.[a-z]+", sample3);

        /* Much better. We can add one last tweak to make sure we don’t worry about the case
        of the address since all email addresses are case-insensitive. Just tack on a flag:
        */
        String sample4 = "my.name@some.domain";
        Boolean validEmail2 = Pattern.matches("(?i)[^@]+@[^@]+\\.[a-z]+", sample4);

        System.out.println(validEmail+","+validEmail1+","+validEmail2+","+match+","+matcher);
        /* Again, this is by no means a perfect email validator, but it is definitely a good start
        and will suffice for our simple login system once we add networking. If you want to
        tinker around with the validation pattern and expand or improve it, remember you
        can “reuse” lines in jshell with the keyboard arrow keys. Use the up arrow to retrieve
        the previous line. Indeed, you can use the up arrow and down arrow to navigate all of
        your recent lines. Within a line, use the left arrow and right arrow to move around
        and delete/add/edit your command. Then just press the Return key to run the newly
        altered command—you do not need to move the cursor to the end of the line before
        pressing Return
        
        */

        /*
         * Scanner sc = new Scanner(System.in);
         * String tr = sc.next();
         * // boolean tm = Pattern.matches("\\\\", tr);
         * // boolean tm = Pattern.matches("\\d*", tr);
         * // boolean tm = Pattern.matches("\\*|\\*+|\\**", tr);
         * // String ta = " "; \t,\n
         * //boolean tm = Pattern.matches("\\s", ta);
         * // boolean tm = Pattern.matches("\\w+", tr);
         * // boolean tm = Pattern.matches("..bat", tr); //. -> kbat, .. -> kkbat
         * 
         * boolean tm = Pattern.matches("jh", tr);
         * System.out.println(tm);
         * sc.close();
         */

    }
}
