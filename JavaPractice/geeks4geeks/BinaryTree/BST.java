package BinaryTree;
class Node{
    int data;
    Node left;
    Node right;

    Node(int ele){
        this.data = ele;
        this.left=null;
        this.right=null;
    }
}

public class BST {
    Node root;

    void insert(int ele) {
        //System.out.println("BST insertion is called");

        if (root == null) {
            root = new Node(ele);
            return;
        }

        Node cur = root;
        Node prev = cur;

        while (cur != null) {
            prev = cur;
            if (ele < cur.data) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        Node node1 = new Node(ele);

        if (ele < prev.data) {
            prev.left = node1;
        } else {
            prev.right = node1;
        }
    }

    void inorder(Node cur) {

        if (cur == null) {
            return;
        }

        inorder(cur.left);
        System.out.print(" " + cur.data);
        inorder(cur.right);
    }

    void preorder(Node cur) {

        if (cur == null) {
            return;
        }

        System.out.print(" " + cur.data);
        preorder(cur.left);
        preorder(cur.right);
    }

    void postorder(Node cur) {

        if (cur == null) {
            return;
        }

        postorder(cur.left);
        postorder(cur.right);
        System.out.print(" " + cur.data);
    }

    class Index {
        int index = 0;
    }

    // {10, 5, 1, 7, 40, 50}
    Node constructTreeFromPreOrder(int pre[], int size) {

        int low = 0, high = size - 1;
        Index index = new Index(); // it for storing the reference
        return constructTreeFromPreOrderUtil(pre, index, low, high, size);
        //return constructTreeFromPreOrderUtil1(pre, 0, low, high, size);
    }

    Node constructTreeFromPreOrderUtil(int pre[], Index preIndex, int low, int high, int size) {

        if (low > high || preIndex.index >= size) { //{10,5,1,7,40,50};
            return null;
        }

        //set first element to root as it is preorder
        Node node = new Node(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;
        //go to the next root
        int i = low;
        for (; i <= high; ++i) {
            if (pre[i] > node.data) {
                break;
            }
        }

        //{5,1,7}
        node.left = constructTreeFromPreOrderUtil(pre, preIndex, preIndex.index, i - 1, size);
        //{40,50}
        node.right = constructTreeFromPreOrderUtil(pre, preIndex, i, high, size);
        return node;
    }

    Node constructTreeFromPreOrderUtil1(int pre[], int preIndex, int low, int high, int size) {

        if (low > high || preIndex >= size) {
            return null;
        }

        //set first element to root as it is preorder
        Node node = new Node(pre[preIndex]);
        //preIndex = preIndex + 1;
        //go to the next root
        int i = low;
        for (; i <= high; ++i) {
            if (pre[i] > node.data) {
                break;
            }
        }

        //{5,1,7}
        node.left = constructTreeFromPreOrderUtil1(pre, low + 1, low, i - 1, size);
        //{40,50}
        node.right = constructTreeFromPreOrderUtil1(pre, preIndex, i, high, size);
        return node;
    }

    //test case: 10,20,5,2,3
    //
    boolean isBST(Node cur, int min, int max) {
        if (cur == null) {
            return true;
        }

        boolean left = cur.left == null ? true : cur.left.data < cur.data && cur.left.data > min;
        boolean right = cur.right == null ? true : cur.right.data > cur.data && cur.right.data < max;

        if (!(left == true && right == true)) {
            return false;
        }

        if (isBST(cur.left, min, cur.data) && isBST(cur.right, cur.data, max)) {
            return true;
        }
        return false;
    }

    /*
    Input:
33
31 5 15 24 8 2 19 1 30 21 29 13 28 6 20 26 3 4 23 17 11 16 10 14 27 9 18 32 12 7 25 22 33
20 1

Its Correct output is:
5
     */
    Node lca(Node node, int n1, int n2) {

        // if the given input n1 is greater
        if (n1 > n2) {
            int temp;
            temp = n1;
            n1 = n2;
            n2 = temp;
        }

        if (node == null) {
            return null;
        }

        if (n1 == node.data || n2 == node.data) {
            return node;
        }

        if (n1 < node.data && n2 > node.data) {
            return node;
        }

        if (n1 < node.data && n2 < node.data) {
            return lca(node.left, n1, n2);
        } else {
            return lca(node.right, n1, n2);
        }
    }

    class sum {
        int total = 0;

        sum() {
            this.total = 0;
        }
    }

    void sumOfAllGreaterKeys(Node cur) {
        sum s = new sum();
        reverseInorderSum(cur, s);
    }


    void reverseInorderSum(Node cur, sum s) {
        if (cur == null) {
            return;
        }

        reverseInorderSum(cur.right, s);
        cur.data=cur.data + s.total;
        s.total=cur.data;       // * here total will be the node only
        System.out.print(" " + cur.data);
        reverseInorderSum(cur.left,s );
    }

    void sumOfAllSmallerKeys(Node cur) {
        sum s = new sum();
        InorderSumOfSmallerKeys(cur, s);
    }

    void InorderSumOfSmallerKeys(Node cur, sum s) {
        if (cur == null) {
            return;
        }

        InorderSumOfSmallerKeys(cur.left, s);
        cur.data=cur.data + s.total;
        s.total=cur.data;       // * here total will be the node only
        System.out.print(" " + cur.data);
        InorderSumOfSmallerKeys(cur.right,s );

    }

    /*

left subtree:
Node.left should be less than parent and less than its parent parent
Node.right should be greater than parent and less than left subtree.

 */
    public boolean isValidBST(BinaryTree.Node node, int min, int max){

        if(node.left == null && node. right == null){
            return true;
        }

        System.out.println("node.data = "+node.data + " min="+min + " Max= "+max);

        // node should be in min and max limits. it is not then return false.

        if(node.data <= min || node.data >= max) {
            return false;
        }

//        if(node.left != null && node.left.data > node.data && node.right != null && node.right.data < node.data) {
//            return false;
//        }else if (node.right == null && node.left.data > node.data) {
//            return false;
//        }else if (node.left == null && node.right.data < node.data) {
//            return false;
//        }

        if (!isValidBST(node.left, min, root.data) ||  !isValidBST(node.right, node.data, max)) {
            return false;
        }
        return true;
    }




}//class

