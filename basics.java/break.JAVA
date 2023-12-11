/*The Java break statement and its friend continue can also be used to cut short a loop
or conditional statement by jumping out of it. A break causes Java to stop the current
loop (or switch) statement and resume execution after it. In the following example,
the while loop goes on endlessly until the condition() method returns true, trigger‐
ing a break statement that stops the loop and proceeds at the point marked “after
while”: */

while( true ) {
    if ( condition() )
    break;
}
// after while

/*A continue statement causes for and while loops to move on to their next iteration
by returning to the point where they check their condition. The following example
prints the numbers 0 through 99, skipping number 33: */

for( int i=0; i < 100; i++ ) {
    if ( i == 33 )
    continue;
    System.out.println( i );
    }

    /*The break and continue statements look like those in the C language, but Java’s
forms have the additional ability to take a label as an argument and jump out multiple
levels to the scope of the labeled point in the code. This usage is not very common in
day-to-day Java coding, but may be important in special cases. Here is an outline: */


labelOne:
 while ( condition ) {
 ...
 labelTwo:
 while ( condition ) {
 ...
 // break or continue point
 }
 // after labelTwo
 }
 // after labelOne



 /*Enclosing statements, such as code blocks, conditionals, and loops, can be labeled
with identifiers like labelOne and labelTwo. In this example, a break or continue
without argument at the indicated position has the same effect as the earlier exam‐
ples. A break causes processing to resume at the point labeled “after labelTwo”; a con
tinue immediately causes the labelTwo loop to return to its condition test.
The statement break labelTwo at the indicated point has the same effect as an ordi‐
nary break, but break labelOne breaks both levels and resumes at the point labeled
“after labelOne.” Similarly, continue labelTwo serves as a normal continue, but con
tinue labelOne returns to the test of the labelOne loop. Multilevel break and con
tinue statements remove the main justification for the evil goto statement in C/C++. */