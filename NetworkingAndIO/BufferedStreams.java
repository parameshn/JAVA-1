package NetworkingAndIO;

import java.io.BufferedInputStream;
import java.io.InputStream;

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
}
