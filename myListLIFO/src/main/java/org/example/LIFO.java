package org.example;

public class LIFO <I> {
    private Node<I> head = null;
    private int size = 0;

    public void add(I value) {
        head = new Node<>(value, head);
        size++;
    }

    public I pop() {
        if (size <= 0) {
            return null;
        }
        I returnValue = head.getValue();
        head = head.getNext();
        size--;
        return returnValue;
    }

    public I remove(I searched) {
        if (this.size <= 0) {
            return null;
        }
        Node<I> temporary = head;

        if (head.getValue().equals(searched)) {
            size--;
            head = head.getNext();
            return temporary.getValue();
        }

        while (temporary.getNext() != null) {
            if (temporary.getNext() != null && temporary.getNext().getValue().equals(searched)) {
                I returnValue = temporary.getNext().getValue();
                temporary.setNext(temporary.getNext().getNext());
                size--;
                return returnValue;
            }
            temporary = temporary.getNext();
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        Node<I> temporary = head;
        while (temporary != null) {
            buffer.append(temporary.getValue()).append(" ");
            temporary = temporary.getNext();
        }
        return buffer.toString();
    }
}