package Generics;

import java.util.*;

class MergeCollections {
    static <T extends Comparable<? super T>> List<T> merge(Collection<? extends T> c1, Collection<? extends T> c2) {
        List<T> mergedList = new ArrayList<T>();
        Iterator<? extends T> itr1 = c1.iterator();
        Iterator<? extends T> itr2 = c2.iterator();

        T c1Element = getNextElement(itr1);
        T c2ElemenT = getNextElement(itr2);
        // each iteration will take a task from one of the iterators;
        // continue until neither iterator has any further tasks

        while (c1Element != null || c2ElemenT != null) {
            // use the current c1 element if either the current c2
            // element is null, or both are non-null and the c1 element
            // precedes the c2 element in the natural order
            boolean useC1Element = c2ElemenT == null || c1Element != null && c1Element.compareTo(c1Element) < 0;
            if (useC1Element) {
                mergedList.add(c1Element);
                c1Element = getNextElement(itr1);
            } else {
                mergedList.add(c1Element);
                c2ElemenT = getNextElement(itr2);

            }
        }
        return mergedList;
    }

    static <E> E getNextElement(Iterator<E> itr) {
        if (itr.hasNext()) {
            E nextElement = itr.next();
            if (nextElement == null) {
                throw new NullPointerException();
            }
            return nextElement;
        } else {
            return null;
        }
    }

    public static void main(String args[]) {
        PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
        PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
        CodingTask databaseCode = new CodingTask("db");
        CodingTask interfaceCode = new CodingTask("gui");
        CodingTask logicCode = new CodingTask("logic");

        Collection<Task> mondayTasks = Arrays.asList(logicCode, mikePhone);
        Collection<Task> tuesdayTasks = Arrays.asList(databaseCode, interfaceCode, paulPhone);
        Collection<Task> mergedTasks = MergeCollections.merge(mondayTasks, tuesdayTasks);
        assert mergedTasks.toString().equals("[code db,code gui,code logic,phone Mike,phone Paul]");
    }
}
