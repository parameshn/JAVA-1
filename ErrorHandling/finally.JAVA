/*The Finally Clause


What if we have something important to do before we exit our method from one of
the catch clauses? To avoid duplicating the code in each catch branch and to make
the cleanup more explicit, you can use the finally clause. A finally clause can be
added after a try and any associated catch clauses. Any statements in the body of the
finally clause are guaranteed to be executed no matter how control leaves the try
body, whether an exception was thrown or not: */

try {
    // Do something here
    }
    catch ( FileNotFoundException e ) {
    ...
    }
    catch ( IOException e ) {
    ...
    }
    catch ( Exception e ) {
    ...
    }
    finally {
    // Cleanup here is always executed
    }
   /*In this example, the statements at the cleanup point are executed eventually, no mat‐
ter how control leaves the try. If control transfers to one of the catch clauses, the
statements in finally are executed after the catch completes. If none of the catch
clauses handles the exception, the finally statements are executed before the excep‐
tion propagates to the next level.
If the statements in the try execute cleanly, or if we perform a return, break, or con
tinue, the statements in the finally clause are still executed. To guarantee that some
operations will run, we can even use try and finally without any catch clauses:
 */
try {
    // Do something here
    return;
    }
    finally {
        System.out.println("Whoo-hoo!");
 }
 /*Exceptions that occur in a catch or finally clause are handled normally; the search
for an enclosing try/catch begins outside the offending try statement, after the
finally has been executed.
 */