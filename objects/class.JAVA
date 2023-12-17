//Classes

/*Classes are the building blocks of a Java application. A class can contain methods
(functions), variables, initialization code, and, as we’ll discuss later, other classes. Sep‐
arate classes that describe individual parts of a more complex idea are often bundled
in packages, which help you organize larger projects. (Every class belongs to some
package, even the simple examples we’ve seen so far.) An interface can describe some
specific commonalities between otherwise disparate classes. Classes can be related to
each other by extension or to interfaces by implementation. Figure 5-1 illustrates the
ideas in this very dense paragraph.
 */

 /*In this figure, you can see the Object class in the upper-left corner. Object is the
foundational class at the heart of every other class in Java. It is part of the core Java
package, java.lang. Java also has a package for its graphical UI elements called
javax.swing. Inside that package the JComponent class defines all of the low-level,
common properties of graphical things like frames and buttons and canvases. The
JLabel class, for example, extends the JComponent class. That means JLabel inherits
details from JComponent but adds things specific to labels. You might have noticed
that JComponent itself extends from Object, or at least, it eventually extends back to
Object. For brevity’s sake we left out the intermediate classes and packages in
betweenWe can define our own classes and packages as well. The ch05 package in the lower right corner is a custom package we built. In it, we have our game classes like Apple
and Field. You can also see the GamePiece interface that will contain some common,
 */