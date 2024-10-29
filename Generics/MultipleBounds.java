package Generics;

import java.io.*;
import java.nio.*;
public class MultipleBounds {
    
    public static <S extends Readable & Closeable, T extends Appendable & Closeable>
            void copy(S src, T trg, int size) throws IOException {
        try {

            CharBuffer buf = CharBuffer.allocate(size);
            int i = src.read(buf);
            while (i >= 0) {
                buf.flip();// prepare buffer for writing
                trg.append(buf);
                buf.clear(); // prepare buffer for reading
                i = src.read(buf);
            }
        } finally {
            src.close();
            trg.close();
        }
    }
    
    /*
     * This method repeatedly reads from the source into a buffer and appends from
     * the buffer
     * into a target. When the source is empty, it closes both the source and the
     * target. (This
     * example deviates from best practice in that the files are closed in a
     * different block than
     * the one where they are opened.) The first line specifies that S ranges over
     * any type that
     * implements both Readable and Closeable, and that T ranges over any type that
     * imple
     * ments Appendable and Closeable. When multiple bounds on a type variable
     * appear,
     * they are separated by ampersands. You cannot use a comma, since that is
     * already used
     * to separate declarations of type variables.
     */
    public static void main(String [] args)
    {
        try{
        int size = 32;
        FileReader r = new FileReader("file.in");
        FileWriter w = new FileWriter("file.out");
        copy(r, w, size);
        BufferedReader br = new BufferedReader(new FileReader("file.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("file.out"));
        copy(br,bw,size);
    } catch (FileNotFoundException e) {
    }
        catch (IOException e) {
    }
    finally {
            System.out.println("Tick : bounds");
        }

    }
}
