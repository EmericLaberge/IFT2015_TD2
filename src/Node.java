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

    // Status : WORKS!
    public void addValue(int value) {
        if (this.next == null) {
            this.next = new Node(value);
        } else {
            this.next.addValue(value);
        }
    }

    // Status : WORKS!
    public void addNode(Node next) {
        if (this.next == null) {
            this.next = next;
            return;
        } else {
            this.next.addNode(next);
        }
    }

    // Status : WORKS!
    public void removeLast() {
        if (this.next == null) {
            System.out.println("Un seul element dans la liste , ne peut etre enlever!");
            return;
        }
        if (this.next.next != null) {
            this.next.removeLast();
        } else {
            this.next = null;
        }

        // A voir !!
        // } else if (this.next.next == null) {
        // this.next = null;
        // return;
        // }
        // this.next.removeLast();
    }

    // Status : Works except cant remove first element
    public void removeValue(int value) {
        if (this.next.next == null && this.next.value == value) {
            this.next = null;
        } else {
            if (this.next.value == value) {
                Node nodeToRemove = this.next;
                this.next = this.next.next;
                nodeToRemove.next = null;
            } else {
                this.next.removeValue(value);
            }
        }
        // if (this.next != null) {
        // if (this.next.value == value && this.next.next != null) {
        // this.next = this.next.next;
        // } else {
        // this.next = null;
        // }
        // }
        // } else if (this.next.value == value) {
        // while (this.next.next.value == value) {
        // this.next = this.next.next;
        // }
        // }
        // this.next.removeValue(value);

        // if(this.value == value){
        // this = this.next;
        // }
    }

    // Status : WORKS!
    public int length_iteratif() {
        int length = 0;
        Node current = this;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        return length + 1;
    }

    // Status : WORKS!
    public int length_recurssion() {
        Node current = this;
        if (current.next == null) {
            return 1;
        }
        if (current.next != null) {
            return 1 + current.next.length_recurssion();
        }
        return 0;
    }

    // public int length_recurssion() {
    // if (this.next != null) {
    // this.next = this.next.next;
    // return 1 + length_recurssion();
    // }
    // return 0;
    // }

    // Status : WORKS !
    public int returnNlast(int nLast) {
        Node current = this;
        int compteur = 1;
        while (current.value != nLast && current.next != null){ 
            current = current.next;
            ++compteur;
        }
        return compteur;
    }

    // Status : Works !!
    public void addValue_ordered(int value) {
        int nodeValue = this.value;
        if (value < nodeValue) {
            int tmp = nodeValue;
            this.value = value;
            value = tmp;
            this.next = new Node(value, this.next);
            return;
        } else {
            if (this.next == null) {
                this.next = new Node(value, null);
            } else {
                this.next.addValue_ordered(value);
            }
        }
    }

    public void insertSort() {
        int length = this.length_recurssion();
    }

    // Une fonction pour voir la linked list.
    public void print() {
        String word = "(";
        Node current = this;
        if (current.next == null) {
            word += current.value + " -> null)";
        } else {
            while (current != null) {
                if (current.next.next == null) {
                    word += current.value + "-> " + current.next.value + "-> null )";
                    break;
                }
                word += current.value + "-> ";
                current = current.next;
            }
        }
        System.out.print(word);
    }
}
