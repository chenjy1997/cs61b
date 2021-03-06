public class LinkedListDeque<T> {

    public class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(){
            item = null;
            prev = null;
            next = null;
        }

        public Node(T i, Node p, Node n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private Node sentinel;
    private int size;
    /* constructors */
    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(i));
        }
    }

    public void addFirst(T item) {
        Node itemNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = itemNode;
        sentinel.next = itemNode;
        size = size + 1;
    }
    public void addLast(T item) {
        Node itemNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = itemNode;
        sentinel.prev = itemNode;
        size = size + 1;
    }
    public T removeFirst() {
        Node first = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = Math.max(0, size - 1);
        return first.item;
    }
    public T removeLast() {
        Node last = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size = Math.max(0, size - 1);
        return last.item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node cur = sentinel.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.item;
    }
    public T getRecursive(int index) {
        if (index >= size){
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }
    private T getRecursiveHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }

    public int size(){
        return size;
    }

    public void printDeque() {
        Node first = sentinel.next;
        while (first != sentinel) {
            System.out.print(first.item + " ");
            first = first.next;
        }
        System.out.println();
    }
    public boolean isEmpty(){
        return size == 0;
    }
}