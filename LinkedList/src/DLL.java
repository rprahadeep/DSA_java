// Doubly Linked List

public class DLL {
    Node head;
    Node tail;

    private int size;

    // initialise the linked-list
    DLL() {
        this.size = 0;
    }

    // to insert a node in the beginning
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }

        size = size + 1;
    }

    // to insert a node in the last
    public void insertLast(int val) {
        Node node = new Node(val);
        node.next = null;
        node.prev = tail;
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }

        size = size + 1;
    }

    // to insert at an index
    public void insertIndex(int val, int index) {
        Node node = new Node(val);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        node.prev = temp;

        if (temp.next != null) {
            temp.next.prev = node;
        }

        temp.next = node;

        size = size + 1;
    }

    // to print in reverse
    public void reverse() {
        Node node = tail;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.prev;
        }
        System.out.println();
    }

    // to print the linked list
    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
