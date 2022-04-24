package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLizt<T>{
    private T[] arrayData;
    private int size;
    private static final double formFactor = 0.75;
    private static final double extendFactor = 1.5;
    private static final int startArraySizeFactor = 10;

    public ArrayLizt(T[] arrayData) {
         createArrayDataRule(arrayData.length);

        for(int x = 0; x < arrayData.length; x++){
            this.arrayData[x] = arrayData[x];
        }
        size = arrayData.length;
    }

    public ArrayLizt(ArrayLizt<T> otherArrayData) {
        createArrayDataRule(otherArrayData.size);

        for(int x = 0; x < arrayData.length; x++){
            this.arrayData[x] = otherArrayData.get(x);
        }
        size = otherArrayData.size();
    }

    private void createArrayDataRule(int length) {
        if(length < startArraySizeFactor * formFactor)
            this.arrayData = (T[])new Object[startArraySizeFactor];
        else
            this.arrayData = (T[])new Object[(int) (length * extendFactor)];
    }

    public ArrayLizt(){
        this.arrayData = (T[])new Object[startArraySizeFactor];
    }

    public ArrayLizt(int length) {
        this.arrayData = (T[]) new Object[length];
    }



    public T get(int num){
        if(num < 0 || num >= size)
            throw new IndexOutOfBoundsException("Element " + num + " can't be taken becuse size = " + size + "!");

        return arrayData[num];
    }

    public void add(T t){

        int newSize = firstNullElement();

        if(newSize > arrayData.length * formFactor){
            innerExtenceMethod(newSize);
            return;
        }
        arrayData[newSize] = t;
        size += 1;
    }

    private int firstNullElement() {
        int newSize = 0;
        for(int x = 0; x < arrayData.length; x++){
            if(arrayData[x] == null){
                newSize = x;
                break;
            }
        }
        return newSize;
    }

    public int size(){
        return size;
    }

    public void addAll(ArrayLizt<T> lizt){
        int totalLiztSize = lizt.size + this.size;
        merge(totalLiztSize, lizt);
    }

    public void addAll(ArrayList<T> list){
        int totalLiztSize = list.size() + this.size;
        merge(totalLiztSize, list);

    }

    private void merge(int totalLiztSize, Object list) {
        if (totalLiztSize > arrayData.length * formFactor){
            innerExtenceMethod(totalLiztSize);
        }

        int firstElementAfterLastInArrayData = firstNullElement();
        for(int x = firstElementAfterLastInArrayData, y = 0; x < totalLiztSize; x++, y++){
            if(list instanceof ArrayLizt) listInnerAdd((ArrayLizt<T>) list, x, y);
            if(list instanceof ArrayList) listInnerAdd((ArrayList<T>) list, x, y);
        }
        size = totalLiztSize;
    }

    private void listInnerAdd(ArrayLizt<T> list, int x, int y){
        arrayData[x] = list.get(y);
    }

    private void listInnerAdd(ArrayList<T> list, int x, int y){
        arrayData[x] = list.get(y);
    }

    private void innerExtenceMethod(int totalLiztSize){
        T[] neoArrayData = (T[])new Object[(int) (totalLiztSize * extendFactor)];
        for(int x = 0; x < arrayData.length; x++){
            neoArrayData[x] = arrayData[x];
        }
        arrayData = neoArrayData;
    }

    public T remove(int num){
        if(num < 0 || num >= size)
            throw new IndexOutOfBoundsException("Element " + num + " can't be romoved becuse size = " + size + "!");

        T element = arrayData[num];
        for(int x = num; x < arrayData.length - 1; x++){
            arrayData[x] = arrayData[x + 1];
        }
        arrayData[size - 1] = null;
        size -= 1;
        return element;
    }

    public void clear(){
        arrayData = (T[])new Object[size];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ArrayLizt. size = " + size + ", [");
        if(size != 0){
            for(T t : arrayData){
                if(t == null) break;
                builder.append(t).append(", ");
            }
            builder = new StringBuilder(builder.substring(0, builder.length() - 2));
        }
        builder.append("]");
        return builder.toString();
    }
}
