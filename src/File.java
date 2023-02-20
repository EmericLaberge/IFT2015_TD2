// Travail réalisé par : Emeric Laberge (20220275) et Karl Desjardins (20196433)

public class File {
    public int[] elements;
    public int start;
    public int end;
    private int maxSize = 100;
    private boolean lastIsPop = true;

    public File() {
        elements = new int[maxSize];
        start = 0;
        end = 0; // Le rear doit indexer immédiatement après le dernier élément
        return;
    }

    // Status: Works ?(PS: not sure it works)
    // Can we use .length ?
    public void push(int element) {
        if (this.length() != maxSize) {
            elements[end] = element;
            end = (end + 1) % maxSize;
            this.lastIsPop = false;
        } else {
            throw new RuntimeException("La file est déjà remplie au maximum!");
        }
    }

    public int pop() {
        if (!this.estVide()) {
            int element = elements[start];
            start = (start + 1) % maxSize;
            this.lastIsPop = true;
            return element;
        } else {
            throw new RuntimeException("On ne peut pas pop une file est vide!");
        }
    }

    public int length() {
        if (start == end && this.lastIsPop == false) {
            return 100;
        } else {
            return (end - start + maxSize) % maxSize;
        }
    }

    public boolean estVide() {
        return this.length() == 0;
    }

    public void print() {
        if (!this.estVide()) {
            System.out.print("(");
            for (int i = 0; i < this.length() - 1; i++) {
                int current = this.pop();
                System.out.print(current + ", ");
                this.push(current);
            }
            int current = this.pop();
            System.out.print(current + ")");
            this.push(current);
        }

    }

    public boolean search(int value) {
        boolean estDansListe = false;
        int current;
        for (int i = 0; i < this.length(); i++) {
            current = this.pop();
            if (current == value) {
                estDansListe = true;
            }
            this.push(current);
        }
        return estDansListe;
    }

    public void remove(int value) {
        boolean alreadyFound = false;
        if (this.estVide()) {
            return;
        }
        int currentSize = this.length();
        for (int i = 0; i < currentSize; i++) {
            int current = this.pop();
            if (current == value && !alreadyFound) {
                alreadyFound = true;
            } else {
                this.push(current);
            }
        }
    }
}
