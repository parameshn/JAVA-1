// Regular Expressions

/*Now it’s time to take a brief detour on our trip through Java and enter the land of
 regular expressions. A regular expression, or regex for short, describes a text pattern.
 Regular expressions are used with many tools—including the java.util.regex pack
age, text editors, and many scripting languages—to provide sophisticated text
searching and powerful string-manipulation capabilities. */


/* Regex Notation
 A regular expression describes a pattern in text. By pattern, we mean just about any
 feature you can imagine identifying in text from the literal characters alone, without
 actually understanding their meaning. This includes features, such as words, word
 groupings, lines and paragraphs, punctuation, case, and more generally, strings and
 numbers with a specific structure to them, such as phone numbers, email addresses, 
and quoted phrases. With regular expressions, you can search the dictionary for all
 the words that have the letter “q” without its pal “u” next to it, or words that start and
 end with the same letter. Once you have constructed a pattern, you can use simple
 tools to hunt for it in text or to determine if a given string matches it. A regex can also
 be arranged to help you dismember specific parts of the text it matched, which you
 could then use as elements of replacement text if you wish.*/

/* Write once, run away
 Before moving on, we should say a few words about regular expression syntax in gen
eral. At the beginning of this section, we casually mentioned that we would be discus
sing a new language. Regular expressions do, in fact, constitute a simple form of
 programming language. If you think for a moment about the examples we cited ear
lier, you can see that something like a language is going to be needed to describe even
 simple patterns—such as email addresses—that have some variation in form.
 A computer science textbook would classify regular expressions at the bottom of the
 hierarchy of computer languages, in terms of both what they can describe and what
 you can do with them. They are still capable of being quite sophisticated, however. As
 with most programming languages, the elements of regular expressions are simple,
 but they can be built up in combination to arbitrary complexity. And that is where
 things start to get sticky.
 Since regexes work on strings, it is convenient to have a very compact notation that
 can be easily wedged between characters. But compact notation can be very cryptic,
 and experience shows that it is much easier to write a complex statement than to read
 it again later. Such is the curse of the regular expression. You may find that in a
 moment of late-night, caffeine-fueled inspiration, you can write a single glorious pat
tern to simplify the rest of your program down to one line. When you return to read
 that line the next day, however, it may look like Egyptian hieroglyphics to you. Sim
pler is generally better, but if you can break your problem down and do it more
 clearly in several steps, maybe you should. */





 /* Escaped characters
 Now that you’re properly warned, we have to throw one more thing at you before we
 build you back up. Not only can the regex notation get a little hairy, but it is also
 somewhat ambiguous with ordinary Java strings. An important part of the notation is
 the escaped character—a character with a backslash in front of it. For example, the
 escaped d character, \d, (backslash “d”) is shorthand that matches any single digit
 character (0–9). However, you cannot simply write \d as part of a Java string, because
 you might recall that Java uses the backslash for its own special characters and to
 specify Unicode character sequences(\uxxxx). Fortunately, Java gives us a replace
ment: an escaped backslash, which is two backslashes (\\), means a literal backslash 
The rule is, when you want a backslash to appear in your regex, you must escape it
 with an extra one:
 "\\d" // Java string that yields backslash "d"
 And just to make things crazier, because regex notation itself uses a backslash to
 denote special characters, it must provide the same “escape hatch” as well—allowing
 you to double up backslashes if you want a literal backslash. So if you want to specify
 a regular expression that includes a single literal backslash, it looks like this:
 "\\\\"  // Java string yields two backslashes; regex yields one
 Most of the “magic” operator characters you read about in this section operate on the
 character that precedes them, so these also must be escaped if you want their literal
 meaning. This includes such characters as ., *, +, braces {}, and parentheses ().
 If you need to create part of an expression that has lots of literal characters in it, you
 can use the special delimiters \Q and \E to help you. Any text appearing between \Q
 and \E is automatically escaped. (You still need the Java String escapes—double
 backslashes for backslash, but not quadruple.) There is also a static method called
 Pattern.quote(), which does the same thing, returning a properly escaped version
 of whatever string you give it.
 Beyond that, our only suggestion to help maintain your sanity when working with
 these examples is to keep two copies—a comment line showing the naked regular
 expression, and the real Java string, where you must double up all backslashes. And
 don’t forget about jshell! It can be a very powerful playground for testing and tweak
ing your patterns.
 Characters and character classes
 Now, let’s dive into the actual regex syntax. The simplest form of a regular expression
 is plain, literal text, which has no special meaning and is matched directly (character
 for character) in the input. This can be a single character or more. For example, in the
 following string, the pattern “s” can match the character s in the words rose and is:
 "A rose is $1.99."
 The pattern “rose” can match only the literal word rose. But this isn’t very interesting.
 Let’s crank things up a notch by introducing some special characters and the notion
 of character “classes.”
 Any character: dot (.)
 The special character dot (.) matches any single character. The pattern “.ose”
 matches rose, nose, _ose (space followed by ose), or any other character followed
 by the sequence ose. Two dots match any two characters (prose, close, etc.), and
 so on. The dot operator is not discriminating; it normally stops only for an end
of-line character (and, optionally, you can tell it not to; we discuss that later).
*/

