public class App {
    public static void main(String[] args) throws Exception {
        // Vous pouvez tester votre code ici!
        Node linked = new Node(2, null);
        linked.addValue(1);
        linked.addValue(4);
        linked.addValue(6);
        linked.addValue(7);
        linked.addValue(9);
        linked.removeValue(6);
        linked.print();
    }
}
