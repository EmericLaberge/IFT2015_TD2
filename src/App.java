
public class App {
    public static void main(String[] args) throws Exception {
        // Vous pouvez tester votre code ici!
        // Node linked = new Node(2, null);
        // linked.removeValue(2);
        // linked.print();

        File file = new File();
        for (int i = 0; i < 50; i++) {
            file.push(i);
            file.push(-1);
        }
        while (file.length() > 72) {
            file.remove(-1);
        }

        // file.print();

        for (int i = 0; i > -27; i--) {
            file.push(i);
            System.out.println("start: " + file.start + " end: " + file.end);
            file.print();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        // while (file.search(-1)) {
        // file.remove(-1);
        // System.out.println();
        // file.print();
        // System.out.println();
        // System.out.println("============================================================");
        // }
        // Grid grid = new Grid();
        // grid.solve_game();
        // grid.print();

        Grid grid = new Grid();
        grid.print();
        grid.solve_game();
    }
}
