/* Containers: Building a Better Mousetrap
 In an object-oriented programming language like Java, polymorphism means that
 objects are always to some degree interchangeable. Any child of a type of object can
 serve in place of its parent type and, ultimately, every object is a child of
 java.lang.Object, the object-oriented “Eve,” so to speak. It is natural, therefore, for
 the most general types of containers in Java to work with the type Object so that they
 can hold just about anything. By containers, we mean classes that hold instances of
 other classes in some way. The Java Collections API we looked at in the previous sec
tion is the best example of containers. List, to recap, holds an ordered collection of
 elements of type Object. And Map holds an association of key/value pairs, with the
 keys and values also being of the most general type, Object. With a little help from
 wrappers for primitive types, this arrangement has served us well. But (not to get too
 Zen on you) in a sense, a “collection of any type” is also a “collection of no type,” and
 working with Objects pushes a great deal of responsibility onto the user of the
 container.
 It’s kind of like a costume party for objects where everybody is wearing the same
 mask and disappears into the crowd of the collection. Once objects are dressed as the
 Object type, the compiler can no longer see the real types and loses track of them. It’s
 up to the user to pierce the anonymity of the objects later by using a type cast. And
 like attempting to yank off a partygoer’s fake beard, you’d better have the cast correct
 or you’ll get an unwelcome surprise.*/

  Date date = new Date();
 List list = new ArrayList();
 list.add( date );
 ...
 Date firstElement = (Date)list.get(0); // Is the cast correct?  Maybe

  /*
  The List interface has an add() method that accepts any type of Object. Here, we
 assigned an instance of ArrayList, which is simply an implementation of the List
 interface, and added a Date object. Is the cast in this example correct? It depends on
 what happens in the elided “…” period of time. Indeed, the Java compiler knows this
 type of activity is fraught and currently issues warnings when you add elements to a
 simple ArrayList as above.
  */