/*We can consider “.” to represent the group or class of all characters. And regexes
 define more interesting character classes as well.
 Whitespace or nonwhitespace character: \s, \S
 The special character \s matches a literal-space character or one of the following
 characters: \t (tab), \r (carriage return), \n (newline), \f (formfeed), and back
space. The corresponding special character \S does the inverse, matching any
 character except whitespace.
 Digit or nondigit character: \d, \D
 \d matches any of the digits 0-9. \D does the inverse, matching all characters
 except digits.
 Word or nonword character: \w, \W
 \w matches a “word” character, including upper- and lowercase letters A-Z, a-z,
 the digits 0-9, and the underscore character (_). \W matches everything except
 those characters.
 Custom character classes
 You can define your own character classes using the notation […]. For example, the
 following class matches any of the characters a, b, c, x, y, or z:
 [abcxyz]
 The special x-y range notation can be used as shorthand for the alphanumeric char
acters. The following example defines a character class containing all upper- and low
ercase letters:
 [A-Za-z]
 Placing a caret (^) as the first character inside the brackets inverts the character class.
 This example matches any character except uppercase A-F:
 [^A-F]    
//  G, H, I, ..., a, b, c, ... etc.
 Nesting character classes simply adds them:
 [A-F[G-Z]\w]   // A-Z plus whitespace
 The && logical AND notation can be used to take the intersection (characters in
 common):
 [a-p&&[l-z]]  // l, m, n, o, p
 [A-Z&&[^P]]  // A through Z except P
 Position markers
 The pattern “[Aa] rose” (including an upper- or lowercase A) matches three times in
 the following phrase: 
 "A rose is a rose is a rose"
 Position characters allow you to designate the relative location of a match. The most
 important are ^ and $, which match the beginning and end of a line, respectively:
 ^[Aa] rose  // matches "A rose" at the beginning of line
 [Aa] rose$  // matches "a rose" at end of line
 To be a little more precise, ^ and $ match the beginning and end of “input,” which is
 often a single line. If you are working with multiple lines of text and wish to match
 the beginnings and endings of lines within a single large string, you can turn on
 “multiline” mode with a flag, as described later in “Special options” on page 237.
 The position markers \b and \B match a word boundary or nonword boundary,
 respectively. For example, the following pattern matches rose and rosemary, but not
 primrose:
 \brose
 Iteration (multiplicity)
 Simply matching fixed character patterns would not get us very far. Next, we look at
 operators that count the number of occurrences of a character (or more generally, of a
 pattern, as we’ll see in “Pattern” on page 239):
 Any (zero or more iterations): asterisk (*)
 Placing an asterisk (*) after a character or character class means “allow any num
ber of that type of character”—in other words, zero or more. For example, the
 following pattern matches a digit with any number of leading zeros (possibly
 none):
 0*\d   // match a digit with any number of leading zeros
 Some (one or more iterations): plus sign (+)
 The plus sign (+) means “one or more” iterations and is equivalent to XX* (pat
tern followed by pattern asterisk). For example, the following pattern matches a
 number with one or more digits, plus optional leading zeros:
 0*\d+   // match a number (one or more digits) with optional leading
 // zeros
 It may seem redundant to match the zeros at the beginning of an expression
 because zero is a digit and is thus matched by the \d+ portion of the expression
 anyway. However, we’ll show later how you can pick apart the string using a regex
 and get at just the pieces you want. In this case, you might want to strip off the
 leading zeros and keep only the digits.
 Optional (zero or one iteration): question mark (?)
 The question mark operator (?) allows exactly zero or one iteration. For example,
 the following pattern matches a credit card expiration date, which may or may
 not have a slash in the middle:
 \d\d/?\d\d  // match four digits with an optional slash in the middle
 Range (between x and y iterations, inclusive): {x,y}
 The {x,y} curly-brace range operator is the most general iteration operator. It
 specifies a precise range to match. A range takes two arguments: a lower bound
 and an upper bound, separated by a comma. This regex matches any word with
 five to seven characters, inclusive:
 \b\w{5,7}\b  // match words with at least 5 and at most 7 characters
 At least x or more iterations (y is infinite): {x,}
 If you omit the upper bound, simply leaving a dangling comma in the range, the
 upper bound becomes infinite. This is a way to specify a minimum of occur
rences with no maximum.*/

