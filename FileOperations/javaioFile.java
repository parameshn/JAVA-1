package FileOperations;

import java.io.File;

public class javaioFile {
    /*The java.io.File class encapsulates access to information about a file or directory. It
    can be used to get attribute information about a file, list the entries in a directory, and
    perform basic filesystem operations, such as removing a file or making a directory.
    While the File object handles these “meta” operations, it doesn’t provide the API for
    reading and writing file data; there are file streams for that purpose.
    */


    /*
     * File constructors
     * You can create an instance of File from a String pathname:
     */

    File fooFile = new File ("/tmp/foo.txt");
    File barDir = new File("/tmp/bar");

    // You can also create a file with a relative path:

    File f = new File("foo");

    /*In this case, Java works relative to the “current working directory” of the Java inter‐
    preter. You can determine the current working directory by reading the user.dir
    property in the System Properties list:
    */

    javaioFile ()
    {
        System.getProperty("user.dir");

        /*An overloaded version of the File constructor lets you specify the directory path and
        filename as separate String objects:
        */

        File fooFile2 = new File("/tmp", "foo.txt");

        /*With yet another variation, you can specify the directory with a File object and the
        filename with a String:
        */

        File barFile = new File(fooFile, "foo.txt");

        /*None of these File constructors actually creates a file or directory, and it is not an
        error to create a File object for a nonexistent file. 
        
        The File object is just a handle for
        a file or directory whose properties you may wish to read, write, or test. For example,
        you can use the exists() instance method to learn whether the file or directory
        exists.
        
        */

        /*Path localization
        One issue with working with files in Java is that pathnames are expected to follow the
        conventions of the local filesystem. Two differences are that the Windows filesystem
        uses “roots” or drive letters (for example, C:) and a backslash (\) instead of the for‐
        ward slash (/) path separator that is used in other systems.
        Java tries to compensate for the differences. For example, on Windows platforms, Java
        accepts paths with either forward slashes or backslashes. (On others, however, it only
        accepts forward slashes.)
        Your best bet is to make sure you follow the filename conventions of the host filesys‐
        tem. If your application has a GUI that is opening and saving files at the user’s
        request, you should be able to handle that functionality with the Swing JFileChooser
        class. This class encapsulates a graphical file-selection dialog box. The methods of the
        JFileChooser take care of system-dependent filename features for you.
        If your application needs to deal with files on its own behalf, however, things get a
        little more complicated. The File class contains a few static variables to make this
        task possible. File.separator defines a String that specifies the file separator on the
        local host (e.g., / on Unix and macOS systems, and \ on Windows systems);
        File.separatorChar provides the same information as a char.
        You can use this system-dependent information in several ways. Probably the sim‐
        plest way to localize pathnames is to pick a convention that you use internally, such as
        the forward slash (/), and do a String replace to substitute for the localized separator
        character:
        
        */
        // we'll use forward slash as our standard
        String path = "mail/2004/june/merle";
        path = path.replace('/', File.separatorChar);  // mail\2004\june\merle
        File mailbox = new File(path);

        String[] path2 = { "mail", "2004", "june", "merle" };

        StringBuffer sb = new StringBuffer(path2[0]);
        for(int i = 1;i<path2.length;i++){
            sb.append(File.separator + path2[i]);
        }
        File mailbox2 = new File(sb.toString());// mail\2004\june\merle
        System.out.println(mailbox2 + "\n" + path2.length+"\n"+fooFile2+"\n"+fooFile+"\n"+ barFile+"\n"+mailbox);

    }

}
