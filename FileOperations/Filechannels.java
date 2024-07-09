package FileOperations;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import NetworkingAndIO.CharEncode;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/*FileChannel
Now that we’ve covered the basics of channels and buffers, it’s time to look at a real
channel type. The FileChannel is the NIO equivalent of the java.io.RandomAccess
File , but it provides several core new features in addition to some performance opti‐
mizations. In particular, use a FileChannel in place of a plain java.io file stream if
you wish to use file locking, memory-mapped file access, or highly optimized data
transfer between files or between file and network channels. */
public class Filechannels {
    /*
     * A FileChannel can be created for a Path using the static FileChannel open()
     * method:
     */

    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        Path p = fs.getPath("hahah.txt");
        // opend default for reading
        try (FileChannel channel = FileChannel.open(p)) {
            // By default, open() creates a read-only channel for the file
        } catch (IOException ae) {
            System.out.println("0111111111");
        }

        // Open with options for writing
        try (FileChannel channel = FileChannel.open(p, StandardOpenOption.CREATE, StandardOpenOption.WRITE,StandardOpenOption.APPEND)) {
            /*By default, open() creates a read-only channel for the file. We can open a channel for
            writing or appending and control other, more advanced features such as atomic cre‐
            ate and data syncing by passing additional options
            */

            /*A FileChannel can also be constructed from a classic FileInputStream, FileOutput
            Stream, or RandomAccessFile:*/

            FileChannel readOnlyFC = new FileInputStream("hahah.txt").getChannel();
            FileChannel readWriteFc = new RandomAccessFile("hahah.txt", "rw").getChannel();

            /*FileChannels created from these file input and output streams are read-only or
            write-only, respectively. To get a read/write FileChannel, you must construct a Ran
            domAccessFile with read/write options, as in the previous example.
            */

            /* Using a FileChannel is just like a RandomAccessFile, but it works with a ByteBuffer
            instead of byte arrays:
            */
            int buffsize = 1024;
            ByteBuffer bbuf = ByteBuffer.allocate(buffsize);
            InputStream in = System.in;
            byte[] bArray = new byte[20];

            System.out.println("Please enter some input:");
            int bytesRead = in.read(bArray);
            bbuf.put(bArray,0,bytesRead);
            bbuf.flip();

            int index = 0;
            channel.position(index);
            channel.write(bbuf);

            /*You can control how much data is read and written either by setting buffer position
            and limit markers or using another form of read/write that takes a buffer starting
            position and length. You can also read and write to a random position by supplying
            indexes with the read and write methods:
            */
            index = 10;
            channel.write(bbuf, index);
            /*In each case, the actual number of bytes read or written depends on several factors.
        The operation tries to read or write to the limit of the buffer, and the vast majority of
        the time that is what happens with local file access. The operation is guaranteed to
        block only until at least one byte has been processed. Whatever happens, the number
        of bytes processed is returned, and the buffer position is updated accordingly, prepar‐
        ing you to repeat the operation until it is complete, if needed. This is one of the con‐
        veniences of working with buffers; they can manage the count for you. Like standard
        streams, the channel read() method returns -1 upon reaching the end of input.
        The size of the file is always available with the size() method. It can change if you
        write past the end of the file. Conversely, you can truncate the file to a specified
        length with the truncate() method.
        */
            /////////////////////////////////////////////////////////////////////
            /*File locking
            FileChannels support exclusive and shared locks on regions of files through the
            lock() method:
            */

            FileLock fileLock = channel.lock();

            Path p2 = fs.getPath("NetworkingAndIO\\CharEncode.java");
            FileChannel fileChannel2 = FileChannel.open(p2);
            int start = 0;
            long len = fileChannel2.size();

            FileLock readLock = fileChannel2.lock(start, len, true);

            /*Locks may be either shared or exclusive. An exclusive lock prevents others from
            acquiring a lock of any kind on the specified file or file region. A shared lock allows
            others to acquire overlapping shared locks but not exclusive locks. These are useful as
            write and read locks, respectively. When you are writing, you don’t want others to be
            able to write until you’re done, but when reading, you need only to block others from
            writing, not reading concurrently.
            The no-args lock() method in the previous example attempts to acquire an exclusive
            lock for the whole file. The second form accepts a starting and length parameter as
            well as a flag indicating whether the lock should be shared (or exclusive). The File
            Lock object returned by the lock() method can be used to release the lock:
            */

            fileLock.release();

        } catch (IOException ae) {
            System.out.println("02222");
        }

        /*Note that file locks are only guaranteed to be a cooperative API; they do not necessar‐
        ily prevent anyone from reading or writing to the locked file contents. In general, the
        only way to guarantee that locks are obeyed is for both parties to attempt to acquire
        the lock and use it. Also, shared locks are not implemented on some systems, in
        which case all requested locks are exclusive. You can test whether a lock is shared
        with the isShared() method.
        FileChannel locks are held until the channel is closed or interrupted, so performing
        locks within a try-with-resources statement will help ensure that locks are released
        more robustly
        */

        try (FileChannel channel = FileChannel.open(p, StandardOpenOption.WRITE)) {
            channel.lock();
        }catch(IOException ar){}

        // Table 11-3. java.nio.file.StandardOpenOption ---395


        /*Concurrent access
        FileChannels are safe for use by multiple threads and guarantee that data “viewed”
        by them is consistent across channels in the same VM. Unless you specify the SYNC or
        DSYNC options, no guarantees are made about how quickly writes are propagated to
        the storage mechanism. If you only intermittently need to be sure that data is safe
        before moving on, you can use the force() method to flush changes to disk. This
        method takes a Boolean argument indicating whether file metadata, including time‐
        stamp and permissions, must be written (sync or dsync). Some systems keep track of
        reads on files as well as writes, so you can save a lot of updates if you set the flag to
        false, which indicates that you don’t care about syncing that data immediately.
        As with all Channels, a FileChannel may be closed by any thread. Once closed, all its
        read/write and position-related methods throw a ClosedChannelException.
        */

    }
}
