package FileOperations;

import java.io.FileInputStream;
import java.io.IOException;

public class FileStream {
    /*File Streams
    OK, you’re probably sick of hearing about files already and we haven’t even written a
    byte yet! Well, now the fun begins. Java provides two fundamental streams for read‐
    ing from and writing to files: FileInputStream and FileOutputStream. These
    streams provide the basic byte-oriented InputStream and OutputStream functionality
    that is applied to reading and writing files. They can be combined with the filter
    streams described earlier to work with files in the same way as other stream
    communications.
    */

    // You can create a FileInputStream from a String pathname or a File object:
    FileStream() {
        try (FileInputStream in = new FileInputStream("lol.java")) {
            // fin will be closed automatically if needed upon exiting the try clause.
        } catch (IOException a) {
        }
      
        /*When the stream is first created, its available() method and the File object’s
        length() method should return the same value.
        */
    }

}
