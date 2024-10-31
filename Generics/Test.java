package Generics;

import java.util.Collections;
// import java.util.Collection;
// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Fruit {
    protected String name;
    protected int size;

    protected Fruit(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public boolean equals(Object o) {
        if (o instanceof Fruit) {
            Fruit that = (Fruit) o;
            return this.name.equals(that.name) && this.size == that.size;
        } else
            return false;
    }

    public int hashCode() {
        return name.hashCode() * 29 + size;
    }

    protected int compareTo(Fruit that) {
        return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
    }
}

class Apple extends Fruit implements Comparable<Apple> {
    public Apple(int size) {
        super("Apple", size);
    }

    public int compareTo(Apple a) {
        return super.compareTo(a);
    }
}

class Orange extends Fruit implements Comparable<Orange> {
    public Orange(int size) {
        super("Orange", size);
    }

    public int compareTo(Orange o) {
        return super.compareTo(o);
    }
}
class Test {
    public static void main(String[] args) {
        Apple a1 = new Apple(1);
        Apple a2 = new Apple(2);
        Orange o3 = new Orange(3);
        Orange o4 = new Orange(4);
        List<Apple> apples = Arrays.asList(a1, a2);
        assert Collections.max(apples).equals(a2);
        List<Orange> oranges = Arrays.asList(o3, o4);
        assert Collections.max(oranges).equals(o4);
        // List<Fruit> mixed = Arrays.<Fruit>asList(a1, o3);
        // assert Collections.max(mixed).equals(o3); // compile-time error
        System.out.println("tick = fruit ");

        assert "two".compareTo("three") > 0;
        System.out.println("tick =");
    }
}