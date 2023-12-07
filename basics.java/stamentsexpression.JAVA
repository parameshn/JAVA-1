/* Statements and Expressions
Java statements appear inside methods and classes; they describe all activities of a Java
program. Variable declarations and assignments, such as those in the previous sec‐
tion, are statements, as are basic language structures such as if/then conditionals and
loops. (More on these structures later in this chapter.)
*/
int size = 5;
 if ( size > 10 )
 doSomething();
 for ( int x = 0; x < size; x++ ) { ... }
/*Expressions produce values; an expression is evaluated to produce a result that is to be
used as part of another expression or in a statement. Method calls, object allocations,
and, of course, mathematical expressions are examples of expressions.
 */
new Object()
 Math.sin( 3.1415 )
 42 * 64


 /*One of the tenets of Java is to keep things simple and consistent. To that end, when
there are no other constraints, evaluations and initializations in Java always occur in
the order in which they appear in the code—from left to right, top to bottom. We’ll
see this rule used in the evaluation of assignment expressions, method calls, and array
indexes, to name a few cases. In some other languages, the order of evaluation is
more complicated or even implementation dependent. Java removes this element of
danger by precisely and simply defining how the code is evaluated. This doesn’t mean
you should start writing obscure and convoluted statements, however. Relying on the
order of evaluation of expressions in complex ways is a bad programming habit, even
when it works. It produces code that is hard to read and harder to modify.