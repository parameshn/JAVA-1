//Inferring Types
/*
Modern versions of Java have continually improved the ability to infer variable types
in many situations. You can use the var keyword in conjunction with the declaration
and intiation of a variable and allow the compiler to infer the correct type:
jshell> class Foo2 {}

| created class Foo2
jshell> Foo2 myFoo2 = new Foo2()
myFoo2 ==> Foo2@728938a9
jshell> var myFoo3 = new Foo2()
myFoo3 ==> Foo2@6433a2


Notice the (admittedly ugly) output when you create myFoo3 in jshell. Although we
did not explicitly give the type as we did for myFoo2, the compiler can easily under‐
stand the correct type to use, and we do, in fact, get a Foo2 object. */