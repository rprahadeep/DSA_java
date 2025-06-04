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

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    public List<Integer> levelOrder(){
        List<Integer> result = new ArrayList<>();
        if(this.root==null) return result;

        Queue<Node> q = new LinkedList<>();
        q.offer(this.root);

        while(!q.isEmpty()){
            int l = q.size();
            for(int i=0;i<l;i++){
                Node current = q.poll();
                result.add(current.val);
                if(current.left!=null){
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }
            }
        }
        return result;
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
