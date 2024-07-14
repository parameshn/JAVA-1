package NetworkProgramming;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.Socket;
import java.io.*;
import java.time.*;
import java.util.Date;

public class DateAtHost extends java.util.Date{
    /*The DateAtHost Client
    In the past, many networked computers ran a simple time service that dispensed their
    clock’s local time on a well-known port. This was a precursor of NTP, the more gen‐
    eral Network Time Protocol.5
    The next example, DateAtHost, includes a subclass of
    java.util.Date that fetches the time from a remote host instead of initializing itself
    from the local clock. (See Chapter 8 for a discussion of the Date class, which is still
    good for some uses but has been largely replaced by its newer, more flexible cousins,
    LocalDate and LocalTime.)DateAtHost connects to the time service (port 37) and reads four bytes representing
    the time on the remote host. These four bytes have a peculiar specification that we
    decode to get the time. Here’s the code:
    */
    static int timePort = 37;
    // seconds from start of 20th century to Jan 1, 1970 00:00 GMT
    static final long offset = 2208988800L;

    public DateAtHost(String host) throws IOException {
        this(host, timePort);
    }

    public DateAtHost(String host, int port) throws IOException {
        Socket server = new Socket(host, port);
        DataInputStream din = new DataInputStream(server.getInputStream());
        int time = din.readInt();
        server.close();
        // long correctedTime = ((time & 0xFFFFFFFFL) - offset) * 1000;//(((1L << 32) + time) - offset) * 1000;
        // setTime(correctedTime);
        setTime((((1L << 32) + time) - offset) * 1000);

    }
}

/*That’s all there is to it. It’s not very long, even with a few frills. We have supplied two
possible constructors for DateAtHost. Normally we’d expect to use the first, which
simply takes the name of the remote host as an argument. The second constructor
specifies the hostname and the port number of the remote time service. (If the time
service were running on a nonstandard port, we would use the second constructor to
specify the alternate port number.) This second constructor does the work of making
the connection and setting the time. The first constructor simply invokes the second
(using the this() construct) with the default port as an argument. Supplying simpli‐
fied constructors that invoke their siblings with default arguments is a common and
useful pattern in Java; that is the main reason we’ve shown it here.
The second constructor opens a socket to the specified port on the remote host. It
creates a DataInputStream to wrap the input stream and then reads a four-byte inte‐
ger using the readInt() method. It’s no coincidence that the bytes are in the right
order. Java’s DataInputStream and DataOutputStream classes work with the bytes of
integer types in network byte order (most significant to least significant). The time
protocol (and other standard network protocols that deal with binary data) also uses
the network byte order, so we don’t need to call any conversion routines. Explicit data
conversions would probably be necessary if we were using a nonstandard protocol,
especially when talking to a non-Java client or server. In that case, we’d have to read
 */