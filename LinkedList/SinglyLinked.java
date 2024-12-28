public class SinglyLinked {
  public static void main(String[] args) {
    LL list = new LL();
    list.insertFirst(0);
    list.insertLast(1);
    list.insertLast(2);
    list.insertLast(4);
    list.insert(3, 3);

    list.display();

    list.deleteIndex(3);

    list.display();
  }
}

class LL {

  Node head;
  Node tail;

  private int size;

  // initialise the linked-list
  LL() {
    this.size = 0;
  }

  // to insert a new node in front
  public void insertFirst(int val) {
    Node node = new Node(val);
    node.next = head;
    head = node;

    if (tail == null)
      tail = head;

    size = size + 1;
  }

  // to insert a node in the end
  public void insertLast(int val) {
    Node node = new Node(val);
    tail.next = node;
    tail = node;

    size = size + 1;
  }

  // to insert at a position p
  public void insert(int val, int pos) {
    Node temp = head;
    for (int i = 0; i < pos - 1; i++) {
      temp = temp.next;
    }
    Node node = new Node(val, temp.next);
    temp.next = node;

    size = size + 1;
  }

  // to delete last element
  public void deleteLast() {
    Node temp = head;
    for (int i = 0; i < size - 2; i++) {
      temp = temp.next;
    }
    temp.next = null;
    tail = temp;

    size = size - 1;
  }

  // to delete an element at an index
  public void deleteIndex(int index) {
    Node temp = head;
    for (int i = 0; i < index - 1; i++) {
      temp = temp.next;
    }
    temp.next = temp.next.next;

    size = size - 1;
  }

  // to print the linked list
  public void display() {
    Node start = head;
    while (start != null) {
      System.out.print(start.val + " ");
      start = start.next;
    }
    System.out.println();
  }

  // to print size of the linked list
  public int size() {
    return size;
  }

  class Node {
    int val;
    Node next;

    Node(int value) {
      this.val = value;
    }

    Node(int value, Node nextNode) {
      this.val = value;
      this.next = nextNode;
    }
  }
}
