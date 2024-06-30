package FileOperations;

import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Fileoperation {

    /*File operations
    Once we have a File object, we can use it to ask for information about and perform
    standard operations on the file or directory it represents. A number of methods let us
    ask questions about the File. For example, isFile() returns true if the File repre‐
    sents a regular file, while isDirectory() returns true if it’s a directory. isAbsolute()
    indicates whether the File encapsulates an absolute path or relative path specification.
    An absolute path is a system-dependent notion that means that the path doesn’t
    depend on the application’s working directory or any concept of a working root or
    drive (e.g., in Windows, it is a full path including the drive letter: c:\\Users\pat
    \foo.txt).
    Components of the File pathname are available through the following methods: get
    Name(), getPath(), getAbsolutePath(), and getParent(). getName() returns a
    String for the filename without any directory information. If the File has an abso‐
    lute path specification, getAbsolutePath() returns that path. Otherwise, it returns
    the relative path appended to the current working directory (attempting to make it an
    absolute path). getParent() returns the parent directory of the file or directory.
    The string returned by getPath() or getAbsolutePath() may not follow the same
    case conventions as the underlying filesystem. You can retrieve the filesystem’s own or
    “canonical” version of the file’s path by using the method getCanonicalPath(). In
    Windows, for example, you can create a File object whose getAbsolutePath() is C:
    \Autoexec.bat but whose getCanonicalPath() is C:\AUTOEXEC.BAT; both actually
    point to the same file. This is useful for comparing filenames that may have been sup‐
    plied with different case conventions or for showing them to the user.
    You can get or set the modification time of a file or directory with lastModified()
    and setLastModified() methods. The value is a long that is the number of milli‐
    seconds since the epoch (Jan 1, 1970, 00:00:00 GMT). We can also get the size of the
    file, in bytes, with length().
    Here’s a fragment of code that prints some information about a file:
    */

    Fileoperation() {
        File fooFile = new File("FileOperations\\javaioFile.java");

        String type = fooFile.isFile() ? "file" : "dierctory";
        String name = fooFile.getName();
        long len = fooFile.length();
        System.out.println(type + name + ", " + len + " bytes ");

        File tmp = new File("C:\\Users\\Paramesh\\OneDrive\\Desktop\\JAVA-1\\DesktopApplications");
        String[] fileNAmes = tmp.list();
        File[] files = tmp.listFiles();

        for (int i = 0; i < fileNAmes.length; i++)
            System.out.println(fileNAmes[i]);
        for (int i = 0; i < fileNAmes.length; i++)
            System.out.println(files[i]);

        /*list() returns an array of String objects that contains filenames. listFiles()
        returns an array of File objects. Note that in neither case are the files guaranteed to
        be in any kind of order (alphabetical, for example). You can use the Collections API
        to sort strings alphabetically, like so:
        */
        List list = Arrays.asList(fileNAmes);
        Collections.sort(list);

        /*If the File refers to a nonexistent directory, we can create the directory with mkdir()
        or mkdirs(). The mkdir() method creates at most a single directory level, so any
        intervening directories in the path must already exist. mkdirs() creates all directory
        levels necessary to create the full path of the File specification. In either case, if the
        directory cannot be created, the method returns false. Use renameTo() to rename a
        file or directory and delete() to delete a file or directory.
        Although we can create a directory using the File object, this isn’t the most common
        way to create a file; that’s normally done implicitly when we intend to write data to
        it with a FileOutputStream or FileWriter, as we’ll discuss in a moment. The excep‐
        tion is the createNewFile() method, which can be used to attempt to create a new
        zero-length file at the location pointed to by the File object. The useful thing about
        this method is that the operation is guaranteed to be “atomic” with respect to all other
        file creation in the filesystem. createNewFile() returns a Boolean value that tells
        you whether the file was created or not. This is sometimes used as a primitive locking
        feature—whoever creates the file first “wins.” (The NIO package supports true file
        locks, as we’ll see later.) This is useful in combination deleteOnExit(), which flags
        the file to be automatically removed when the Java VM exits. This combination
        allows you to guard resources or make an application that can only be run in a single
        instance at a time. Another file creation method that is related to the File class itself
        is the static method createTempFile(), which creates a file in a specified location
        using an automatically generated unique name. This, too, is useful in combination
        with deleteOnExit().
        The toURL() method converts a file path to a file: URL object. URLs are an abstrac‐
        tion that allows you to point to any kind of object anywhere on the Net. Converting a
        File reference to a URL may be useful for consistency with more general utilities that
        deal with URLs. File URLs also come into greater use with the NIO File API where
        they can be used to reference new types of filesystems that are implemented directly
        in Java code.
        
        */
    }

    public static void main(String[] args) {
        Fileoperation f = new Fileoperation();

    }

}

/*Method Return type Description
canExecute() Boolean Is the file executable?
canRead() Boolean Is the file (or directory) readable?
canWrite() Boolean Is the file (or directory) writable?
createNewFile() Boolean Creates a new file.
createTempFile 
(String pfx,
Stringsfx)
File Static method to create a new file, with the specifiedprefix and
sux, in the default temp file directory.
delete() Boolean Deletes the file (or directory).
deleteOnExit() Void When it exits, Java runtime system deletes the file.
exists() Boolean Does the file (or directory) exist?
getAbsolutePath() String Returns the absolute path of the file (or directory).
getCanonical
Path()
String Returns the absolute, case-correct, and relative-element-resolved
path of the file (or directory).
getFreeSpace() long Gets the number of bytes of unallocated space on the partition
holding this path or 0 if the path is invalid.
getName() String Returns the name of the file (or directory).
getParent() String Returns the name of the parent directory of the file (or directory).
getPath() String Returns the path of the file (or directory). (Not to be confused with
toPath().)
getTotalSpace() long Gets the size of the partition that contains the file path, in bytes, or
0 if the path is invalid.
getUseableSpace() long Gets the number of bytes of user-accessible unallocated space on
the partition holding this path or 0 if the path is invalid. This
method attempts to take into account user write permissions.
isAbsolute() boolean Is the filename (or directory name) absolute?
isDirectory() boolean Is the item a directory?
isFile() boolean Is the item a file?
isHidden() boolean Is the item hidden? (System dependent.)
lastModified() long Returns the last modification time of the file (or directory).
length() long Returns the length of the file.
list() String [] Returns a list of files in the directory.
listFiles() File[] Returns the contents of the directory as an array of File objects.
listRoots() File[] Returns an array of root filesystems, if any (e.g., C:/, D:/).
mkdir() boolean Creates the directory.
mkdirs() boolean Creates all directories in the path.

Method Return type Description
renameTo(File
dest )
boolean Renames the file (or directory).
setExecutable() boolean Sets execute permissions for the file.
setLastModified() boolean Sets the last-modified time of the file (or directory).
setReadable() boolean Sets read permissions for the file.
setReadOnly() boolean Sets the file to read-only status.
setWriteable() boolean Sets the write permissions for the file.
toPath() java.nio.file.Path Convert the file to an NIO file path (see the NIO File API). (Not to be
confused with getPath().)
toURL() java.net.URL Generates a URL object for the file (or directory).

 */
