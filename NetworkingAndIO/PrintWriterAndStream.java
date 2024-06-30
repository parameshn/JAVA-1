package NetworkingAndIO;

import java.io.InputStream;
import java.io.PrintWriter;

/*Another useful wrapper stream is java.io.PrintWriter. This class provides a suite
of overloaded print() methods that turn their arguments into strings and push them
out the stream. A complementary set of println() convenience methods appends a
new line to the end of the strings. For formatted text output, printf() and the identi‐
cal format() methods allow you to write printf-style formatted text to the stream.
PrintWriter is an unusual character stream because it can wrap either an Output
Stream or another Writer. PrintWriter is the more capable big brother of the legacy
PrintStream byte stream. The System.out and System.err streams are PrintStream
objects; you have already seen such streams strewn throughout this book: */

public class PrintWriterAndStream {

    PrintWriterAndStream()
    {
        System.out.print("Hello, world...\n");
        System.out.println("Hello, world...");
        System.out.printf("The answer is %d", 17);
        System.out.println(3.14);

         /*Early versions of Java did not have the Reader and Writer classes and used Print
         Stream, which converted bytes to characters by simply making assumptions about the
         character encoding. You should use a PrintWriter for all new development.
         When you create a PrintWriter object, you can pass an additional Boolean value to
         the constructor, specifying whether it should “auto-flush.” If this value is true, the
         PrintWriter automatically performs a flush() on the underlying OutputStream or
         Writer each time it sends a newline:
         */
    

        PrintWriter pw = new PrintWriter( InputStream, true /*autoFlush*/ );
        pw.println("Hello!"); // Stream is automatically flushed by the newline.
 
        /*When this technique is used with a buffered output stream, it corresponds to the
        behavior of terminals that send data line by line.
        The other big advantage that PrintStream and PrintWriter have over regular char‐
        acter streams is that they shield you from exceptions thrown by the underlying
        
        streams. Unlike methods in other stream classes, the methods of PrintWriter and
        PrintStream do not throw IOExceptions. Instead, they provide a method to explic‐
        itly check for errors if required. This makes life a lot easier for printing text, which is
        a very common operation. You can check for errors with the checkError() method:
        
        */

        System.out.println( reallyLongString );
        if (System.out.checkError()) {
        }


    }
   
}
