import java.util.*;

public class BinaryTree {
    private Node root;

    BinaryTree(){

    }

    public void populate(Scanner scanner){
        System.out.println("Enter the root node value: ");
        int val = scanner.nextInt();

        Node node = new Node(val);
        this.root = node;

        populate(scanner, node);
    }

    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter the left value of " + node.val);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the left value: ");
            int leftval = scanner.nextInt();
            node.left = new Node(leftval);
            populate(scanner,node.left);
        }

        System.out.println("Do you want to enter the right value of " + node.val);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the right value: ");
            int rightval = scanner.nextInt();
            node.right = new Node(rightval);
            populate(scanner, node.right);
        }

    }

    public void display(){
        display(root, " ");
    }

    private void display(Node node, String indent){
        if(node==null){
            return;
        }
        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");

    }


    class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

        Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
