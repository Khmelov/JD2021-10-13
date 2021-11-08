package by.it.marukovich.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;


public class ListB<E> implements List<E> {

    private E[] elements = (E[]) new Object[0];

    private int size = 0;

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size] = e;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        E returnValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return returnValue;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        if (index <0){
            return null;
        }
        else if (index >= size){
            return null;
        } else {
            E returnedElement = elements[index];
            this.elements[index] = element;
            return returnedElement;
        }
    }

    @Override
    public void add(int index, E element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E [] newArray =(E[])c.toArray();
        int numbersElements=newArray.length;
        if(numbersElements==0){
            return false;
        }
        if(numbersElements>elements.length-size)
            numbersElements=newArray.length+elements.length;
        elements= Arrays.copyOf(elements,numbersElements);
        System.arraycopy(newArray,0,elements,size,newArray.length);
        size=size+newArray.length;
        return false;
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
        return 0;
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
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
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
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {

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
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }
}
