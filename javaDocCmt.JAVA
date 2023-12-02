//Javadoc Comments

/*A block comment beginning with /** indicates a special doc comment. A doc com‐
ment is designed to be extracted by automated documentation generators, such as the
JDK’s javadoc program or the context-aware tooltips in many IDEs. A doc comment
is terminated by the next */, /* just as with a regular block comment. Within the doc
comment, lines beginning with @ are interpreted as special instructions for the docu‐
mentation generator, giving it information about the source code. By convention,
each line of a doc comment begins with a *, as shown in the following example, but
this is optional. Any leading spacing and the * on each line are ignored */

/**
 * I think this class is possibly the most amazing thing you will
 * ever see. Let me tell you about my own personal vision and
 * motivation in creating it.
 * <p>
 * It all began when I was a small child, growing up on the
 * streets of Idaho. Potatoes were the rage, and life was good...
 *
 * @see PotatoPeeler
 * @see PotatoMasher
 * @author John 'Spuds' Smith
 * @version 1.00, 19 Nov 2019
 */
class Potato {}

/*javadoc creates HTML documentation for classes by reading the source code and
pulling out the embedded comments and @ tags. In this example, the tags cause
author and version information to be presented in the class documentation. The @see
tags produce hypertext links to the related class documentation.

The compiler also looks at the doc comments; in particular, it is interested in the @dep
recated tag, which means that the method has been declared obsolete and should be
avoided in new programs. The fact that a method is deprecated is noted in the com‐
piled class file so a warning message can be generated whenever you use a deprecated
feature in your code (even if the source isn’t available).

Doc comments can appear above class, method, and variable definitions, but some
tags may not be applicable to all of these. For example, the @exception tag can only
be applied to methods. Table 4-1 summarizes the tags used in doc comments. */


/*Table 4-1. Doc comment tags
Tag Description Applies to
@see= Associated class name= Class, method, or variable
@= Source code content= Class, method, or variable
@link= Associated URL= Class, method, or variable
@author= Author name= Class
@version= Version string= Class
@param= Parameter name and description= Method
@return= Description of return value= Method
@exception= Exception name and description =Method
@deprecated= Declares an item to be obsolete =Class, method, or variable
@since Notes= API version when item was added = Variable
 */