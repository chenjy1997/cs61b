public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst = 0;
    private int nextLast = 1;
    private static final int RFACTOR = 2;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        size = other.size();
        items = (T[]) new Object[other.size()];
        for (int i = 0; i<other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    private int getIndex(int rawIndex) {
        if (rawIndex < 0){
            return rawIndex % items.length + items.length;
        }
        return rawIndex % items.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newItems[i] = get(i);
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextFirst] = item;
        nextFirst = getIndex(nextFirst - 1);
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextLast] = item;
        nextLast = getIndex(nextLast + 1);
        size += 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = getIndex(nextFirst + 1);
        T curFirst = items[getIndex(nextFirst)];
        items[getIndex(nextFirst)] = null;
        size = size - 1;
        return curFirst;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = getIndex(nextLast - 1);
        T curLast = items[getIndex(nextLast)];
        items[getIndex(nextLast)] = null;
        size = size - 1;
        return curLast;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[getIndex(nextFirst + 1 + index)];
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[getIndex(nextFirst + i + 1)] + " ");
        }
        System.out.println();
    }
}
