package Utilities;

import java.lang.Math.*;
import java.math.BigDecimal;



public class MathUtilities23 {
    public static void main(String[] arg) {
        /* Math Utilities
        Java supports integer and floating-point arithmetic directly in the language. Higher
        level math operations are supported through the java.lang.Math class. As you may
        have seen by now, wrapper classes for primitive data types allow you to treat them as
        objects. Wrapper classes also hold some methods for basic conversions.
        First, a few words about built-in arithmetic in Java. Java handles errors in integer
        arithmetic by throwing an ArithmeticException:
        */
        int zero = 0;

        try {
            int i = 1 / zero;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        /*To generate the error in this example, we created the intermediate variable zero. The
        compiler is somewhat crafty and would have caught us if we had blatantly tried to
        perform division by a literal zero.
        Floating-point arithmetic expressions, on the other hand, don’t throw exceptions.
        Instead, they take on the special out-of-range values 
        */
        /*
         * Value
         * Mathematical representation
         * POSITIVE_INFINITY 1.0/0.0
         * NEGATIVE_INFINITY-1.0/0.0
         * NaN  0.0/0.0
         */

        double zero2 = 0.0;
        double d = 1.0 / zero2;

        if (d == Double.POSITIVE_INFINITY)
            System.out.println("Division by zero");


    /*The java.lang.Math Class
    The java.lang.Math class is Java’s math library. It holds a suite of static methods cov
    ering all of the usual mathematical operations like sin(), cos(), and sqrt(). The
    Math class isn’t very object-oriented (you can’t create an instance of Math). Instead, it’s
    really just a convenient holder for static methods that are more like global functions.
    */

    /* Method
    Argument type(s)
    Math.abs(a)
    Math.acos(a)
    Math.asin(a)
    Math.atan(a)
    Math.atan2(a,b)
    Math.ceil(a)
    Math.cbrt(a)
    Math.cos(a)
    Math.cosh(a)
    Math.exp(a)
    Math.floor(a)
    Math.hypot(a,b)
    Math.log(a)
    Math.log10(a)
    Math.max(a, b)
    Math.min(a, b)
    Functionality
    int, long, float, double Absolute value
    double
    double
    double
    double
    double
    double
    double
    double
    double
    double
    double
    double
    Arc cosine
    Arc sine
    Arc tangent
    Angle part of rectangular-to-polar coordinate transform
    Smallest whole number greater than or equal to a
    Cube root of a
    Cosine
    Hyperbolic cosine
    Math.E to the power a
    Largest whole number less than or equal to a
    Precision calculation of the sqrt() of a2 + b2
    Natural logarithm of a
    Log base 10 of a
    double
    int, long, float, double The value a or b closer to Long.MAX_VALUE
    Math.pow(a, b)
    Math.random()
    Math.rint(a)
    double
    int, long, float, double The value a or b closer to Long.MIN_VALUE
    a to the power b
    None
    double
    Random-number generator
    Converts double value to integral value in double format
    
    
    Method
    Argument type(s)
    Math.round(a)
    Math.signum(a)
    Math.sin(a)
    Math.sinh(a)
    Math.sqrt(a)
    Math.tan(a)
    Math.tanh(a)
    Math.toDegrees(a) double
    Math.toRadians(a) double
    float, double
    double, float
    double
    double
    double
    double
    double
    Functionality
    Rounds to whole number
    Get the sign of the number at 1.0, –1.0, or 0
    Sine
    Hyperbolic sine
    Square root
    Tangent
    Hyperbolic tangent
    Convert radians to degrees
    Convert degrees to radians
    */


    /* log(), pow(), and sqrt() can throw a runtime ArithmeticException. abs(), max(),
    and min() are overloaded for all the scalar values, int, long, float, or double, and
    return the corresponding type. Versions of Math.round() accept either float or
    double and return int or long, respectively. The rest of the methods operate on and
    return double values:
    */

    double irrational = Math.sqrt(2.0);
    int bigger = Math.max(3, 4);
    long one = Math.round(1.12);
    long two = Math.round(1.6532);
    System.out.println(irrational + "\n" + bigger + "\n" + one + "\n" + two);
    
    // Math also contains the static final double values E and PI:
    int diameter = 5;
    double circumference = diameter * Math.PI;
    int circumference2 = (int) (diameter * Math.PI);
   double e = Math.E;
   System.out.println(circumference + "\n" + circumference2 + "\n" + e + "\n" + Math.PI);
   

   int min = 100;
   int max = 1000;
   double math = Math.random(); //=>0 and <1
   //The Math.random() method
 //returns a random double greater than or equal to 0 and less than 1. 
   System.out.println(math);
   int randomValue = min + (int) (Math.random() * (max - min));
   System.out.println(randomValue);
/*Big/Precise Numbers
 If the long and double types are not large or precise enough for you, the java.math
 package provides two classes, BigInteger and BigDecimal, that support arbitrary
precision numbers. These full-featured classes have a bevy of methods for performing
 arbitrary-precision math and precisely controlling rounding of remainders. In the
 following example, we use BigDecimal to add two very large numbers and then create
 a fraction with a 100-digit result:
  */



   long l1 = 9223372036854775807L; // Long.MAX_VALUE
   long l2 = 9223372036854775807L;
   System.out.println(l1 + l2); // -2 ! Not good.


    try {
 BigDecimal bd1 = new BigDecimal( "9223372036854775807" );
 BigDecimal bd2 = new BigDecimal( 9223372036854775807L );

 System.out.println( bd1.add( bd2 ) ); // 18446744073709551614
 BigDecimal numerator = new BigDecimal(1);
 BigDecimal denominator = new BigDecimal(3);
 BigDecimal fraction =
 numerator.divide( denominator, 100, BigDecimal.ROUND_UP );
 // 100 digit fraction = 0.333333 ... 3334
 }
 catch (NumberFormatException nfe) {
 }

    }
}


