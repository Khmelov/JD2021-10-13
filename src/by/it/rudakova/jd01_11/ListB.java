package by.it.rudakova.jd01_11;


import java.util.*;

public class ListB <T> implements List<T>{

    private T[] elements=(T[])new Object[]{};
    private int size=0;


    @Override
    public boolean add(T t) {
        if(size==elements.length)
            elements= Arrays.copyOf(elements,(size*3)/2+1);
        elements[size]=t;
        ++size;
        return false;
    }

    @Override
    public void add(int index, T element) {
        if(size==elements.length)
            elements= Arrays.copyOf(elements,(size*3)/2+1);
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index]=element;
        size++;

    }
    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0) {
            return null;
        }
        else if (index >= size) {
            return null;
        }
        else{
            T returnedElem=elements[index];
        this.elements[index]=element;
            return returnedElem;
        }
    }

    @Override
    public T remove(int index) {
        T  deletedElement=elements[index];
        System.arraycopy(elements,index+1,elements,index,size-1-index);
        size--;
        return deletedElement;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[");
        String delimiter="";
        for(int i=0;i<size;i++){
            stringBuilder.append(delimiter).append(elements[i]);
            delimiter=", ";
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T [] newArray =(T[])c.toArray();
        int numbersElem=newArray.length;
        if(numbersElem==0){
            return false;
        }
        if(numbersElem>elements.length-size)
           numbersElem=newArray.length+elements.length;
        elements= Arrays.copyOf(elements,numbersElem);
        System.arraycopy(newArray,0,elements,size,newArray.length);
        size=size+newArray.length;
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }
    @Override
    public boolean remove(Object o) {
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
    public int indexOf(Object o) {
        if(o==null){
            for(int i=0;i<size;i++){
                if(elements[i]==null){
                    return i;
                }
            }
        }

        else{
            for(int i=0;i<size;i++){
                if(o.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
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
}
