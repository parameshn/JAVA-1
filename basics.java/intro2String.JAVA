//A Word About Strings

/*Strings in Java are objects; they are therefore a reference type. String objects do,
however, have some special help from the Java compiler that makes them look more
like primitive types. Literal string values in Java source code are turned into String
objects by the compiler. They can be used directly, passed as arguments to methods,
or assigned to String type variables: */

System.out.println( "Hello, World..." );
 String s = "I am the walrus...";
 String t = "John said: \"I am the walrus...\"";


 /*The + symbol in Java is “overloaded” to perform string concatenation as well as regu‐
lar numeric addition. Along with its sister +=, this is the only overloaded operator in
Java: */

String quote = "Four score and " + "seven years ago,";
 String more = quote + " our" + " fathers" + " brought...";

 /*Java builds a single String object from the concatenated strings and provides it as the
result of the expression. We discuss the String class and all things text-related in
great detail in Chapter 8. */