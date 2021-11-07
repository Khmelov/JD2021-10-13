package by.it.shcharbunou.jd01_11;

import java.util.*;

@SuppressWarnings("unchecked")
public class SetC<T> implements Set<T> {
    private int capacity = 10;
    private int size = 0;
    private T[] elements = (T[]) new Object[capacity];

    @Override
    public boolean add(T t) {
        if (!this.contains(t)) {
            if (size == capacity - 1) {
                capacity = (capacity * 3) / 2 + 1;
                elements = Arrays.copyOf(elements, capacity);
            }
            elements[size] = t;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] collectionArray = (T[]) c.toArray();
        for (T t : collectionArray) {
            this.add(t);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (this.contains(o)) {
            for (int i = 0; i < this.size; i++) {
                if (Objects.nonNull(elements[i])) {
                    if (elements[i].equals(o)) {
                        System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                        size--;
                        return true;
                    }
                } else if (o == null) {
                    System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.nonNull(elements[i])) {
                if (elements[i].equals(o)) {
                    return true;
                }
            } else if (o == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T[] collectionArray = (T[]) c.toArray();
        for (T t : collectionArray) {
            if (!this.contains(t)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T[] collectionArray = (T[]) c.toArray();
        for (T t : collectionArray) {
            this.remove(t);
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
