public class File {
    public int[] elements;
    public int start;
    public int end;

    public File() {
        elements = new int[100];
        start = 0;
        end = 0;
        return;
    }

    // Fonction tirer des notes de cours
    public int size(){
        return (end - start + elements.length) % elements.length;
    }

    // Status: Works ?(PS: not sure it works)
    // Can we use .length ?
    public void push(int element) {
        if (this.size() != elements.length) {
            elements[end] = element;
            if (end % elements.length == end) {
                end++;
            } else {
                end = 0;
            }
        }
    }

    public int pop() {
        int tmp;
        if (end - start != -1) {
            tmp = elements[start];
            elements[start] = 0;
            start++;
            if (start % elements.length != start) {
                start = 0;
            }
            System.out.println(start);
            System.out.println(end);
            return tmp;
        }
        return 0;
    }

    // Status : Works!
    public int length() {
        if (start == end) {
            return size();
        } else {
            if (end - start == -1) {
                return 0;
            } else {
                return end - start;
            }
        }
    }

    public void print() {
        String word = "(";
        if (start > end) {
            for (int i = start; i < elements.length; i++) {
                word = word + elements[i] + ",";
            }
        }
        for (int i = 0; i < end; i++) {
            if (i == end - 1) {
                word = word + elements[i];
            } else {
                word = word + elements[i] + ",";
            }
        }
        word += ")";
        System.out.println(word);
        return;
    }

    public boolean search(int element) {
        boolean estDansListe;
        for (int i = 0; i < elements.length; i++) {
            if (this.pop() == element) {
                estDansListe = true;
            }
        }
        // if (estDansListe) {
        // for (int i = 0; i < elements.length; i++) {
        // this.push(this.pop());
        // }
        // }
        return false;
    }

    public void remove(int value) {
        return;
    }
}
