package HW10;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        DefaultMyList<Integer> frstlist = new DefaultMyList<>();
        frstlist.add(1);
        frstlist.add(2);
        frstlist.add(3);
        frstlist.add(4);
        frstlist.add(5);
        frstlist.add(6);

        for (Object o:frstlist
                ) {
            System.out.println(o + " ");
        }
        System.out.println(" ");

        DefaultMyList<String> scndlist = new DefaultMyList<>();

        scndlist.add("Who");
        scndlist.add("Am");
        scndlist.add("I");
        Iterator<Object> iter = scndlist.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println(" ");
        ListIterator iter2 = scndlist.listIterator();
        while(iter2.hasPrevious()){
            System.out.println(iter2.previous());
        }
    }
}
