import javax.xml.transform.Source;

public class App {
    public static void main(String[] args) throws Exception {
        //Vous pouvez tester votre code ici!
        //Node linked = new Node(2, null);
        //linked.addValue(1);
        //linked.addValue(4);
        //linked.addValue(6);
        //linked.addValue(5);
        //linked.addValue(9);
        //linked.insertSort();
        //linked.print();

        File file = new File();
        for(int i = 0; i < 100; i++){
            file.push(i);
        }
        file.pop();
        file.pop();
        file.push(167);
        file.print();
    }
}
