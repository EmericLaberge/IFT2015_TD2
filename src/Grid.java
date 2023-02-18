import java.util.Random;

public class Grid {
    public class Cell {

        private int valeur;
        private Cell celluleHaut;
        private Cell celluleDroite;
        private Cell celluleBas;
        private Cell celluleGauche;

        public Cell(int valeur) {
            this.valeur = valeur;
            celluleHaut = null;
            celluleDroite = null;
            celluleGauche = null;
            celluleBas = null;
            return;
        }
    }

    private int nbreRangee;
    private int nbreColonnes;
    private Cell head;

    public Grid() {
        nbreRangee = 3;
        nbreColonnes = 4;
        CreerGrid(nbreRangee, nbreColonnes);
    }

    private void CreerGrid(int rangee, int colonnes) {
        // Cell next;
        // Cell first = new Cell(0);
        // for (int i = 0; i < rangee; i++) {
        // Cell previous = first;
        // for (int j = 0; j < colonnes - 1; j++) {
        // next = new Cell(1);
        // next.celluleGauche = previous;
        // previous.celluleDroite = next;
        // previous = next;
        // }
        // if(i != rangee - 1){
        //
        // }
        // }
        // head = first;

        // Shuffle le array pour avoir un jeu randomize,
        // J'ai pris ce code d'internet parce que on evalue
        // comment creer un grid pas comment faire un shuffle,
        // https://www.digitalocean.com/community/tutorials/shuffle-array-java

        int[] array = { -1, 25, 10, 10, 10, 10, 5, 5, 1, 1, 1, 1 };

        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }

        Cell[] tabCell = { new Cell(0),
                new Cell(0),
                new Cell(0),
                new Cell(0),
                new Cell(0),
                new Cell(0),
                new Cell(0),
                new Cell(0),
                new Cell(0),
                new Cell(0),
                new Cell(0),
                new Cell(0) };

        for (int i = 0; i < tabCell.length; i++) {
            tabCell[i].valeur = array[i];
        }

        for (int i = 0; i < tabCell.length; i++) {
            System.out.println(tabCell[i].valeur);
        }

        for (int i = 0; i < tabCell.length; i++) {

        }
    }

    public void print() {
    }

    public boolean move(Cell box) {

        if (box != null) {
            if (box.valeur == -1) {
                box.valeur = 1;
                return true;
            }
            if (box.celluleBas.valeur == -1) {
                box.celluleBas.valeur = box.valeur;
                box.valeur = -1;
                return true;
            }
            if (box.celluleDroite.valeur == -1) {
                box.celluleDroite.valeur = box.valeur;
                box.valeur = -1;
                return true;
            }
            if (box.celluleGauche.valeur == -1) {
                box.celluleGauche.valeur = box.valeur;
                box.valeur = -1;
                return true;
            }
            if (box.celluleHaut.valeur == -1) {
                box.celluleHaut.valeur = box.valeur;
                box.valeur = -1;
                return true;
            }
            return false;
        }
        System.out.println("La cellule n'existe pas");
        return false;
    }

    public boolean check_complete() {
        Cell current = head;
        while (current != null) {
            if (current.celluleBas.celluleBas.valeur != current.valeur) {
                return false;
            }
            current = current.celluleDroite;
        }
        return true;
    }

    public void solve_game() {
        // TODO
    }
}
