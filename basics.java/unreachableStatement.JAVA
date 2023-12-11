//Unreachable statements


/*On a final note, we should mention that the Java compiler flags “unreachable” state‐
ments as compile-time errors. An unreachable statement is one that the compiler
determines won’t be called at all. Of course, many methods may never actually be
called in your code, but the compiler detects only those that it can “prove” are never
called by simple checking at compile time. For example, a method with an uncondi‐
tional return statement in the middle of it causes a compile-time error, as does a
method with a conditional that the compiler can tell will never be fulfilled:
 */

 if (1 < 2) {
    // This branch always runs
    System.out.println("1 is, in fact, less than 2");
    return;
    } else {
    // unreachable statements, this branch never runs
    System.out.println("Look at that, seems we got \"math\" wrong.");
    }
   