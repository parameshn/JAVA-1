package FileOperations;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
/*The NIO File API
    We are now going to turn our attention from the original, “classic” Java File API to
    the new NIO File API introduced with Java 7. As we mentioned earlier, the NIO File
    API can be thought of as either a replacement for or a complement to the classic API.
    Included in the NIO package, the new API is nominally part of an effort to move Java
    toward a higher performance and more flexible style of I/O supporting selectable and
    asynchronously interruptable channels. However, in the context of working with files,
    the new API’s strength is that it provides a fuller abstraction of the filesystem in Java.
    In addition to better support for existing, real world, filesystem types—including for
    the first time the ability to copy and move files, manage links, and get detailed file
    attributes like owners and permissions—the new File API allows entirely new types of
    filesystems to be implemented directly in Java. The best example of this is the new
    ZIP filesystem provider that makes it possible to “mount” a ZIP archive file as a file‐
    system and work with the files within it directly using the standard APIs, just like any
    other filesystem. Additionally, the NIO File package provides some utilities that
    would have saved Java developers a lot of repeated code over the years, including
    directory tree change monitoring, filesystem traversal (a visitor pattern), filename
    “globbing,” and convenience methods to read entire files directly into memory
    We’ll cover the basic NIO File API in this section and return to the topic of buffers
    and channels at the end of the chapter. In particular, we’ll talk about ByteChannels
    and FileChannel, which you can think of as alternate, buffer-oriented streams for
    reading and writing files and other types of data.
    */
public class NIOapi {
    NIOapi()
    {
        try {
            /*FileSystem and Path
            The main players in the java.nio.file package are: the FileSystem, which repre‐
            sents an underlying storage mechanism and serves as a factory for Path objects; the
            Path, which represents a file or directory within the filesystem; and the Files utility,
            which contains a rich set of static methods for manipulating Path objects to perform
            all of the basic file operations analogous to the classic API.
            The FileSystems (plural) class is our starting point. It is a factory for a FileSystem
            object:
            */

            //the default host computer filesystem
            FileSystem fs = FileSystems.getDefault();

            // A custom filesystem for ZIP files, no special properties

            Map<String, String> props = new HashMap<>();
            URI zipURI = URI.create("jar:file:/Users/pat/tmp/MyArchive.zip");
            FileSystem zipfs = FileSystems.newFileSystem(zipURI, props);
            zipfs.close();

            /*As shown in this snippet, often we’ll simply ask for the default filesystem to manipu‐
            late files in the host computer’s environment, as with the classic API. But the FileSys
            tems class can also construct a FileSystem by taking a URI (a special identifier
            similar to a URL) that references a custom filesystem type. Here we use jar:file as
            our URI protocol to indicate we are working with a JAR or ZIP file.
            FileSystem implements Closeable, and when a FileSystem is closed, all open file
            channels and other streaming objects associated with it are closed as well. Attempting
            to read or write to those channels will throw an exception at that point. Note that the
            default filesystem (associated with the host computer) cannot be closed.
            Once we have a FileSystem, we can use it as a factory for Path objects that represent
            files or directories. A Path can be constructed using a string representation just like
            the classic File, and subsequently used with methods of the Files utility to create,
            read, write, or delete the item.
            
            */

            Path fooPath = fs.getPath("/tmp/foo.txt");
            OutputStream out = Files.newOutputStream(fooPath);
            out.close();

            /*This example opens an OutputStream to write to the file foo.txt. By default, if the file
            does not exist, it will be created, and if it does exist, it will be truncated (set to zero
            length) before new data is written—but you can change these results using options.
            We’ll talk more about Files methods in the next section.
            */

            /*The Path object implements the java.lang.Iterable interface, which can be used to
            iterate through its literal path components (e.g., the slash-separated “tmp” and
            “foo.txt” in the preceding snippet). Although if you want to traverse the path to find
            other files or directories, you might be more interested in the DirectoryStream and
            FileVisitor that we’ll discuss later. Path also implements the java.nio.file.Watch
            able interface, which allows it to be monitored for changes. We’ll also discuss watch‐
            ing file trees for changes in an upcoming section.
            */

            // Path has convenience methods for resolving paths relative to a file or
            // directory:
            Path patPath = fs.getPath("\\USer\\path\\tmp");

            Path patTmp = patPath.resolve("tmp");// \User\pat\tmp
            System.out.println(patTmp);

            //same as above, using a path
            Path tmpPath = fs.getPath("tmp", null);
            Path patTmp2 = patPath.resolve(tmpPath);// \User\pat\tmp

            //Resolving a given absolute path against any path just yields given path
            Path absPath = patPath.resolve("\\tmp"); //  \tmp
            //Resolving sibling to path(same parent)
            Path danPAth = patPath.resolve("dan");// \Users\dan


            /*In this snippet, we’ve shown the Pathresolve() and resolveSibling() methods
            used to find files or directories relative to a given Path object. The resolve() method
            is generally used to append a relative path to an existing Path representing a direc‐
            tory. If the argument provided to the resolve() method is an absolute path, it will
            just yield the absolute path (it acts kind of like the Unix or DOS cd command). The
            resolveSibling() method works the same way, but it is relative to the parent of the
            target Path; this method is useful for describing the target of a move() operation.
            */

            /*Path to classic le and back
            To bridge the old and new APIs, corresponding toPath() and toFile() methods
            have been provided in java.io.File and java.nio.file.Path, respectively, to con‐
            vert to the other form. Of course, the only types of Paths that can be produced from
            File are paths representing files and directories in the default host filesystem.
            
            */

            Path tmpPath3 = fs.getPath("\\tmp", null);
            File file = tmpPath3.toFile();
            File tmpFile = new File("\\tmp");
            Path path = tmpFile.toPath();

            /*With the preceding methods, we can fetch input or output streams or buffered read‐
            ers and writers to a given file. We can also create paths as files and directories, and
            iterate through file hierarchies. We’ll discuss directory operations in the next section.
            As a reminder, the resolve() and resolveSibling() methods of Path are useful for
            constructing targets for the copy() and move() operations:
            */

            // Move the file /tmp/foo.txt to /tmp/bar.txt
            Path foo = fs.getPath("/tmp/foo.txt");
            Files.move(foo, foo.resolveSibling("bar.txt"));

            /*For quickly reading and writing the contents of files without streaming, we can use
            the various readAll… and write methods that move byte arrays or strings in and out
            of files in a single operation. These are very convenient for files that easily fit into 
            memory.
            */
            Path csvPath = Paths.get("input.csv");      // Change to your input file path
        Path newCSVPath = Paths.get("output.csv");  // Change to your output file path
            // Read and write collection of String (e.g., lines of text)
            Charset asciiCharset = Charset.forName("US-ASCII");
            // Read all lines from the input file using the specified charset
            List<String> csvData = Files.readAllLines(csvPath, asciiCharset);
            // Write all lines to the output file using the same charset
            Files.write(newCSVPath, csvData, asciiCharset);



            Path dataPath = Paths.get("input.dat"); // Change to your input file path
            Path newDataPath = Paths.get("output.dat"); // Change to your output file path

            // Read and write bytes
            byte[] data = Files.readAllBytes(dataPath);
            Files.write(newDataPath, data);

        } catch (IOException ae) {

        }

    }
    
    public static void main(String [] mai)
    {
        NIOapi jk = new NIOapi();

        
    }
}