/* Alternation
 The vertical bar (|) operator denotes the logical OR operation, also called alternation
 or choice. The | operator does not operate on individual characters but instead
 applies to everything on either side of it. It splits the expression in two unless con
strained by parentheses grouping. For example, a slightly naive approach to parsing
 dates might be the following:
 \w+, \w+ \d+ \d+|\d\d/\d\d/\d\d  // pattern 1 or pattern 2
 In this expression, the left matches patterns such as Fri, Oct 12, 2001, and the right
 matches 10/12/2001.
 The following regex might be used to match email addresses with one of three
 domains (net, edu, and gov):
 \w+@[\w.]*\.(net|edu|gov)  // email address ending in .net, .edu, or .gov
 Special options
 There are several special options that affect the way the regex engine performs its
 matching. These options can be applied in two ways:
 • You can pass in one or more flags during the Pattern.compile() step (discussed
 in the next section).
 • You can include a special block of code in your regex.
 We’ll show the latter approach here. To do this, include one or more flags in a special
 block (?x), where x is the flag for the option we want to turn on. Generally, you do
 this at the beginning of the regex. You can also turn off flags by adding a minus sign
 (?-x), which allows you to apply flags to select parts of your pattern.
 The following flags are available:
 Case-insensitive: (?i)
 The (?i) flag tells the regex engine to ignore case while matching. For example:
 (?i)yahoo   // match Yahoo, yahoo, yahOO, etc.
 Dot all: (?s)
 The (?s) flag turns on “dot all” mode, allowing the dot character to match any
thing, including end-of-line characters. It is useful if you are matching patterns
 that span multiple lines. The s stands for “single-line mode,” a somewhat confus
ing name derived from Perl.
 Multiline: (?m)
 By default, ^ and $ don’t really match the beginning and end of lines (as defined
 by carriage return or newline combinations); they instead match the beginning
 or end of the entire input text. In many cases, “one line” is synonymous with the
 entire input. If you have a big block of text to process, you’ll often break that
 block up into separate lines for other reasons, and then checking any given line
 for a regular expression is straightforward and ^ and $ behave as expected. How
ever, if you want to use a regex with the entire input string containing multiple
 lines (separated by those carriage return or newline combinations), you can turn
 on multiline mode with (?m). This flag causes ^ and $ to match the beginning
 and end of the individual lines within the block of text as well as the beginning
 and end of the entire block. Specifically, this means the spot before the first char
acter, the spot after the last character, and the spots just before and after line ter
minators inside the string.
 Unix lines: (?d)
 The (?d) flag limits the definition of the line terminator for the ^, $, and . special
 characters to Unix-style newline only (\n). By default, carriage return newline
 (\r\n) is also allowed. */


public class RegularExpression {
    
}
