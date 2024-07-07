package NetworkingAndIO;

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
    in conversions:
    Charset charset = Charset.forName("US-ASCII");
    CharBuffer charBuff = charset.decode( byteBuff ); // to ascii
    ByteBuffer byteBuff = charset.encode( charBuff ); // and back
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
    
}
