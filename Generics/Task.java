package Generics;

import java.util.*;

public abstract class Task implements Comparable<Task> {
    protected Task() {
    }

    public boolean equals(Object o) {
        if (o instanceof Task) {
            return toString().equals(o.toString());
        } else
            return false;
    }

    public int compareTo(Task t) {
        return toString().compareTo(t.toString());
    }

    public int hashCode() {
        return toString().hashCode();

    }

    public abstract String toString();

}

final class CodingTask extends Task {
    public final String spec;

    public CodingTask(String spec) {
        this.spec = spec;
    }

    public String toString() {
        return "code " + spec;
    }

    public String getSpec() {
        return spec;
    }

}

final class PhoneTask extends Task {
    private final String name;
    private final String number;

    public PhoneTask(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return "phone " + name;
    }
}

class EmptyTask extends Task {
    public EmptyTask() {
    }

    public String toString() {
        return "";
    }
}

class TestTask {
    public static void main(String[] args) {
        PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
        PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
        CodingTask databaseCode = new CodingTask("db");
        CodingTask interfaceCode = new CodingTask("gui");
        CodingTask logicCode = new CodingTask("logic");

        Collection<PhoneTask> phoneTasks = new ArrayList<PhoneTask>();
        Collection<CodingTask> codingTasks = new ArrayList<CodingTask>();
        Collection<Task> mondayTasks = new ArrayList<Task>();
        Collection<Task> tuesdayTasks = new ArrayList<Task>();

        Collections.addAll(phoneTasks, mikePhone, paulPhone);
        Collections.addAll(codingTasks, databaseCode, interfaceCode, logicCode);
        Collections.addAll(mondayTasks, logicCode, mikePhone);
        Collections.addAll(tuesdayTasks, databaseCode, interfaceCode, paulPhone);

        assert phoneTasks.toString().equals("[phone Mike, phone Paul]");
        assert codingTasks.toString().equals("[code db,code gui,code logic]");
        assert mondayTasks.toString().equals("[code logic,phone Mike]");
        assert tuesdayTasks.toString().equals("[code db,code gui,phone  Paul]");

        System.out.println(phoneTasks);

        // Adding elements

        mondayTasks.add(new PhoneTask("Ruth", "567 1234"));
        assert mondayTasks.toString().equals("[code logic,phone mike,phone mike]");

        Collection<Task> allTasks = new ArrayList<Task>(mondayTasks);
        allTasks.addAll(tuesdayTasks);
        /*
         * No, you would need to use addAll here, rather than add, because add only adds
         * a single element to the collection, while addAll allows you to add all
         * elements from another collection.
         */

        assert allTasks.toString().equals(
                "[code logic, phone Mike, phone Ruth, code db, code gui, phone Paul]");

        // Removingg elements
        boolean wasPresent = mondayTasks.remove(mikePhone);
        assert wasPresent;
        assert mondayTasks.toString().equals("[code logic,phone Ruth]");

        // clearing out fully
        mondayTasks.clear();

        Collection<Task> allTask2 = new ArrayList<>();
        allTask2.addAll(mondayTasks);
        // allTask2.add(tuesdayTasks); error
        allTask2.addAll(codingTasks);

        Collection<Collection<String>> collectionOfCollections = new ArrayList<>(); // does not preserve order
        Collection<String> innerCollection = new ArrayList<>();
        innerCollection.add("Element 1");
        collectionOfCollections.add(innerCollection);
        // collectionOfCollections.add(mikePhone); error

        // collection defined to hold list of collections can only hold collections not
        // objects and vice versa

    }
}
// what if there's no tostring method?
/*
 * If there’s no `toString()` method in the `PhoneTask` or `CodingTask` classes,
 * the output of `System.out.println(phoneTasks);` would look something like
 * this:
 * 
 * ```java
 * [Generics.PhoneTask@15db9742, Generics.PhoneTask@6d06d69c]
 * ```
 * 
 * Here’s what happens in this case:
 * 
 * 1. **Default `toString()` in Object Class**: If a class doesn’t override
 * `toString()`, Java uses the default `toString()` method from the `Object`
 * class. This method returns a string that includes the class name and the
 * object's memory address (or "hash code") in hexadecimal, as shown in the
 * example output.
 * 
 * 2. **Unclear Representation**: Since the default `toString()` provides
 * limited information (just the class name and memory address), it doesn’t give
 * us any useful insight into the object’s data or meaning, making it harder to
 * understand what’s inside the collection.
 * 
 * To make the output meaningful, it’s usually good practice to override
 * `toString()` in custom classes like `PhoneTask` and `CodingTask`.
 */

/*
 * No, you would need to use addAll here, rather than add, because add only adds
 * a single element to the collection, while addAll allows you to add all
 * elements from another collection. Here's how they work differently in this
 * context:
 * 
 * Using add: If you use allTasks.add(tuesdayTasks);, it will add tuesdayTasks
 * as a single item (a nested Collection inside allTasks), rather than adding
 * each individual task from tuesdayTasks. This is likely not what you want, as
 * allTasks would then contain the elements of mondayTasks, followed by a single
 * item: the entire tuesdayTasks collection.
 * 
 * Using addAll: By using allTasks.addAll(tuesdayTasks);, you are adding each
 * element in tuesdayTasks as an individual item into allTasks. This will give
 * you a flat list of all tasks in mondayTasks and tuesdayTasks, which is
 * probably what you're looking for.
 * 
 * In summary, addAll is the correct method here to combine two collections into
 * one, maintaining each element individually within allTasks.
 */

// how to access if i use elements of tuesdayTasks if i use add
/*
 * If you use `add` to add `tuesdayTasks` to `allTasks`, you’ll end up with a
 * nested collection structure, where `tuesdayTasks` is a single element within
 * `allTasks`, rather than each task in `tuesdayTasks` being added individually.
 * 
 * Here’s how it would work:
 * 
 * ```java
 * Collection<Task> allTasks = new ArrayList<Task>(mondayTasks);
 * allTasks.add(tuesdayTasks); // This adds the entire tuesdayTasks collection
 * as one element
 * ```
 * 
 * If you try to access `tuesdayTasks` this way, it won’t work as expected
 * because `allTasks` now contains a single element that is the `tuesdayTasks`
 * collection itself, not the individual tasks inside `tuesdayTasks`.
 * 
 * To access elements of `tuesdayTasks` in this scenario, you would need to cast
 * the element back to `Collection<Task>` and then iterate over it. Here’s an
 * example:
 * 
 * ```java
 * for (Object task : allTasks) {
 * if (task instanceof Collection) {
 * Collection<Task> nestedTasks = (Collection<Task>) task;
 * for (Task t : nestedTasks) {
 * System.out.println(t); // Access each task within tuesdayTasks
 * }
 * } else {
 * System.out.println(task); // Access individual tasks (if any) added directly
 * to allTasks
 * }
 * }
 * ```
 * 
 * This approach is generally discouraged because it’s not very intuitive and
 * creates unnecessary complexity. It’s better to use `addAll`, which will give
 * you a flat structure with all tasks as individual elements in `allTasks`,
 * making them directly accessible without any casting or nested iteration.
 */