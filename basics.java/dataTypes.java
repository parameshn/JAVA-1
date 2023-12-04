// Types
/*
 * The type system of a programming language describes how its data elements
 * (the
 * variables and constants we just touched on) are associated with storage in
 * memory
 * and how they are related to one another. In a statically typed language, such
 * as C or C
 * ++, the type of a data element is a simple, unchanging attribute that often
 * corre‐
 * sponds directly to some underlying hardware phenomenon, such as a register or
 * a
 * pointer value. In a more dynamic language, such as Smalltalk or Lisp,
 * variables can be
 * assigned arbitrary elements and can effectively change their type throughout
 * their
 * lifetime. A considerable amount of overhead goes into validating what happens
 * in
 * these languages at runtime. Scripting languages, such as Perl, achieve ease
 * of use by
 * providing drastically simplified type systems in which only certain data
 * elements can
 * be stored in variables, and values are unified into a common representation,
 * such as
 * strings.
 * 
 * Java combines many of the best features of both statically and dynamically
 * typed lan‐
 * guages. As in a statically typed language, every variable and programming
 * element in
 * Java has a type that is known at compile time, so the runtime system doesn’t
 * normally
 * have to check the validity of assignments between types while the code is
 * executing.
 * Unlike traditional C or C++, Java also maintains runtime information about
 * objects
 * and uses this to allow truly dynamic behavior. Java code may load new types
 * at run‐
 * time and use them in fully object-oriented ways, allowing casting and full
 * polymor‐
 * phism (extending of types). Java code may also “reflect” upon or examine its
 * own
 * types at runtime, allowing advanced kinds of application behavior such as
 * inter‐
 * preters that can interact with compiled programs dynamically.
 * 
 * Java data types fall into two categories. Primitive types represent simple
 * values that
 * have built-in functionality in the language; they represent simple values
 * such as num‐
 * bers, booleans, and characters. Reference types (or class types) include
 * objects and
 * arrays; they are called reference types because they “refer to” a large data
 * type that is
 * passed “by reference,” as we’ll explain shortly. Generic types and methods
 * define and
 * operate on objects of various types while providing compile-time type safety.
 * For
 * example, a List<String> is a List that can only contain Strings. These are
 * also ref‐
 * erence types
 */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Primitive Types

/*
 * Numbers, characters, and boolean values are fundamental elements in Java.
 * Unlike
 * some other (perhaps more pure) object-oriented languages, they are not
 * objects. For
 * those situations where it’s desirable to treat a primitive value as an
 * object, Java pro‐
 * vides “wrapper” classes. (More on this later.) The major advantage of
 * treating primi‐
 * tive values as special is that the Java compiler and runtime can more readily
 * optimize
 * their implementation. Primitive values and computations can still be mapped
 * down
 * to hardware as they always have been in lower-level languages. Indeed, if you
 * work
 * with native libraries using the Java Native Interface (JNI) to interact with
 * other lan‐
 * guages or services, these primitive types will figure prominently in your
 * code.
 * 
 * 
 * An important portability feature of Java is that primitive types are
 * precisely defined.
 * For example, you never have to worry about the size of an int on a particular
 * plat‐
 * form; it’s always a 32-bit, signed, two’s complement number. The “size” of a
 * numeric
 * type determines how big (or how precise) a value you can store. For example,
 * the
 * byte type is for small numbers, from -128 to 127, while the int type can
 * handle most
 * numeric needs, storing values between (roughly) +/- two billion. Table 4-2
 * summari‐
 * zes Java’s primitive types.
 */

/*
 * Table 4-2. Java primitive data types
 * 
 * Type Denition Approximate range or precision
 * 
 * boolean = Logical value = true or false
 * char = 16-bit, Unicode character = 64K characters
 * byte = 8-bit, signed, two’s complement integer = -128 to 127
 * short = 16-bit, signed, two’s complement integer = -32,768 to 32,767
 * int = 32-bit, signed, two’s complement integer= -2.1e9 to 2.1e9
 * long 64-bit, signed, two’s complement integer= -9.2e18 to 9.2e18
 * float = 32-bit, IEEE 754, floating-point value = 6-7 significant decimal
 * places
 * double = 64-bit, IEEE 754 = 15 significant decimal places
 */

/*
 * If you do need bigger numbers than the primitive types offer, you can check
 * out the
 * BigInteger and BigDecimal classes in the java.Math package. These classes
 * offer
 * near-infinite size or precision.
 */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// Floating-point precision

/*
 * Floating-point operations in Java follow the IEEE 754 international
 * specification,
 * which means that the result of floating-point calculations is normally the
 * same on dif‐
 * ferent Java platforms. However, Java allows for extended precision on
 * platforms that
 * support it. This can introduce extremely small-valued and arcane differences
 * in the
 * results of high-precision operations. Most applications would never notice
 * this, but if
 * you want to ensure that your application produces exactly the same results on
 * differ‐
 * ent platforms, you can use the special keyword strictfp as a class modifier
 * on the
 * class containing the floating-point manipulation (we cover classes in the
 * next chap‐
 * ter). The compiler then prohibits these platform-specific optimizations.
 */

