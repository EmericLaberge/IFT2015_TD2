import java.util.Random;

public class Grid {
    public class Cell {

        public int valeur;
        public Cell celluleHaut;
        public Cell celluleDroite;
        public Cell celluleBas;
        public Cell celluleGauche;

        public Cell(int valeur) {
            this.valeur = valeur;
            celluleHaut = null;
            celluleDroite = null;
            celluleGauche = null;
            celluleBas = null;
            return;
        }

    }

    public int nbreRangee;
    public int nbreColonnes;
    public Cell head;

    public Grid() {
        nbreRangee = 3;
        nbreColonnes = 4;
        CreerGrid(nbreRangee, nbreColonnes);
    }

    private void CreerGrid(int rangee, int colonnes) {

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

        // Fonction pour print avant les assignations de references.
        // for (int i = 0; i < tabCell.length; i++) {
        // System.out.print(tabCell[i].valeur);
        // System.out.print(" -> ");
        // if ((i + 1) % 4 == 0) {
        // System.out.println(" ");
        // }
        // }

        assignerCelluleAuGrid(tabCell, 0, 4, false);
        assignerCelluleAuGrid(tabCell, 4, 8, true);
        assignerCelluleAuGrid(tabCell, 8, 12, false);

        head = tabCell[0];
    }

    public void assignerCelluleAuGrid(Cell[] tableau, int indiceDebut, int indiceFin, boolean relierHautBas) {
        for (int i = indiceDebut; i < indiceFin; i++) {
            if (relierHautBas) {
                tableau[i].celluleHaut = tableau[i - indiceDebut];
                tableau[i - indiceDebut].celluleBas = tableau[i];
                tableau[i].celluleBas = tableau[i + indiceDebut];
                tableau[i + indiceDebut].celluleHaut = tableau[i];
            }
            if (i == indiceDebut) {
                tableau[i].celluleDroite = tableau[i + 1];
            } else {
                if (i == indiceFin - 1) {
                    tableau[i].celluleGauche = tableau[i - 1];
                } else {
                    tableau[i].celluleGauche = tableau[i - 1];
                    tableau[i].celluleDroite = tableau[i + 1];
                }
            }
        }
    }

    // Fonction print pour voir le jeu
    public void print() {
        String word = "";
        Cell current = head;

        // Premiere rangee
        for (int i = 0; i < 4; i++) {
            word = word + current.valeur + " -> ";
            if (current.celluleDroite != null) {
                current = current.celluleDroite;
            }
        }

        // On descend a la 2e.
        current = head.celluleBas;
        word += "\n";

        // Deuxieme rangee
        for (int i = 0; i < 4; i++) {
            word = word + current.valeur + " -> ";
            if (current.celluleDroite != null) {
                current = current.celluleDroite;
            }
        }

        // On descend vers la derniere rangee
        current = head.celluleBas.celluleBas;
        word += "\n";

        // Troisieme rangee
        for (int i = 0; i < 4; i++) {
            word = word + current.valeur + " -> ";
            if (current.celluleDroite != null) {
                current = current.celluleDroite;
            }
        }
        System.out.println("___________________");
        System.out.println(word);
    }

    public boolean move(Cell box) {

        if (box != null) {
            if (box.celluleBas != null && box.celluleBas.valeur == -1) {
                box.celluleBas.valeur = box.valeur;
                box.valeur = -1;
                return true;
            }
            if (box.celluleDroite != null && box.celluleDroite.valeur == -1) {
                box.celluleDroite.valeur = box.valeur;
                box.valeur = -1;
                return true;
            }
            if (box.celluleGauche != null && box.celluleGauche.valeur == -1) {
                box.celluleGauche.valeur = box.valeur;
                box.valeur = -1;
                return true;
            }
            if (box.celluleHaut != null && box.celluleHaut.valeur == -1) {
                box.celluleHaut.valeur = box.valeur;
                box.valeur = -1;
                return true;
            }
            return false;
        }
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

    public Cell findX() {
        int valeurDuX = -1;
        Cell current = head;

        for (int i = 0; i < 4; i++) {
            if (current.valeur == valeurDuX) {
                return current;
            }
            if (current.celluleDroite != null) {
                current = current.celluleDroite;
            }
        }

        current = head.celluleBas;

        for (int i = 0; i < 4; i++) {
            if (current.valeur == valeurDuX) {
                return current;
            }
            if (current.celluleDroite != null) {
                current = current.celluleDroite;
            }
        }

        current = head.celluleBas.celluleBas;

        for (int i = 0; i < 4; i++) {
            if (current.valeur == valeurDuX) {
                return current;
            }
            if (current.celluleDroite != null) {
                current = current.celluleDroite;
            }
        }

        return null;
    }

    public void solve_game() {
        int random;
        Cell celluleVide = findX();
        while (!check_complete()) {

            random = (int) (Math.random() * 4 + 1);

            switch (random) {
                case 1:
                    if (this.move(celluleVide.celluleHaut)) {
                        celluleVide = celluleVide.celluleHaut;
                    }
                    break;
                case 2:
                    if (this.move(celluleVide.celluleDroite)) {
                        celluleVide = celluleVide.celluleDroite;
                    }
                    break;
                case 3:
                    if (this.move(celluleVide.celluleBas)) {
                        celluleVide = celluleVide.celluleBas;
                    }
                    break;
                case 4:
                    if (this.move(celluleVide.celluleGauche)) {
                        celluleVide = celluleVide.celluleGauche;
                    }
                    break;
            }
        }
        System.out.println("------------------");
        this.print();
    }
}
