// Travail réalisé par : Emeric Laberge (20220275) et Karl Desjardins (20196433)

public class App {
    public static void main(String[] args) throws Exception {
        // Vous pouvez tester votre code ici!

        // File file = new File();
        // for (int i = 0; i < 50; i++) {
        // file.push(i);
        // file.push(-1);
        // }
        // while (file.length() > 72) {
        // file.remove(-1);
        // }

        // for (int i = 0; i > -27; i--) {
        // file.push(i);
        // System.out.println("start: " + file.start + " end: " + file.end);
        // file.print();
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // }

        // Grid grid = new Grid();
        // grid.print();
        // grid.solve_game();

        Node node = new Node(2);
        node.addValue(6);
        node.addValue(1);
        node.addValue(3);
        System.out.println(node.returnNlast(-1));
        node.print();
    }
}
