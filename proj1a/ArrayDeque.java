public class ArrayDeque<T>{
    private int size;
    private T[] items;
    private int nextFirst=0;
    private int nextLast=1;
    public static final int RFACTOR = 2;

    public ArrayDeque(){
        this(8);
    }

    public ArrayDeque(ArrayDeque other){
        size = other.size();
        items = (T[]) Object[other.size()]
        for(int i; i<other.size(); i++){
            addLast((T) other.get(i));
        }
    }

    public ArrayDeque(int capacity){
        size=0;
        items = (T[]) Object[8]
    }

    private int getIndex(int rawIndex){
        if (rawIndex<0){
            return rawIndex % items.length + items.length;
        }
        return rawIndex % items.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void resize(int newSize){
        T[] newItems = (T[]) new Object[newSize];
        for(int i=0; i<size; i++){
            newItems[i] = Items[i];
        }
        items = newItems;
        nextFirst = items.length-1;
        newLast = size;
    }

    public void addFirst(T item){
        if (size== items.length){
            resize(size*RFACTOR)
        }
        items[nextFirst] = item;
        nextFirst = getIndex(nextFirst-1);
        size+=1;
    }

    public void addLast(T item){
        if (size== items.length){
            resize(size*RFACTOR)
        }
        items[nextLast] = item;
        nextLast = getIndex(nextLast+1);
        size+=1;
    }

    public T removeFirst(){
        if (size==0){
            return null;
        }
        nextFirst = getIndex(nextFirst+1);
        T curFirst = items[getIndex(nextFirst)];
        items[getIndex(nextFirst)] = null;
        size = size-1;
        return curFirst;
    }

    public T removeLast(){
        if (size==0){
            return null;
        }
        nextLast = getIndex(nextLast-1);
        T curLast = items[getIndex(nextLast)];
        items[getIndex(nextLast)] = null;
        size = size-1;
        return curFirst;
    }

    public T get(int index){
        if (index>=size){
            return null;
        }
        return items[getIndex(nextFirst+1+index)]
    }


}