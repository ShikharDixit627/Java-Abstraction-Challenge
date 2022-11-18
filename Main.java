
public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());

        //"Delhi Chandigarh Jaipur Lucknow Patna Kolkata"

        String stringData = "1 6 4 8 9 0 3";
        String[] data = stringData.split(" ");
        for (String s : data){
            list.addItem( new Node(s));
        }
        list.traverse(list.getRoot());
    }
}
