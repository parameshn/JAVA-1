public class SystemPropertiesExample {
    public static void main(String[] args) {
        // Get and display Java version
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java Version: " + javaVersion);

        // Get and display Java home directory
        String javaHome = System.getProperty("java.home");
        System.out.println("Java Home: " + javaHome);

        // Get and display operating system name
        String osName = System.getProperty("os.name");
        System.out.println("Operating System: " + osName);

        // Get and display user's current working directory
        String userDir = System.getProperty("user.dir");
        System.out.println("User's Current Working Directory: " + userDir);

        // Get and display user's home directory
        String userHome = System.getProperty("user.home");
        System.out.println("User's Home Directory: " + userHome);
    }
}
/*
 * Yes, you're correct. In Java, the System.getProperty() method is used to
 * retrieve system properties, which are essentially key-value pairs
 * representing various settings and configuration information about the Java
 * Virtual Machine (JVM) and the underlying system. These properties are stored
 * as strings and can be accessed using the System.getProperty(String key)
 * method.
 */

/*
 * Common System Properties:
 * There are several standard system properties commonly used in Java
 * programming, such as:
 * 
 * "java.version": Java Runtime Environment version.
 * "java.home": Java installation directory.
 * "os.name": Operating system name.
 * "user.dir": User's current working directory.
 * "user.home": User's home directory.
 * example
 * String javaVersion = System.getProperty("java.version");
 * 
 */

/*
 * Setting System Properties:
 * While system properties are generally read-only, you can set some of them
 * during the startup of your Java application using the -D command-line option:
 * 
 * code
 * java -DpropertyName=propertyValue YourJavaClass
 * 
 * In this example, propertyName is the name of the system property, and
 * propertyValue is the value you want to set.
 */
/*
 * Security Considerations:
 * Some system properties may be sensitive, and altering them might have
 * security implications. Always be cautious when using or setting system
 * properties, especially in production environments.
 * 
 * Overall, system properties provide a way for Java applications to obtain
 * information about the runtime environment and configure certain aspects of
 * their behavior.
 */