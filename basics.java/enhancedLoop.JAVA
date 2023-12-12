//The enhanced for loop
/*Java’s auspiciously dubbed “enhanced for loop” acts like the foreach statement in
some other languages, iterating over a series of values in an array or other type of
collection:


    for ( varDeclaration : iterable )
 statement;



 The enhanced for loop can be used to loop over arrays of any type as well as any kind
of Java object that implements the java.lang.Iterable interface. This includes most
of the classes of the Java Collections API. We’ll talk about arrays in this and the next
chapter; Chapter 7 covers Java Collections. Here are a couple of examples:
 */
int [] arrayOfInts = new int [] { 1, 2, 3, 4 };
 for( int i : arrayOfInts )
 System.out.println( i );
 List<String> list = new ArrayList<String>();
 list.add("foo");
 list.add("bar");
 for( String s : list )
 System.out.println( s );

 /*int [] arrayOfInts = new int [] { 1, 2, 3, 4 };
 for( int i : arrayOfInts )
 System.out.println( i );
 List<String> list = new ArrayList<String>();
 list.add("foo");
 list.add("bar");
 for( String s : list )
 System.out.println( s ); */