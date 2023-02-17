public class File {
    public int[] elements;
    public int start;
    public int end;

    public File() {
        elements = new int[101];
        start = 0;
        end = 0;
        return;
    }

    // Fonction tirée des notes de cours
    public int size() {
        return (end - start + elements.length) % elements.length;
    }

    // Status: Works ?(PS: not sure it works)
    // Can we use .length ?
    public void push(int element) {
        if (this.size() == elements.length - 1) {
            // throw IllegalStateException;
            System.out.println("La file est pleine!");
        } else {
            elements[end] = element;
            end = (end + 1) % elements.length;
        }
    }

    public int pop() {
        if (this.size() == 0) {
            System.out.println("Tu ne peux pas pop une liste vide!");
            return 0;
        } else {
            int elementToPop = elements[start];
            elements[start] = 0;
            start = (start + 1) % elements.length;
            return elementToPop;
        }
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
                if (i == elements.length - 1) {
                    word = word + elements[i];
                } else {
                    word = word + elements[i] + ",";
                }
            }
            if(end > 0){
                word += ",";
            }
            for (int i = 0; i < end; i++) {
                if (i == end - 1) {
                    word = word + elements[i];
                } else {
                    word = word + elements[i] + ",";
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (i == end - 1) {
                    word = word + elements[i];
                } else {
                    word = word + elements[i] + ",";
                }
            }
        }
        word += ")";
        System.out.println(word);
        return;
    }

    public boolean search(int element) {
        boolean estDansListe = false;
        int x = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            x = this.pop();
            if (x == element) {
                estDansListe = true;
            }
            this.push(x);
        }
        return estDansListe;
    }

    public void remove(int value) {
        return;
    }
}
