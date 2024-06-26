package NetworkingAndIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;

public class CharStream {
    // Character Streams

    /*The java.io Reader and Writer character stream classes were introduced as streams
    that handle character data only. When you use these classes, you think only in terms
    of characters and string data, and allow the underlying implementation to handle the
    conversion of bytes to a specific character encoding. As we’ll see, some direct imple‐
    mentations of Reader and Writer exist, for example, for reading and writing files. But 
    more generally, two special classes, InputStreamReader and OutputStreamWriter,
    bridge the gap between the world of character streams and the world of byte streams.
    These are, respectively, a Reader and a Writer that can be wrapped around any
    underlying byte stream to make it a character stream. An encoding scheme is used to
    convert between possible multibyte encoded values and Java Unicode characters. An
    encoding scheme can be specified by name in the constructor of InputStreamReader
    or OutputStreamWriter. For convenience, the default constructor uses the system’s
    default encoding scheme
    */

    /*For example, let’s parse a human-readable string from the standard input into an inte‐
    ger. We’ll assume that the bytes coming from System.in use the system’s default
    encoding scheme:
    */
    CharStream() {

        try {
            InputStream in = System.in;
            InputStreamReader charsIn = new InputStreamReader(in);
            BufferedReader bufferedCharsIn = new BufferedReader(charsIn);

            String line = bufferedCharsIn.readLine();
            int i = NumberFormat.getInstance().parse(line).intValue();
            System.out.println(i);

            /*NumberFormat.getInstance():
            
            This method returns a general-purpose NumberFormat object for the default locale. NumberFormat is a class in the java.text package used for formatting and parsing numbers.
            The getInstance() method returns a NumberFormat that can parse numbers in a locale-sensitive manner. This means it can handle number formats specific to the default locale (e.g., it can parse "1,234.56" in a locale where commas are used as thousands separators and periods as decimal points).
            .parse(line):
            
            The parse(String source) method of NumberFormat attempts to parse the string line as a number.
            This method returns a Number object, which is the superclass of various numeric types like Integer, Double, etc.
            The string line must represent a number in a format that the NumberFormat can recognize. For example, "123", "456.78", or "1,234.56" depending on the locale.
            .intValue():
            
            The intValue() method is called on the Number object returned by parse().
            This method converts the Number to an int by returning its integer value.
            If the Number is not an integer (e.g., it's a Double), it will be truncated to an integer (e.g., 123.45 becomes 123).
            */

            /*First, we wrap an InputStreamReader around System.in. This reader converts the
            incoming bytes of System.in to characters using the default encoding scheme. Then, 
            we wrap a BufferedReader around the InputStreamReader. BufferedReader adds
            the readLine() method, which we can use to grab a full line of text (up to a
            platform-specific, line-terminator character combination) into a String. The string is
            then parsed into an integer using the techniques described in Chapter 8.
            The important thing to note is that we have taken a byte-oriented input stream, Sys
            tem.in, and safely converted it to a Reader for reading characters. If we wished to use
            an encoding other than the system default, we could have specified it in the Input
            StreamReader’s constructor, like so:
            */
            InputStreamReader reader = new InputStreamReader(System.in, "UTF-8");

            /*For each character that is read from the reader, the InputStreamReader reads one or
            more bytes and performs the necessary conversion to Unicode.
            We return to the topic of character encodings when we discuss the java.nio.char
            set API, which allows you to query for and use encoders and decoders explicitly on
            buffers of characters and bytes. Both InputStreamReader and OutputStreamWriter
            can accept a Charset codec object as well as a character-encoding name.
            */
        } catch (IOException ae) {
        } catch (ParseException pe) {
        }

    }
    
    public static void main(String [] args)
    {
        CharStream obj = new CharStream();
    } 
}
