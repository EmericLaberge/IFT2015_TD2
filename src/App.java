import javax.xml.transform.Source;

public class App {
    public static void main(String[] args) throws Exception {
        //Vous pouvez tester votre code ici!
        //Node linked = new Node(2, null);
        //linked.removeValue(2);
        //linked.print();

        //File file = new File();
        //for(int i = 0; i < 100; i++){
        //    file.push(i);
        //}
        //file.remove(0);

        //file.print();

        Grid grid = new Grid();
        grid.print();
        grid.solve_game();
    }
}
