package chapter9;

import my.util.DLinkedList;

public class DLinkedListQueue<T> implements Queue<T> {

    private final DLinkedList<T> list;

    public DLinkedListQueue() {
        list = new DLinkedList<>();
    }

    @Override
    public void enqueue(T item) {
        list.add(item);
    }

    @Override
    public T dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        my.util.DNode<T> n = list.removeFirst();
        if (n == null)
            throw new Exception("Queue is empty");
        return n.getData();
    }

    @Override
    public T front() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        my.util.DNode<T> n = list.get(0);
        if (n == null)
            throw new Exception("Queue is empty");
        return n.getData();
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
