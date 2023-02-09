public class Node {
    private int value;
    private Node next = null;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void addValue(int value) {
        if (this.next == null) {
            this.next = new Node(value, null);
        } else {
            this.next.addValue(value);
        }
    }

    public void addNode(Node next) {
        if (this.next == null) {
            this.next = next;
            return;
        } else {
            this.next.addNode(next);
        }
    }

    public void removeLast() {
        if (this.next != null) {
        }

        // } else if (this.next.next == null) {
        // this.next = null;
        // return;
        // }
        // this.next.removeLast();
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
        return 0;
        // TODO
    }

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