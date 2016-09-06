import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Naveen Kumar .A on 9/6/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item> {
        public Item item;
        public Node<Item> next;
        public Node<Item> previous;

        public Node(Item item) {
            this.item = item;
        }
    }

    public Deque() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException("null item not allowed");
        }
        Node<Item> node = new Node<>(item);
        if (!isEmpty()) {
            node.next = first;
            first.previous = node;
        } else {
            last = node;
        }
        first = node;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException("null item not allowed");
        }
        Node<Item> node = new Node<>(item);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
            node.previous = last;

        }
        last = node;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("No item to remove");
        }
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("No item to remove");
        }
        Item item = last.item;
        if(size ==1){
            first = null;
            last = null;
        }else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (current == null) {
                    throw new NoSuchElementException("No elements");
                }
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addFirst(2);
        deque.addLast(3);
        System.out.println(deque.removeLast());
        for (int i : deque){
            System.out.println(i);
        }
    }

}

