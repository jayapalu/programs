import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    public Node (int data) {
        this.data = data;
        left = null;
        right = null;
    }

}



public class Btree {

    static Node root;
    static Node temp = root;

    Btree () {
        root = null;
    }

    Btree(int data) {
        root = new Node(data);
    }

    static void inorder(Node node) {

        if (node == null) {
            return ;
        }

        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }


    static void preorder(Node node) {

        if (node == null) {
            return ;
        }

        System.out.println(node.data);
        inorder(node.left);
        inorder(node.right);
    }

    //add elements into the binary tree.
    //For adding the elements into the binary tree do level order traversing that is inorder
    //use queue for traversing.

    static void insert(Node temp, int data) {

        Queue<Node> q = new LinkedList<Node>();

        q.add(temp);

        while(!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            }else {
                q.add(temp.left);
            }

            if (temp.right == null){
                temp.right = new Node(data);
                break;
            } else {
                q.add(temp.right);
            }
        }

    }

    public static Node insert2(Node root,int data) {

        if(root == null){
            return new Node(data);
        }

        if(data<= root.data){
            if(root.left == null){
                root.left = new Node(data);
                return root;
            }
            insert2(root.left, data);
        } else {
            if(root.right == null){
                root.right = new Node(data);
                return root;
            }
            insert2(root.right, data);
        }
        return root;
    }

    public static Node insert3(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert3(root.left, data);
                root.left = cur;
            } else {
                cur = insert3(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    static void levelorder(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.isEmpty()){
            Node temp = q.peek();
            q.remove();
            System.out.println(temp.data + " ");

            if(temp.left != null){
                q.add(temp.left);
            }

            if(temp.right != null){
                q.add(temp.right);
            }
        }
    }


    public static int height(Node root) {
        // Write your code here.
        if(root == null){
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);
        return 1+max(l,r);
    }

    static int max(int a, int b){
        if(a>=b){
            return a;
        }else{
            return b;
        }
    }

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.

        if(v1 <= root.data && v2 > root.data){
            return root;
        }else if(v1 >= root.data && v2 < root.data){
            return root;
        }else if(v1 < root.data) {
            return lca(root.left, v1, v2);
        }
        return lca(root.right, v1, v2);



    }

    public static void main (String [] args) {

       // Btree tree = new Btree();
       // root = new Node(1);
        //root.left = new Node(2);
        //root.right = new Node(3);

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert2(root, data);
        }
        //scan.close();

        //inorder(root);
        //insert(root, 4);
        inorder(root);
        //System.out.println("printing preorder");
        //preorder(root);
        //System.out.println(height(root));
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();

        Node ans = lca(root, v1,v2);
        System.out.println(ans.data);

        scan.close();
    }
}
