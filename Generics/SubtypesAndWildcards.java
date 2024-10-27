package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class SubtypesAndWildcards {
    public static double sum(Collection<? extends Number> nums)
    {
        double s = 0.0;
        for (Number num : nums)
            s += num.doubleValue();
        return s;
    }
    
    public  static void count (Collection <? super Integer>ints,int n)
    {
        for (int i = 0; i < n; i++)
            ints.add(i);
    }
    
    public static double sumCount(Collection <Number> nums,int n)
    {
        count(nums, n);
        return sum(nums);

    }

    public static <T> void  reverse(List<T> list)
    {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }
    
    public static <T extends Comparable <T>> T max(Collection <T> coll)
    {
        T candidate = coll.iterator().next(); // First iterator created // Gets first element
        for (T elt : coll) {                   // Second iterator created (for-each creates another iterator) 
                                                // Processes ALL elements including first one again
            if (candidate.compareTo(elt) < 0) 
                candidate = elt;
        }
        return candidate;
    }

    //public static<T extends Comparable <T>> T max2(Collection <T> coll)
    // <T extends Comparable<? super T>> T max(Collection <T> coll)
    public static <T extends Comparable<? super T>> T max2(Collection<? extends T> coll)
    {
        Iterator<? extends T> it = coll.iterator();   // Single iterator created // Gets first element 
        T candidate = it.next(); 
        while(it.hasNext())     // Continues with same iterator // Only processes remaining elements
        {
            T elt = it.next();
            if (candidate.compareTo(elt) < 0)
                candidate = elt;
        }
        return candidate;

    }

    public static void main(String args[]) {
        List<String> words = new ArrayList<String>();
        words.add("HELLO ");
        words.add("worlds!");
        String s = words.get(0) + words.get(1);
        assert s.equals("HELLO worlds!");
        System.out.println("tick");

        List<Integer> num = new ArrayList<Integer>();
        num.add(4);
        num.add(5);
        int res = num.get(0) + num.get(1);
        assert res == num.get(0) + num.get(1);
        System.out.println("tick 2");

        List<Integer> num3 = Arrays.asList(1, 2, 3);
        int n = 0;
        for (Integer integer : num3) {
            n += integer;
        }
        System.out.println(n);

        List<? super Integer> lop = new ArrayList<>();
        lop.add(1);
        lop.add(3);
        //  lop.add(3.1);
        assert lop.toString().equals("[1, 3]");
        System.out.println("tick 3");

        System.out.println("ticke 4");
        List<? extends Number> list2 = new ArrayList<Integer>();
        list2.add(null);
      //  int bbb = 5;
       // Number a = list2.get(0);
        // list2.add(1); // Won't compile!

        /*
         * This is why it's called PECS (Producer Extends, Consumer Super):
         * 
         * Use extends when you want to READ from the list (Producer)
         * Use super when you want to WRITE to the list (Consumer)
         */
        List<Integer> ints = Arrays.asList(1, 2, 3);
        assert sum(ints) == 6.0;

        List<Double> doubles = Arrays.asList(2.78, 3.14);
        assert sum(doubles) == 5.92
        ;

        List<Number> nums = Arrays.<Number>asList(1, 2, 2.78, 3.14);
        assert sum(nums) == 8.92;
        
        List<Integer> ints2 = new ArrayList<>();
        count(ints2, 5);
        assert ints2.toString().equals("[0,1,2,3,4]");

        List<Number> nums2 = new ArrayList<Number>();
        count(nums2,5);nums2.add(5,0);
        assert nums2.toString().equals("[0,1,2,3,4,5.0]");

        List<Object> objs = new ArrayList<Object>();
        count(objs,5);objs.add("five");
        assert objs.toString().equals("[0,1,2,3,4,five]");
        System.out.println("ticke 5");

        List<Number> nums3 = new ArrayList<Number>();
        double sum = sumCount(nums3, 5);
        assert sum == 10;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Original list: " + numbers);

        reverse(numbers);
        System.out.println("Reversed list: " + numbers);

    }
    
    
}
// https://claude.ai/chat/2318cce7-0b48-44cb-b7ef-af7f8ba9679c