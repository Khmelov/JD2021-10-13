package by.it.antipov.jd01_11;

import java.util.*;

public class SetC <T> implements Set {
    private T [] elements = (T[]) new Object[0];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){return true;}
        return false;
    }

    @Override
    public boolean contains(Object o) {
        int removeIndex = -1;
        for (int i = 0; i < size ; i++) {if (Objects.nonNull(elements[i])){if (elements[i].equals(o)) { removeIndex=i;}}else {if (elements[i]==o) { removeIndex=i;}}}

        if (removeIndex==-1) {return false;}
        return true;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        int k=0;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {k++;}
            }
        if (k<1){elements= Arrays.copyOf(elements,size*3/2+1);elements[size]= (T) o;

            size++;

        }
        return k < 1;
        }

    @Override
    public boolean remove(Object o) {
        int removeIndex = -1;
        for (int i = 0; i < size ; i++) {
            if (Objects.nonNull(elements[i])){if (elements[i].equals(o)) { removeIndex=i;}}else {if (elements[i]==o) { removeIndex=i;}}}
        if (removeIndex==-1) {return false;}
        for (int j =removeIndex; j < size-1; j++) {
            elements[j]=elements[j+1];
        }
        elements=Arrays.copyOf(elements,size-1);
        size--;
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] elements2=  c.toArray();
        for (Object element:elements2) {
            this.add(element);

        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i]=null;
        }
        size=0;
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] elements2=  c.toArray();
        for (Object element:elements2) {
            this.remove(element);

        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        int k =0;
        T[] elements2= (T[]) c.toArray();
        for (Object element:elements2) {
          if (this.contains(element)) {k++;} }
        if (k==elements2.length){return  true;}
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        String delimiter = "";
        out.append("{");
        out.append(delimiter);
        for (int i = 0; i <size; i++) {out.append(delimiter);out.append(elements[i]);delimiter=","; }
        out.append("}");
        return out.toString();
    }
}
