package HW10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyList<E> implements MyList<E >,ListIterable {
    public static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private boolean g = false;
    private boolean g1 =false;
    int cursor =0;
    int lastElement;

    public DefaultMyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity){
        if(minCapacity-elements.length>0){
            increace(minCapacity);
        }
    }
    private void increace(int minCapacity) {
        int oldCapacity = elements.length;
        int newCapacity = (oldCapacity * 3) / 2 + 1;
        if (newCapacity > 0 && newCapacity > oldCapacity) {
            Arrays.copyOf(elements, newCapacity);
        }

    }
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elements[index];
    }


    @Override
    public void add(E e) {
        ensureCapacity(size+1);
        elements[size++]= e;
        lastElement++;
    }

    @Override
    public int sizes() {
        return this.size;
    }

    @Override
    public Object[] toArrays() {

        return Arrays.copyOf(elements,size);
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0;i<sizes();i++){
            if(elements[i].equals(o)){
                g= true;
            }
        }
        return g;
    }

    @Override
    public boolean containsAll(MyList<E> c) {
        boolean proverka = true;
        if(sizes()==0){
            return false;
        }
        for(int i=0;i<sizes();i++){
            DefaultMyList<E> pr = (DefaultMyList<E>) c;
            proverka = contains(pr.get(i));
        }
        return proverka;
    }

    @Override
    public boolean remove(E o) {
        int index = Arrays.asList(elements).indexOf(o);
        int newLength = size-index-1;
        System.arraycopy(elements,index+1,elements,index,newLength);
        elements[--size]=null;
        return true;
    }

    @Override
    public void clears() {
        for(int i=0;i<size;i++){
            elements[i]=null;
        }
        size = 0;
    }
    private class IteratorImpl implements Iterator<Object> {
        @Override
        public void remove() {
            DefaultMyList.this.remove((E) elements[lastElement-1] );
            cursor--;
            lastElement--;
        }


        @Override
        public boolean hasNext() {
            return cursor!=size;
        }

        @Override
        public Object next(){
            if(cursor >=size) {
                throw new NoSuchElementException();
            }
            Object[] elIter = DefaultMyList.this.elements;
            Object nextElement = elIter[cursor];
            cursor++;
            return nextElement;
        }
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }
    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        @Override
        public boolean hasPrevious() {
            return cursor!=0;
        }

        @Override
        public Object previous() {
            if(cursor<0){
                throw new NoSuchElementException();
            }
            Object[] elpIter = DefaultMyList.this.elements;
            Object previousElement =elpIter[cursor-1];
            --cursor;
            return  previousElement;
        }

        @Override
        public void set(Object e) {
            elements[size-1] = e;
        }
    }
}
