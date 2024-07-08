package NetworkingAndIO;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.nio.*;
import java.nio.charset.*;
//import javax.swing.text.html.HTMLDocument.Iterator;

public class CharEncode {
    /*Character Encoders and Decoders
    Character encoders and decoders turn characters into raw bytes and vice versa, map‐
    ping from the Unicode standard to particular encoding schemes. Encoders and
    decoders have long existed in Java for use by Reader and Writer streams and in the
    methods of the String class that work with byte arrays. However, early on there was
    no API for working with encoding explicitly; you simply referred to encoders and
    decoders wherever necessary by name as a String. The java.nio.charset package
    formalized the idea of a Unicode character set encoding with the Charset class.
    The Charset class is a factory for Charset instances, which know how to encode
    character buffers to byte buffers and decode byte buffers to character buffers. You can
    look up a character set by name with the static Charset.forName() method and use it
    in conversions:*/
    ByteBuffer byteBuff;
    Charset charset = Charset.forName("US-ASCII");
    CharBuffer charBuff = charset.decode( byteBuff ); // to ascii
    ByteBuffer byteBuff2 = charset.encode(charBuff); // and back
     /* 
     You can also test to see if an encoding is available with the static Charset.isSuppor
     ted() method.
     The following character sets are guaranteed to be supplied:
     • US-ASCII
     • ISO-8859-1
     • UTF-8
     • UTF-16BE
     • UTF-16LE
     • UTF-16
     You can list all the encoders available on your platform using the static available
     Charsets() method:
     */
    
     public static void  main(String [] args)
     {
         Map map = Charset.availableCharsets();
         Iterator it = map.keySet().iterator();
         while (it.hasNext())
             System.out.println(it.next());

         /*The result of availableCharsets() is a map because character sets may have
         “aliases” and appear under more than one name.
         In addition to the buffer-oriented classes of the java.nio package, the InputStream
         Reader and OutputStreamWriter bridge classes of the java.io package have been
         updated to work with Charset as well. You can specify the encoding as a Charset
         object or by name.
         */
         /*CharsetEncoder and CharsetDecoder
         You can get more control over the encoding and decoding process by creating an
         instance of CharsetEncoder or CharsetDecoder (a codec) with the Charset newEn
         coder() and newDecoder() methods. In the previous snippet, we assumed that all the
         data was available in a single buffer. More often, however, we might have to process
         data as it arrives in chunks. The encoder/decoder API allows for this by providing
         more general encode() and decode() methods that take a flag specifying whether
         more data is expected. The codec needs to know this because it might have been left
         hanging in the middle of a multibyte character conversion when the data ran out. If it
         knows that more data is coming, it does not throw an error on this incomplete con‐
         version. In the following snippet, we use a decoder to read from a ByteBuffer bbuff
         and accumulate character data into a CharBuffer cbuff:     
         */
         int bufferSize = 1024;
         ByteBuffer bbuff = ByteBuffer.allocate(bufferSize);
         CharBuffer cbuff = CharBuffer.allocate(bufferSize);

         CharsetDecoder decoder = Charset.forName("US-ASCII").newDecoder();

         byte[] bufferArray = new byte[bufferSize];
         int bread;
         InputStream in = System.in;
         boolean done = false;
         while (!done) {
             bbuff.clear();
             /*
              * Importantly, clear() does not actually erase the data in the buffer. It
              * merely resets the markers (position and limit). The data remains in the
              * buffer, but it will be overwritten by subsequent write operations.
              */
             try {
                 bread = in.read(bufferArray);
                 if (bread == -1)// If bytesRead is -1, it indicates the end of the stream, and the loop will
                                 // exit.
                     done = true;

                 bbuff.put(bufferArray, 0, bread);
                 bbuff.flip();
                 decoder.decode(bbuff, cbuff, done);
             } catch (IOException ae) {
             }

         }
         cbuff.flip();
         // https://chatgpt.com/share/dc6984cd-2c22-4eb2-9d85-3ad8d8b14030
     }
    
     /*
      * The ByteBuffer's capacity is defined when it is allocated.
      * The buffer's size (capacity) determines how much data it can hold at any
      * given time.
      * The loop iterates based on the availability of data in the InputStream, not
      * based on the buffer's capacity.
      * Each iteration reads as much data as is available (up to the buffer's
      * capacity), writes it into the ByteBuffer, and processes it.
      */
}
