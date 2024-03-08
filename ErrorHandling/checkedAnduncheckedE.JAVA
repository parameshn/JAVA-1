/*Checked and Unchecked Exceptions


Java exceptions are therefore divided into two categories: checked
and unchecked. Most application-level exceptions are checked, which means that any
method that throws one, either by generating it itself (as we’ll discuss in “Throwing
Exceptions” on page 178) or by ignoring one that occurs within it, must declare that it
can throw that type of exception in a special throws clause in its method declaration. 

For now, all you need to know is that methods have to declare the checked exceptions
they can throw or allow to be thrown*/

//If we had to throw multiple types
//of exceptions, we could declare them, separated by commas:
void readFile( String s ) throws IOException, InterruptedException {
    ...
    }
   
    /*The throws clause tells the compiler that a method is a possible source of that type of
checked exception and that anyone calling that method must be prepared to deal with
it. The caller must then either use a try/catch block to handle it, or it must, in turn,
declare that it can throw the exception from itself. */


/*Checked exceptions are intended to cover application-level problems, such as missing
files and unavailable hosts. As good programmers (and upstanding citizens), we
should design software to recover gracefully from these kinds of conditions.
Unchecked exceptions are intended for system-level problems, such as “out of mem‐
ory” and “array index out of bounds.” While these may indicate application-level pro‐
gramming errors, they can occur almost anywhere and usually aren’t possible to
recover from. Fortunately, because they are unchecked exceptions, you don’t have to
wrap every one of your array-index operations in a try/catch statement (or declare
all of the calling methods as a potential source of them).
To sum up, checked exceptions are problems that a reasonable application should try
to handle gracefully; unchecked exceptions (runtime exceptions or errors) are prob‐
lems from which we would not normally expect our software to recover. Error types
are those explicitly intended to be conditions that we should not normally try to han‐
dle or recover from.
 */