
import com.util.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Naveen Kumar .A on 9/6/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int len;
    private int limit;

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        limit = 2;
        arr = (Item[]) new Object[limit];
        len = 0;

    }

    public boolean isEmpty() {
        return len == 0;
    }

    public int size() {
        return len;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (len == limit)
            resize(limit * 2);

        arr[len++] = item;
    }

    public Item dequeue() {
        Item res;
        if (len == 0)
            throw new NoSuchElementException();
        int i = StdRandom.uniform(len);
        res = arr[i];
        swap(i, len - 1);
        arr[len - 1] = null;
        len--;
        if (len < limit / 4)
            resize(limit / 2);
        return res;
    }

    public Item sample() {
        if (len == 0)
            throw new NoSuchElementException();
        int i = StdRandom.uniform(len);
        return arr[i];
    }

    public Iterator<Item> iterator() {
        return new rqiterator();
    }

    private class rqiterator implements Iterator<Item> {
        private int cur = 0;
        private int[] order;

        public rqiterator() {
            order = new int[len];
            for (int i = 0; i < len; i++)
                order[i] = i;
            for (int i = len - 1; i > 0; i--) {
                swap(i, StdRandom.uniform(i + 1));
            }
        }

        public boolean hasNext() {
            return cur < len;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (cur >= len)
                throw new NoSuchElementException();
            return arr[order[cur++]];
        }

        private void swap(int i, int j) {
            int tmp = order[i];
            order[i] = order[j];
            order[j] = tmp;
        }
    }

    private void swap(int i, int j) {
        Item tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @SuppressWarnings("unchecked")
    private void resize(int after) {
        if (after == limit)
            return;
        Item[] tmp = (Item[]) new Object[after];
        if (after > limit) {
            for (int i = 0; i < limit; i++)
                tmp[i] = arr[i];
        } else if (after >= len) {
            for (int i = 0; i < after; i++)
                tmp[i] = arr[i];
        }
        limit = after;
        arr = tmp;
    }
}
