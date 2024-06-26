package NetworkingAndIO;

import java.io.DataInputStream;
import java.io.IOException;

public class DataStreams {

    /*Data streams
    DataInputStream and DataOutputStream are filter streams that let you read or write
    strings and primitive data types composed of more than a single byte. DataInput
    Stream and DataOutputStream implement the DataInput and DataOutput interfaces,
    respectively. These interfaces define methods for reading or writing strings and all of
    the Java primitive types, including numbers and Boolean values. DataOutputStream
    encodes these values in a machine-independent manner and then writes them to its
    underlying byte stream. DataInputStream does the converse.
    You can construct a DataInputStream from an InputStream and then use a method
    such as readDouble() to read a primitive data type:
    */
    public DataStreams()
    {
        try {
            DataInputStream dis = new DataInputStream(System.in);
            double d = dis.readDouble();
            System.out.println(d);
        } catch (IOException ae) {
        }
    }
    /*This example wraps the standard input stream in a DataInputStream and uses it to
    read a double value. The readDouble() method reads bytes from the stream and con‐
    structs a double from them. The DataInputStream methods expect the bytes of
    numeric data types to be in network byte order, a standard that specifies that the highorder bytes are sent first (also known as “big endian,” as we discuss later).
    The DataOutputStream class provides write methods that correspond to the read
    methods in DataInputStream. For example, writeInt() writes an integer in binary
    format to the underlying output stream.
    The readUTF() and writeUTF() methods of DataInputStream and DataOutput
    Stream read and write a Java String of Unicode characters using the UTF-8 “trans‐
    formation format” character encoding. UTF-8 is an ASCII-compatible encoding of
    Unicode characters that is very widely used. Not all encodings are guaranteed to pre‐
    serve all Unicode characters, but UTF-8 does. You can also use UTF-8 with Reader
    and Writer streams by specifying it as the encoding name.
    
    */

    public static void main(String arg[])
    {
        DataStreams e = new DataStreams();
    }
}
