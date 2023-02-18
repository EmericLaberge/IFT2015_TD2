import java.nio.channels.OverlappingFileLockException;

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
    private Cell croixPlayer;

    public Grid() {
        nbreRangee = 3;
        nbreColonnes = 4;
        CreerGrid(nbreRangee, nbreColonnes);
    }

    private void CreerGrid(int rangee, int colonnes) {
        Cell next;
        Cell first = new Cell(0);
        for (int i = 0; i < rangee; i++) {
            Cell previous = first;
            for (int j = 0; j < colonnes - 1; j++) {
                next = new Cell(1);
                next.celluleGauche = previous; 
                previous.celluleDroite = next;
                previous = next;
            }
            if(i != rangee - 1){
                
            }
        }
        head = first;
    }

    public void print(){
        System.out.println(head.valeur);
        System.out.println(head.celluleDroite.valeur);
        System.out.println(head.celluleDroite.celluleDroite.valeur);
        System.out.println(head.celluleDroite.celluleDroite.celluleDroite.valeur);
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
