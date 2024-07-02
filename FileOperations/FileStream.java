package FileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class FileStream {
    /*
     * File Streams
     * OK, you’re probably sick of hearing about files already and we haven’t even
     * written a
     * byte yet! Well, now the fun begins. Java provides two fundamental streams for
     * read‐
     * ing from and writing to files: FileInputStream and FileOutputStream. These
     * streams provide the basic byte-oriented InputStream and OutputStream
     * functionality
     * that is applied to reading and writing files. They can be combined with the
     * filter
     * streams described earlier to work with files in the same way as other stream
     * communications.
     */

    // You can create a FileInputStream from a String pathname or a File object:
    FileStream() {
        try (FileInputStream in = new FileInputStream("lol.java")) {
            // fin will be closed automatically if needed upon exiting the try clause.
        } catch (IOException a) {
        }

        /*
         * When the stream is first created, its available() method and the File
         * object’s
         * length() method should return the same value.
         */
    }

    public static void main(String args[]) {
        File file = new File("lol.java");

        if (!file.exists() || !file.canRead()) {
            System.out.println("cant read" + file);
            return;
        }

        if (file.isDirectory()) {
            String[] files = file.list();
            for (String fileName : files)
                System.out.println(fileName);
        } else
            try {
                Reader ir = new InputStreamReader(new FileInputStream(file));

                BufferedReader in = new BufferedReader(ir);
                String line;
                while ((line = in.readLine()) != null)
                    System.out.println(file);
                ir.close();

                /*
                 * ListIt constructs a File object from its first command-line argument and
                 * tests the
                 * File to see whether it exists and is readable. If the File is a directory,
                 * ListIt outputs
                 * the names of the files in the directory. Otherwise, ListIt reads and outputs
                 * the file,
                 * line by line.
                 * For writing files, you can create a FileOutputStream from a String pathname
                 * or a
                 * File object. Unlike FileInputStream, however, the FileOutputStream
                 * constructors
                 * don’t throw a FileNotFoundException. If the specified file doesn’t exist, the
                 * FileOut
                 * putStream creates the file. The FileOutputStream constructors can throw an
                 * IOEx
                 * ception if some other I/O error occurs, so you still need to handle this
                 * exception.
                 */

                /*
                 * f the specified file does exist, the FileOutputStream opens it for writing.
                 * When you
                 * subsequently call the write() method, the new data overwrites the current
                 * contents
                 * of the file. If you need to append data to an existing file, you can use a
                 * form of the
                 * constructor that accepts a Boolean append flag:
                 */
                File fooFile = new File("lol.java");
                FileOutputStream fooOut = new FileOutputStream(fooFile);// overwrite
                FileOutputStream fooOu2 = new FileOutputStream(fooFile, true);// append

                OutputStreamWriter kll = new OutputStreamWriter(fooOut);
                OutputStreamWriter kll2 = new OutputStreamWriter(fooOu2);
                Fileoperation oop = new Fileoperation();
                String[] fileList = oop.haha();
                for (String lists : fileList)
                    kll.write("\n"+lists);
                kll.close();
                
                String ram = "kkkkkk lolo hahahah";
                kll2.write(ram);
                kll2.close();

                

            } catch (FileNotFoundException e) {
                System.out.println("File disappeared");
            } catch (IOException ae) {

            }

    }

}
