public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.reverse();

        list.display();

    }
}