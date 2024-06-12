import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    }
}
