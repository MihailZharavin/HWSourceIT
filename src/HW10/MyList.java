package HW10;

import java.util.List;

public interface MyList<E> extends Iterable<Object> {
    public void add(E e);

    public int sizes();

    public Object[] toArrays();

    public boolean contains(Object o);

    boolean containsAll(MyList<E> c);

    boolean remove(E o);

    void clears();
}
