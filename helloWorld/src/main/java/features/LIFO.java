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
        int returnValue = head.getValue();
        head = head.getNext();
        size--;
        return returnValue;
    }

    public Integer remove(Integer searched) {
        if (this.size <= 0) {
            return null;
        }
        Node temporary = head;

        if (head.getValue() == searched) {
            size--;
            head = head.getNext();
            return temporary.getValue();
        }

        while (temporary.getNext() != null) {
            if (temporary.getNext() != null && temporary.getNext().getValue() == searched) {
                Integer returnValue = temporary.getNext().getValue();
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
        Node temporary = head;
        while (temporary != null) {
            buffer.append(temporary.getValue()).append(" ");
            temporary = temporary.getNext();
        }
        return buffer.toString();
    }
}