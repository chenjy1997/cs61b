public class LinkedListDeque{

    public class Node{
        public Item item;
        public Node prev;
        public Node next;

        public Node(){
            item = null;
            prev = null;
            next = null;
        }

        public Node(Item i, Node p, Node n){
            item = i;
            next = n;
            prev = p;
        }
    }

    private Node sentinel;
    private int size;
    /* constructors */
    public LinkedListDeque(){
        sentinel = Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public LinkedListDeque(LinkedListDeque other){
        sentinel = Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        for (int i=0; i<other.size; i++){
            sentinel.
        }
    }

    public void addFirst(Item item){
        Node itemNode = Node(item, sentinel, sentinel.next);
        sentinel.next.prev = itemNode;
        sentinel.next = itemNode;
        size = size+1;
    }
    public void addLast(Item item){
        Node itemNode = Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = itemNode;
        sentinel.prev = itemNode;
        size = size+1;
    }
    public Item removeFirst(){
        first = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = Math.max(0, size-1);
        return first.item;
    }
    public Item removeLast(){
        last = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size = Math.max(0, size-1);
        return last.item;
    }

    public Item get(int index){
        if (index>=size){
            return null;
        }
        Node cur = sentinel.next;
        for (int i=0; i<index; i++){
            cur = cur.next;
        }
        return cur.item
    }
    public Item getRecursive(int index){
        if (index>=size){
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }
    private Item getRecursiveHelper(int index, Node node){
        if (index==0){
            return node.item;
        }
        return getRecursiveHelper(index-1, node.next);
    }

    public int size(){
        return size
    }
}