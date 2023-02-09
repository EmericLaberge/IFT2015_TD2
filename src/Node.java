public class Node {
    private int value;
    private Node next = null;

    public Node(int value) {
        this.value = value;
        // TODO
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
        // TODO
    }

    public void addValue(int value) {
        addNode(new Node(value));
        // TODO
    }

    public void addNode(Node next) {
        if (this.next == null) {
            this.next = next;
            return;
        }
        this.next.addNode(next);
        // TODO
    }

    public void removeLast() {
        if (this.next == null) {// FIXME
        } else if (this.next.next == null) {
            this.next = null;
            return;
        }
        this.next.removeLast();
        // TODO
    }

    public void removeValue(int value) {
        if (this.next == null) {
            return;
        } else if (this.next.value == value) {
            while (this.next.next.value == value) {
                this.next = this.next.next;
            }
        }
        this.next.removeValue(value);

        // TODO
    }

    public int length_iteratif() {
        int length = 0;
        while (this.next != null) {
            this.next = this.next.next;
            length++;

        }
        // TODO
        return length;
    }

    public int length_recurssion() {
        if (this.next != null) {
            this.next = this.next.next;
            return 1 + length_recurssion();
        }
        // TODO
    }

    ic

    int returnNlast(int nLast) {
        // TODO
        return 0;
    }

    public void addValue_ordered(int value) {
        // TODO
    }

    public void insertSort() {
        // TODO
    }
}