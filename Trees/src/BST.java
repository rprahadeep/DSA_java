import java.util.*;

class BST{
    private Node root;

    BST(){

    }

    public Node insert(int val){
        root = insert(val, root);

        return root;
    }

    private Node insert(int val, Node root){
        if(root==null){
            Node node = new Node(val);
            return node;
        }

        if(val<root.val){
            root.left = insert(val, root.left);
        }

        if(val>root.val){
           root.right =  insert(val, root.right);
        }

        return root;
    }

    public void populate(int[] nums){
        for(int i=0;i<nums.length;i++){
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start>=end){
            return;
        }

        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.val);
        display(node.left, "Left child of " + node.val + " : ");
        display(node.right, "Right child of " + node.val + " : ");
    }

    public boolean isNull(Node node){
        return node==null;
    }

    class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }
}