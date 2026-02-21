package chapter9;

import java.util.ArrayList;

public class SortedArrayListPriorityQueue<T> implements PriorityQueue<T> {

    private static class Entry<T> implements Comparable<Entry<T>> {
        final int priority;
        final T data;
        Entry(int priority, T data) {
            this.priority = priority;
            this.data = data;
        }

        @Override
        public int compareTo(Entry<T> o) {
            return this.priority - o.priority;
        }
    }

    private final ArrayList<Entry<T>> list;

    public SortedArrayListPriorityQueue() {
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(int priority, T data) {
        // insert so list is sorted by priority ASC (lower number is higher priority)
        Entry<T> e = new Entry<>(priority, data);
        if (list.isEmpty()) {
            list.add(e);
            return;
        }
        int i = 0;
        while (i < list.size() && list.get(i).priority <= priority) {
            i++;
        }
        // insert before the first element with greater priority
        list.add(i, e);
    }

    @Override
    public T dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("PriorityQueue is empty");
        return list.remove(0).data;
    }

    @Override
    public T front() throws Exception {
        if (isEmpty())
            throw new Exception("PriorityQueue is empty");
        return list.get(0).data;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
