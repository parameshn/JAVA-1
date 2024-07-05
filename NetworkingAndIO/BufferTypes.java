package NetworkingAndIO;

public class BufferTypes {
    /*Buffer types
    As stated earlier, various buffer types add get and put methods for reading and writ‐
    ing specific data types. Each of the Java primitive types has an associated buffer type:
    ByteBuffer, CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer, and
    DoubleBuffer. Each provides get and put methods for reading and writing its type
    and arrays of its type. Of these, ByteBuffer is the most flexible. Because it has the
    “finest grain” of all the buffers, it has been given a full complement of get and put
    methods for reading and writing all the other data types as well as byte. Here are
    some ByteBuffer methods:
    byte get()
    char getChar()
    short getShort()
    int getInt()
    long getLong()
    float getFloat()
    double getDouble()
    void put(byte b)
    void put(ByteBuffer src)
    void put(byte[] src, int offset, int length)
    void put(byte[] src)
    void putChar(char value)
    void putShort(short value)
    void putInt(int value)
    void putLong(long value)
    void putFloat(float value)
    void putDouble(double value)
    As we said, all the standard buffers also support random access. For each of the afore‐
    mentioned methods of ByteBuffer, an additional form takes an index; for example:
    getLong( int index )
    putLong( int index, long value )
    But that’s not all. ByteBuffer can also provide “views” of itself as any of the coarsegrained types. For example, you can fetch a ShortBuffer view of a ByteBuffer with
    the asShortBuffer() method. The ShortBuffer view is backed by the ByteBuffer,
    which means that they work on the same data, and changes to either one affect the
    other. The view buffer’s extent starts at the ByteBuffer’s current position, and its
    capacity is a function of the remaining number of bytes, divided by the new type’s
    size. (For example, shorts consume two bytes each, floats four, and longs and dou
    bles take eight.) View buffers are convenient for reading and writing large blocks of a
    contiguous type within a ByteBuffer.
    CharBuffers are interesting as well, primarily because of their integration with
    Strings. Both CharBuffers and Strings implement the java.lang.CharSequence
    interface. This is the interface that provides the standard charAt() and length()
    methods. Because of this, newer APIs (such as the java.util.regex package) allow
    you to use a CharBuffer or a String interchangeably. In this case, the CharBuffer
    acts like a modifiable String with user-configurable, logical start and end positions.
    */


    /*Byte order
    Because we’re talking about reading and writing types larger than a byte, the question
    arises: in what order do the bytes of multibyte values (e.g., shorts and ints) get writ‐
    ten? There are two camps in this world: “big endian” and “little endian.”3
    Big endian
    means that the most significant bytes come first; little endian is the reverse. If you’re
    writing binary data for consumption by some native application, this is important.
    Intel-compatible computers use little endian, and many workstations that run Unix
    use big endian. The ByteOrder class encapsulates the choice. You can specify the byte
    order to use with the ByteBuffer order() method, using the identifiers ByteOr
    der.BIG_ENDIAN and ByteOrder.LITTLE_ENDIAN, like so:
    byteArray.order( ByteOrder.BIG_ENDIAN );
    You can retrieve the native ordering for your platform using the static ByteOr
    der.nativeOrder() method. (We know you’re curious.)
    
    
    Allocating buffers
    You can create a buffer either by allocating it explicitly using allocate() or by wrap‐
    ping an existing plain Java array type. Each buffer type has a static allocate()
    method that takes a capacity (size) and also a wrap() method that takes an existing
    array:
    CharBuffer cbuf = CharBuffer.allocate( 64*1024 );
    ByteBuffer bbuf = ByteBuffer.wrap( someExistingArray );
    A direct buffer is allocated in the same way, with the allocateDirect() method:
    ByteBuffer bbuf2 = ByteBuffer.allocateDirect( 64*1024 );
    As we described earlier, direct buffers can use operating system memory structures
    that are optimized for use with some kinds of I/O operations. The trade-off is that
    allocating a direct buffer is a little slower and heavier weight operation than a plain
    buffer, so you should try to use them for longer-term buffers.
    
    */
}
