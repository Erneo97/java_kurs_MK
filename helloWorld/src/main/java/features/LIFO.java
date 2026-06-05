package features;


public class LIFO {
    private Node head = null;
    private int size = 0;

    public void add(int value) {
        Node newNode = new Node(value, head);
        head = newNode;
        size++;
    }

    public Integer pop() {
        if (size <= 0) {
            return null;
        }
        int retValue = head.getValue();
        head = head.getNext();
        size--;
        return retValue;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            buffer.append(temp.getValue()).append(" ");
            temp = temp.getNext();
        }
        return buffer.toString();
    }
}
