public class Grid {
    public class Cell {

        private String valeur;
        private Cell celluleHaut;
        private Cell celluleDroite;
        private Cell celluleBas;
        private Cell celluleGauche;

        public Cell(String valeur) {
            this.valeur = valeur;
            celluleHaut = null;
            celluleDroite = null;
            celluleGauche = null;
            celluleBas = null;
            return;
        }
    }

    // TODO

    public Grid() {
        // TODO
    }

    public boolean move(Cell box) {
        // TODO
        return true;
    }

    public boolean check_complete() {
        // TODO
        return true;
    }

    public void solve_game() {
        // TODO
    }
}
