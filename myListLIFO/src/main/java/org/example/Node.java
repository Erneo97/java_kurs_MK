package org.example;

public class Node <I> {
    private final I value;
    private Node<I> next;

    public Node(I value, Node<I> next) {
        this.value = value;
        this.next = next;
    }

    public Node<I> getNext() {
        return next;
    }

    public I getValue() {
        return value;
    }

    public void setNext(Node<I> next) {
        this.next = next;
    }
}
