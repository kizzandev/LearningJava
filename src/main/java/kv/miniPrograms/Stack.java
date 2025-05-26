package kv.miniPrograms;

import java.util.ArrayList;

// Last In First Out
public class Stack<E> {
    private final ArrayList<E> els;

    public Stack() {
        els = new ArrayList<>();
    }

    public void push (E element) {
        els.add(element);
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return els.removeLast();
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return els.getLast();
    }

    public boolean isEmpty() {
        return els.isEmpty();
    }

    public int size() {
        return els.size();
    }

    public void clear() {
        els.clear();
    }

    @Override
    public String toString() {
        return els.toString();
    }
}
