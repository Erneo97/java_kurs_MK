package features;

public class LIFO {
    private Node head = null;
    private int size = 0;

    public void add(Integer value) {
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

    public Integer remove(Integer searched) {
        if (this.size <= 0) {
            return null;
        }
        Node temp = head;

        if (head.getValue() == searched) {
            size--;
            head = head.getNext();
            return temp.getValue();
        }

        while (temp.getNext() != null) {
            if (temp.getNext() != null && temp.getNext().getValue() == searched) {
                Integer retValue = temp.getNext().getValue();
                temp.setNext(temp.getNext().getNext());
                size--;
                return retValue;
            }
            temp = temp.getNext();
        }
        return null;
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