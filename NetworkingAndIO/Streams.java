package NetworkingAndIO;


/* Streams
 Most fundamental I/O in Java is based on streams. A stream represents a flow of data
 with (at least conceptually) a writer at one end and a reader at the other. When you
 are working with the java.io package to perform terminal input and output, reading
 or writing files, or communicating through sockets in Java, you are using various 
 types of streams. Later in this chapter, we’ll look at the NIO package, which introdu
ces a similar concept called a channel. One difference betwen the two is that streams
 are oriented around bytes or characters, while channels are oriented around “buffers”
 containing those data types—yet they perform roughly the same job. Let’s start by
 summarizing the available types of streams:
 
  InputStream, OutputStream
 Abstract classes that define the basic functionality for reading or writing an
 unstructured sequence of bytes. All other byte streams in Java are built on top of
 the basic InputStream and OutputStream.


 Reader, Writer
 Abstract classes that define the basic functionality for reading or writing a
 sequence of character data, with support for Unicode. All other character streams
 in Java are built on top of Reader and Writer.


 InputStreamReader, OutputStreamWriter
 Classes that bridge byte and character streams by converting according to a spe
cific character-encoding scheme. (Remember: in Unicode, a character is not nec
essarily one byte!)


 DataInputStream, DataOutputStream
 Specialized stream filters that add the ability to read and write multibyte data
 types, such as numeric primitives and String objects in a universal format.


 ObjectInputStream, ObjectOutputStream
 Specialized stream filters that are capable of writing whole groups of serialized
 Java objects and reconstructing them.


 BufferedInputStream, BufferedOutputStream, BufferedReader, BufferedWriter
 Specialized stream filters that add buffering for additional efficiency. For real
world I/O, a buffer is almost always used.


 PrintStream, PrintWriter
 Specialized streams that simplify printing text.


 PipedInputStream, PipedOutputStream, PipedReader, PipedWriter
 “Loopback” streams that can be used in pairs to move data within an application.
 Data written into a PipedOutputStream or PipedWriter is read from its corre
sponding PipedInputStream or PipedReader.


 FileInputStream, FileOutputStream, FileReader, FileWriter
 Implementations of InputStream, OutputStream, Reader, and Writer that read
 from and write to files on the local filesystem.

 */


 /*Streams in Java are one-way streets. The java.io input and output classes represent
 the ends of a simple stream, as shown in Figure 11-1. For bidirectional conversations,
 you’ll use one of each type of stream. 
 
  InputStream and OutputStream are abstract classes that define the lowest-level inter
 face for all byte streams. They contain methods for reading or writing an unstruc
 tured flow of byte-level data. Because these classes are abstract, you can’t create a
 generic input or output stream. Java implements subclasses of these for activities such
 as reading from and writing to files and communicating with sockets. Because all byte
 streams inherit the structure of InputStream or OutputStream, the various kinds of
 byte streams can be used interchangeably. A method specifying an InputStream as an
 argument can accept any subclass of InputStream. Specialized types of streams can
 also be layered or wrapped around basic streams to add features such as buffering,
 filtering, or handling higher-level data types.
 Reader and Writer are very much like InputStream and OutputStream, except that
 they deal with characters instead of bytes. As true character streams, these classes cor
 rectly handle Unicode characters, which is not always the case with byte streams.
 Often, a bridge is needed between these character streams and the byte streams of
 physical devices, such as disks and networks. InputStreamReader and OutputStream
 Writer are special classes that use a character-encoding scheme to translate between
 character and byte streams.
 
 
 This section describes all the interesting stream types with the exception of FileIn
 putStream, FileOutputStream, FileReader, and FileWriter. We postpone the dis
 cussion of file streams until the next section, where we cover issues involved with
 accessing the filesystem in Java.*/

 import java.io.*;
 public class Streams {
    
    
    /* Basic I/O
    The prototypical example of an InputStream object is the standard input of a Java
    application. Like stdin in C or cin in C++, this is the source of input to a
    command-line (non-GUI) program. It is an input stream from the environment—
    usually a terminal window or possibly the output of another command. The 
    java.lang.System class, a general repository for system-related resources, provides a
    reference to the standard input stream in the static variable System.in. It also pro
    vides a standard output stream and a standard error stream in the out and err vari
    ables, respectively.2 The following example shows the correspondence:*/

    InputStream stdin = System.in;
    OutputStream stdout = System.out;
    OutputStream stderr = System.err;

    /* This snippet hides the fact that System.out and System.err aren’t just OutputStream
    objects, but more specialized and useful PrintStream objects. 
    but for now we can reference out and
    err as OutputStream objects because they are derived from OutputStream.
    */

    /* We can read a single byte at a time from standard input with the InputStream’s
    read() method. If you look closely at the API, you’ll see that the read() method of
    the base InputStream class is an abstract method. What lies behind System.in is a
    particular implementation of InputStream that provides the real implementation of
    the read() method
    */

    Streams()
    {
        try {
            int val = System.in.read();
            System.out.println(val);//g  103
        } catch (IOException e) {
        }

        /* Although we said that the read() method reads a byte value, the return type in the
        example is int, not byte. That’s because the read() method of basic input streams in
        Java uses a convention carried over from the C language to indicate the end of a
        stream with a special value. Data byte values are returned as unsigned integers in the
        range 0 to 255, and the special value of -1 is used to indicate that the end of the
        stream has been reached. You’ll need to test for this condition when using the simple
        read() method. You can then cast the value to a byte if needed. The following exam
        ple reads each byte from an input stream and prints its value:
        */
        try{
            int val; 
            while((val=System.in.read())!= -1)
            System.out.println((byte)val);

        }catch(IOException e)
        {
        }

    }

    public void meth() {
        try{
        byte[] buff = new byte[1024];
        int got = System.in.read(buff);
        System.out.println(got);
        }
        catch(IOException e){}

    }

    public static void main(String [] args)
    {
        Streams obj = new Streams();
        obj.meth();
    }


}
