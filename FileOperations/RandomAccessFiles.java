package FileOperations;

import java.io.*;

public class RandomAccessFiles {
    /*RandomAccessFile
    The java.io.RandomAccessFile class provides the ability to read and write data at a
    specified location in a file. RandomAccessFile implements both the DataInput and
    DataOutput interfaces, so you can use it to read and write strings and primitive types
    at locations in the file just as if it were a DataInputStream and DataOutputStream.
    However, because the class provides random, rather than sequential, access to file
    data, it’s not a subclass of either InputStream or OutputStream.
    You can create a RandomAccessFile from a String pathname or a File object. The
    constructor also takes a second String argument that specifies the mode of the file.
    Use the string  
    r for a read-only file
    rw for a read/write file
    */
    public static void main(String [] args)
    {

        try {
            File users = new File("lol.java");
            RandomAccessFile users2 = new RandomAccessFile(users, "rw");

            long usersNum = 1, RECORDSIZE = 100;
            users2.seek(usersNum * RECORDSIZE);

            String userName = "baba dev";
            users2.writeUTF(userName);

            int userID = 565454;
            users2.writeInt(userID);

            users2.close();

        } catch (IOException ae) {
            
        }
    }/*When you create a RandomAccessFile in read-only mode, Java tries to open the
     specified file. If the file doesn’t exist, RandomAccessFile throws an IOException. If,
     however, you’re creating a RandomAccessFile in read/write mode, the object creates
     the file if it doesn’t exist. The constructor can still throw an IOException if another
     I/O error occurs, so you still need to handle this exception.
     After you have created a RandomAccessFile, call any of the normal reading and writ‐
     ing methods, just as you would with a DataInputStream or DataOutputStream. If you
     try to write to a read-only file, the write method throws an IOException.
     
     
     What makes a RandomAccessFile special is the seek() method. This method takes a
     long value and uses it to set the byte offset location for reading and writing in the file.
     You can use the getFilePointer() method to get the current location. If you need to
     append data to the end of the file, use length() to determine that location, then
     seek() to it. You can write or seek beyond the end of a file, but you can’t read beyond
     the end of a file. The read() method throws an EOFException if you try to do this.
     Here’s an example of writing data for a simplistic database:
     
     
     */
}
