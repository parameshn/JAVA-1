package NetworkingAndIO;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.text.ParseException;

public class BufferedStreams {
  /*Buffered streams
  The BufferedInputStream, BufferedOutputStream, BufferedReader, and Buffered
  Writer classes add a data buffer of a specified size to the stream path. A buffer can
  increase efficiency by reducing the number of physical read or write operations that
  correspond to read() or write() method calls. You create a buffered stream with an
  appropriate input or output stream and a buffer size. (You can also wrap another
  stream around a buffered stream so that it benefits from the buffering.) Here’s a sim‐
  ple buffered input stream called bis:
  
  */
  InputStream myInputStream = System.in;
  BufferedInputStream bis = new BufferedInputStream(myInputStream, 32768);
  //  int a = bis.read();
  /*In this example, we specify a buffer size of 32 KB. If we leave off the size of the buffer
  in the constructor, a reasonably sized one is chosen for us. (Currently the default is 8
  KB.) On our first call to read(), bis tries to fill our entire 32 KB buffer with data, if
  it’s available. Thereafter, calls to read() retrieve data from the buffer, which is refilled
  as necessary
   */
  /*A BufferedOutputStream works in a similar way. Calls to write() store the data in a
  buffer; data is actually written only when the buffer fills up. You can also use the
  flush() method to wring out the contents of a BufferedOutputStream at any time.
  The flush() method is actually a method of the OutputStream class itself. It’s impor‐
  tant because it allows you to be sure that all data in any underlying streams and filter
  streams has been sent (before, for example, you wait for a response).
  Some input streams such as BufferedInputStream support the ability to mark a loca‐
  tion in the data and later reset the stream to that position. The mark() method sets
  the return point in the stream. It takes an integer value that specifies the number of
  bytes that can be read before the stream gives up and forgets about the mark. The
  reset() method returns the stream to the marked point; any data read after the call
  to mark() is read again.
  This functionality could be useful when you are reading the stream in a parser. You
  may occasionally fail to parse a structure and so must try something else. In this sit‐
  uation, you can have your parser generate an error and then reset the stream to the
  point before it began parsing the structure:
   */
  int MAX_DATA_STRUCTURE_SIZE = 10;
  void BufferedStreams()
  {
    BufferedInputStream input;

    try {
      input.mark(MAX_DATA_STRUCTURE_SIZE);
      return (parseDataStructure(input));

    } catch (ParseException e) {
      input.reset();
    }
  }

/*
 * The BufferedReader and BufferedWriter classes work just like their byte-based
 * counterparts, except that they operate on characters instead of bytes.
 */}

 

