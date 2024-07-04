package FileOperations;

/*Buffers
Most of the utilities of the java.io and java.net packages operate on byte arrays.
The corresponding tools of the NIO package are built around ByteBuffers (with
character-based buffer CharBuffer for text). Byte arrays are simple, so why are buf‐
fers necessary? They serve several purposes:
• They formalize the usage patterns for buffered data, provide for things like
read-only buffers, and keep track of read/write positions and limits within a
large buffer space. They also provide a mark/reset facility like that of java.io
.BufferedInputStream.
• They provide additional APIs for working with raw data representing primitive
types. You can create buffers that “view” your byte data as a series of larger primi‐
tives, such as shorts, ints, or floats. The most general type of data buffer, Byte
Buffer, includes methods that let you read and write all primitive types just like
DataOutputStream does for streams.
• They abstract the underlying storage of the data, allowing for special optimiza‐
tions by Java. Specifically, buffers may be allocated as direct buffers that use
native buffers of the host operating system instead of arrays in Java’s memory.
The NIO Channel facilities that work with buffers can recognize direct buffers
automatically and try to optimize I/O to use them. For example, a read from a file
channel into a Java byte array normally requires Java to copy the data for the read
from the host operating system into Java’s memory. With a direct buffer, the data
can remain in the host operating system, outside Java’s normal memory space
until and unless it is needed.
Buffer operations
A buffer is a subclass of a java.nio.Buffer object. The base Buffer class is some‐
thing like an array with state. It does not specify what type of elements it holds (that is
for subtypes to decide), but it does define functionality that is common to all data
buffers. A Buffer has a fixed size called its capacity. Although all the standard
Buffers provide “random access” to their contents, a Buffer generally expects to be
read and written sequentially, so Buffers maintain the notion of a position where the
next element is read or written. In addition to position, a Buffer can maintain two
other pieces of state information: a limit, which is a position that is a “soft” limit to
the extent of a read or write, and a mark, which can be used to remember an earlier
position for future recall.
Implementations of Buffer add specific, typed get and put methods that read and
write the buffer contents. For example, ByteBuffer is a buffer of bytes and it has
get() and put() methods that read and write bytes and arrays of bytes (along with
 many other useful methods we’ll discuss later). Getting from and putting to the
Buffer changes the position marker, so the Buffer keeps track of its contents some‐
what like a stream. Attempting to read or write past the limit marker generates a Buf
ferUnderflowException or BufferOverflowException, respectively.
The mark, position, limit, and capacity values always obey the following formula:

 mark <= position <= limit <= capacity

 
The position for reading and writing the Buffer is always between the mark, which
serves as a lower bound, and the limit, which serves as an upper bound. The capacity
represents the physical extent of the buffer space.*/
public class BufferOperation {
    
}
