package chapter9;

import my.util.DLinkedList;

public class DLinkedListStack<T> implements Stack<T> {

    private final DLinkedList<T> list;

    public DLinkedListStack() {
        list = new DLinkedList<>();
    }

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        my.util.DNode<T> n = list.removeLast();
        if (n == null)
            throw new Exception("Stack is empty");
        return n.getData();
    }

    @Override
    public T top() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        my.util.DNode<T> n = list.get(list.size() - 1);
        if (n == null)
            throw new Exception("Stack is empty");
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
