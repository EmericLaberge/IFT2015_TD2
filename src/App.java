import javax.xml.transform.Source;

public class App {
    public static void main(String[] args) throws Exception {
        //Vous pouvez tester votre code ici!
        //Node linked = new Node(2, null);
        //linked.removeValue(2);
        //linked.print();

        File file = new File();
        for(int i = 0; i < 100; i++){
            file.push(i);
        }
        file.pop();
        file.pop();
        file.push(56);
        file.push(34);
        
        for(int i = 0; i < 97; i++){
            file.pop();
        }
        System.out.println(file.start);
        System.out.println(file.end);

        file.print();
    }
}