// Variable declaration and initialization
/*
 * Variables are declared inside of methods and classes with a type name
 * followed by
 * one or more comma-separated variable names. For example:
 */
public class dataTypes {

    static void main() {
        int foo;
        double d1, d2;
        boolean isFun;

        /*
         * Variables can optionally be initialized with an expression of the
         * appropriate
         * type
         * when they are declared
         */
        int foo2 = 42;
        double d12 = 3.14, d22 = 2 * 3.14;
        boolean isFun2 = true;

        /*
         * Variables that are declared as members of a class are set to default values
         * if they aren’t
         * initialized (see Chapter 5). In this case, numeric types default to the
         * appropriate fla‐
         * vor of zero, characters are set to the null character (\0), and boolean
         * variables have
         * the value false. (Reference types also get a default value, null, but more
         * on
         * that soon
         * in “Reference Types” on page 95.) Local variables, which are declared
         * inside
         * a method
         * and live only for the duration of a method call, on the other hand, must be
         * explicitly
         * initialized before they can be used. As we’ll see, the compiler enforces
         * this
         * rule so
         * there is no danger of forgetting
         */
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Integer literals

        /*
         * Integer literals can be specified in binary (base 2), octal (base 8),
         * decimal
         * (base 10), or hexadecimal (base 16). Binary, octal, and hexadecimal bases
         * are
         * mostly used
         * when dealing with low-level file or network data. They represent useful
         * groupings
         * of individual bits: 1, 3, and 4 bits, respectively. Decimal values have no
         * such
         * mapping, but they are much more human-friendly for most numeric
         * information.
         * A decimal
         * integer is specified by a sequence of digits beginning with one of the
         * characters 1–9:
         */
        int i = 1230;

        /*
         * A binary number is denoted by the leading characters 0b or 0B (zero “b”),
         * followed by
         * a combination of zeros and ones
         */
        int i = 0b01001011; // i = 75 decimal

        // Octal numbers are distinguished from decimal numbers by a simple leading
        // zero:
        int i = 01230; // i = 664 decimal

        /*
         * A hexadecimal number is denoted by the leading characters 0x or 0X (zero
         * “x”), fol‐
         * lowed by a combination of digits and the characters a–f or A–F, which
         * represent the
         * decimal values 10–15:
         */
        int i = 0xFFFF; // i = 65535 decimal

        /*
         * Integer literals are of type int unless they are suffixed with an L,
         * denoting
         * that they
         * are to be produced as a long value:
         */
        long l = 13L;
        long l = 13; // equivalent: 13 is converted from type int
        long l = 40123456789L;
        long l = 40123456789; // error: too big for an int without conversion

        /*
         * (The lowercase letter l is also acceptable but should be avoided because it
         * often looks
         * like the number 1.)
         * When a numeric type is used in an assignment or an expression involving a
         * “larger”
         * type with a greater range, it can be promoted to the bigger type. In the
         * second line of
         * the previous example, the number 13 has the default type of int, but it’s
         * promoted to
         * type long for assignment to the long variable. Certain other numeric and
         * comparison
         * operations also cause this kind of arithmetic promotion, as do mathematical
         * expres‐
         * sions involving more than one type. For example, when multiplying a byte
         * value by
         * an int value, the compiler promotes the byte to an int first:
         */
        byte b = 42;
        int i = 43;
        int result = b * i; // b is promoted to int before multiplication

        /*
         * A numeric value can never go the other way and be assigned to a type with a
         * smaller
         * range without an explicit cast, however:
         */
        int i = 13;
        byte b = i; // Compile-time error, explicit cast needed
        byte b = (byte) i; // OK

        /*
         * Conversions from floating-point to integer types always require an explicit
         * cast
         * because of the potential loss of precision.
         * Finally, we should note that if you are using Java 7 or later, you can add
         * a
         * bit of for‐
         * matting to your numeric literals by utilizing the “_” underscore character
         * between
         * digits. So if you have particularly large strings of digits, you can break
         * them up as in
         * the following examples:
         */
        int RICHARD_NIXONS_SSN = 567_68_0515;
        int for_no_reason = 1___2___3;
        int JAVA_ID = 0xCAFE_BABE;
        long grandTotal = 40_123_456_789L;


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /*Floating-point literals


Floating-point values can be specified in decimal or scientific notation. Floating-point
literals are of type double unless they are suffixed with an f or F denoting that they
are to be produced as a float value. And just as with integer literals, in Java 7 you
may use “_” underscore characters to format floating-point numbers—but only
between digits, not at the beginning, end, or next to the decimal point or “F” signifier
of the number. */

double d = 8.31;
 double e = 3.00e+8;
 float f = 8.31F;
 float g = 3.00e+8F;
 float pi = 3.14_159_265_358;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /*Character literals

A literal character value can be specified either as a single-quoted character or as an
escaped ASCII or Unicode sequence: */

char a = 'a';
 char newline = '\n';
 char smiley = '\u263a';

    }
}