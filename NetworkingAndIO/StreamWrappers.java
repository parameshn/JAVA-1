package NetworkingAndIO;
import java.io.*;
public class StreamWrappers {
    /*Stream Wrappers
    What if we want to do more than read and write a sequence of bytes or characters?
    We can use a “filter” stream, which is a type of InputStream, OutputStream, Reader,
    or Writer that wraps another stream and adds new features. A filter stream takes the
    target stream as an argument in its constructor and delegates calls to it after doing
    some additional processing of its own. For example, we can construct a BufferedIn
    putStream to wrap the system standard input:
    */
    InputStream bufferedIn = new BufferedInputStream(System.in);
    /* 
    The BufferedInputStream is a type of filter stream that reads ahead and buffers a
    certain amount of data. The BufferedInputStream wraps an additional layer of func‐
    tionality around the underlying stream. Figure 11-2 shows this arrangement for a
    DataInputStream, which is a type of stream that can read higher-level data types,
    such as Java primitives and strings.
    As you can see from the previous code snippet, the BufferedInputStream filter is a
    type of InputStream. Because filter streams are themselves subclasses of the basic
    stream types, they can be used as arguments to the construction of other filter
    streams. This allows filter streams to be layered on top of one another to provide dif‐
    ferent combinations of features. For example, we could first wrap our System.in with
    a BufferedInputStream and then wrap the BufferedInputStream with a DataInput
    Stream for reading special data types with buffering.
    Java provides base classes for creating new types of filter streams: FilterInput
    Stream, FilterOutputStream, FilterReader, and FilterWriter. These superclasses
    provide the basic machinery for a “no op” filter (a filter that doesn’t do anything) by
    delegating all their method calls to their underlying stream. Real filter streams sub‐
    class these and override various methods to add their additional processing. We’ll
    make an example filter stream later in this chapter.
    
    */
}
