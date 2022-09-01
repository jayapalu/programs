package BinaryTree;

public class BsTTest {

    public static void main(String [] args){
        System.out.println("BST Test is called");

        int a[] = new int[]{40,35,70,37,80,36};
        BST tree = new BST();

        for(int i=0;i<a.length; i++) {
            tree.insert(a[i]);
        }

        Node root = tree.root;
        System.out.println("Inorder traversal");
        tree.inorder(root);
        System.out.println("Preorder traversal");
        tree.preorder(root);

        /*
        int pre[] = new int[]{10,20,5,2,3};
        int [] b = new int[10];

        Node node1 = tree.constructTreeFromPreOrder(pre, pre.length);
        System.out.println("new Preorder traversal");
        tree.preorder(node1);
        if(tree.isBST(node1, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            System.out.println();
            System.out.println("Is BST");
        }else{
            System.out.println();
            System.out.println("Is NOT BST");
        }
        */
//
//        Node node1 = tree.lca(root, 7,8);
//        if(node1 != null){
//            System.out.println("LCA is "+node1.data);
//        }

//        Node temp = tree.root;
//        tree.sumOfAllGreaterKeys(temp);

        Node temp = tree.root;
    }
}
