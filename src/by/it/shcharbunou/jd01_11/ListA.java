package by.it.shcharbunou.jd01_11;

import java.util.*;

@SuppressWarnings("all")
public class ListA<T> implements List<T> {
    private int capacity = 10;
    private int size = 0;
    private T[] elements = (T[]) new Object[capacity];

    @Override
    public boolean add(T t) {
        if (size == capacity - 1) {
            capacity = (capacity * 3) / 2 + 1;
            elements = Arrays.copyOf(elements, capacity);
        }
        elements[size] = t;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < size && index > -1) {
            return elements[index];
        }
        System.out.println("Error: Incorrect index. (ArrayOutOfBoundException, broski ;)");
        return null;
    }

    @Override
    public T remove(int index) {
        if (index < size && index > -1) {
            T deletedElement = elements[index];
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            size--;
            return deletedElement;
        }
        System.out.println("Error: Incorrect index. (ArrayOutOfBoundException, broski ;)");
        return null;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            out.add(String.valueOf(elements[i]));
        }
        return out.toString();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
