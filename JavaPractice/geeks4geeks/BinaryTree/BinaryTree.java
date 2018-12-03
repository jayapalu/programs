package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {

    Node root = null;
     class Node {
        int data;
        Node left;
        Node right;

        public Node(int ele){
            this.data = ele;
            this.left = null;
            this.right = null;
        }
    }

    void insert(int ele) {
        if (root == null) {
            System.out.println("Tree root is null creating root");
            root = new Node(ele);
        } else {
            Node temp=root;
            Queue<Node> q = new LinkedList<Node>();
            q.add(temp);


            while (!q.isEmpty()) {
                temp = q.peek();
                q.remove();

                if (temp.left == null) {
                    temp.left = new Node(ele);
                    break;
                } else {
                    q.add(temp.left);
                }

                if (temp.right == null) {
                    temp.right = new Node(ele);
                    break;
                } else {
                    q.add(temp.right);
                }

            }
        }
    } // insert method


    void printTree() {
         System.out.println(" preorder tree elements are");
         Node temp = root;
         preorder(temp);
    }

    void preorder(Node temp){
        if(temp == null){
            return;
        }
        System.out.println(temp.data);
        preorder(temp.left);
        preorder(temp.right);
    }

    void postorder(Node temp){
        if(temp == null){
            return;
        }
        postorder(temp.left);
        postorder(temp.right);
        System.out.println(temp.data);
    }

    void inorder(Node temp){
        if(temp == null){
            return;
        }
        inorder(temp.left);
        System.out.println(temp.data);
        inorder(temp.right);
    }

    void inorderIterative(Node cur){
        System.out.println("This is inorder iterative");
        Stack<Node> s = new Stack<Node>();
        if(cur == null){
            return;
        }
        s.add(cur);
        while(!s.isEmpty()) {

            while (cur != null) {
                cur = cur.left;
                if(cur != null) {
                    s.add(cur);
                }
            }

            Node left = s.pop();
            System.out.print(" " + left.data);

            if (left.right != null) {
                s.add(left.right);
                cur = left.right;
            } else {
                cur = null;
            }
        }
     }


    //element search
    Node searchEle(Node temp, int ele){

         if(temp == null) {
             return null;
         }

         if(temp.data == ele){
             return temp;
         }

         /*
         searchEle(temp.left, ele);
         searchEle(temp.right, ele);
         return temp;
         */

         Node found = null;
         found = searchEle(temp.left, ele);
         if(found == null) {
             found = searchEle(temp.right, ele);
         }else{
             return found;
         }
         return found;
    }

    //delete node
    void deleteNode(int ele){

    }

    void preOrderWithoutRecursion() {
        System.out.println("preOrderWithoutRecursion Recursion:");
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        if (temp != null) {
            stack.push(temp);
        }

        while (!stack.isEmpty()) {
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }

            System.out.println(" " + temp.data);
            temp = stack.pop();
        }
    }


    void postOrderWithoutRecursion() {
        System.out.println("postOrderWithoutRecursion Recursion:");
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        Node prev = null;
        if (temp != null) {
            stack.push(temp);
        }

        while (!stack.isEmpty()) {
            temp=stack.peek();
            //leaf node
            if(temp.left == null && temp.right == null){
                System.out.println(" " + temp.data);
                prev = stack.pop();
                continue;
            }

            //leaf node
            if(temp.left == null){
                System.out.println(" " + temp.data);
                prev = temp;
                temp = stack.pop();
            }

            if(prev != null && (temp.left == prev || temp.right == prev)){
                prev=stack.pop();
                System.out.println(" " + temp.data);
                continue;
            }

            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }

        }
    }

    // BFS traversal
    void BFS() {
         System.out.println("BFS traversal tree elements");
         Node temp = root;
         Queue<Node> q = new LinkedList<Node>();
         q.add(root);

         while(!q.isEmpty()){
             temp = q.peek();
             q.remove();
             System.out.println(temp.data);
             if(temp.left != null){
                 q.add(temp.left);
             }

             if(temp.right != null){
                 q.add(temp.right);
             }

         }
    }

    boolean isSymetric(Node root){
         return isMirror(root, root);
    }

    boolean isMirror(Node node1, Node node2){

         if(node1 == null && node2 == null){
             return true;
         }

         //if(node1 != null && node2 != null && (node1.data == node2.data)){
        if(node1 != null && node2 != null){
             return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
         }

         return  false;
    }

    void spiralPrint(Node node) {
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();

        stack2.add(node);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack2.empty()) {
                Node temp = stack2.pop();
                if(temp.right != null) {
                    stack1.add(temp.right);
                }
                if(temp.left != null) {
                    stack1.add(temp.left);
                }
                System.out.println(temp.data + " ");
            }

            while (!stack1.empty()) {
                Node temp = stack1.pop();
                if(temp.left != null) {
                    stack2.add(temp.left);
                }
                if(temp.right != null) {
                    stack2.add(temp.right);
                }
                System.out.println(temp.data + " ");
            }
        }
    }

    void levelOrderLinebyLine(Node temp){
         System.out.println("levelOrderLinebyLine");

         Queue<Node> q = new LinkedList<Node>();
         int count=1;
         q.add(temp);

         while(!q.isEmpty()){
             int count2=0;
             for(int i=0; i<count; i++){
                 temp=q.peek();
                 q.remove();
                 if(temp.left != null) {
                     q.add(temp.left);
                     count2++;
                 }
                 if(temp.right != null) {
                     q.add(temp.right);
                     count2++;
                 }
                 System.out.print(temp.data+" ");
             }
             System.out.println(" ");
             count=count2;
         }
    }

    //https://www.geeksforgeeks.org/modify-binary-tree-get-preorder-traversal-using-right-pointers/

    Node modifyTreeToPreodrderRightSubtree(Node node){
        System.out.println("modifyTreeToPreodrderRightSubtree called");

         Node prev = null;
         Stack<Node> stack = new Stack<Node>();
         stack.add(node);

         while(!stack.isEmpty()){

             Node temp1 = stack.peek();
             stack.pop();

             if(temp1.right != null){
                 stack.push(temp1.right);
             }
             if(temp1.left != null){
                 stack.push(temp1.left);
             }

             if(prev != null){
                 prev.right=temp1;
                 prev.left=null;
             }
             prev=temp1;
         }
         return  node;
    }

    int NthNodeInPostOrder(Node node, int n, int flag){
         if(node == null){
             return flag;
         }

         if(flag<n) {
             if(node.left != null) {
                 flag = NthNodeInPostOrder(node.left, n, flag);
             }
             if(node.right != null) {
                 flag = NthNodeInPostOrder(node.right, n, flag);
             }

             flag++;
             if(flag == n){
                 System.out.println(n +"th ele is "+node.data);
             }
         }
         return flag;
    }

    void printBoundryOfTree(Node root) {

         // print left side nodes
        //   print  leaf nodes
        //   print right side nodes
        Node node=root;
        Node temp = root;

        while( node.left != null && node.right != null){
            System.out.print(node.data + " ");
            node=node.left;
        }

        preorderLeafNode(temp);
        printRightBoundryInReverse(root);
    }

    void preorderLeafNode(Node temp){
         if(temp == null){
             return;
         }

         if(temp.left == null && temp.right == null){
             System.out.print(temp.data + " ");

         }
         preorderLeafNode(temp.left);
         preorderLeafNode(temp.right);
    }

    void printRightBoundryInReverse(Node node){

         if(node.left == null && node.right == null){
             return;
        }
        printRightBoundryInReverse(node.right);
        System.out.print(node.data + " ");
    }

    int heightFromInorder(Node node, int height, int level){

         if(node == null)
             return height;

         height = heightFromInorder(node.left, height, level+1);
         if(height < level){
             height=level;
         }
         height = heightFromInorder(node.right, height, level+1);
         return  height;
    }

    Node dllToTree(Node node){

         if(node == null){
             return null;
         }

         Queue<Node> q = new LinkedList<Node>();
         q.add(node);

         Node tree = node;
         Node lchild;
         node=node.right; //this is important here because in first pass move it by by so that
        //in next iteration move by two will be correct.
        // In first pass there is root, lchild and rchild come from dll. In 2nd iteration parent come from q.

         while(node != null){
             Node temp=q.peek();
             q.remove();

             Node rchild=null;
             lchild = node;

             if(lchild !=null && lchild.right != null){
                 rchild = lchild.right;
             }

             if(rchild == null){
                 node = null;
             }else {
                 node = rchild.right;
             }

             temp.left=lchild;
             temp.right=rchild;

             if (lchild != null){
                 lchild.right = null;
             }

             if(rchild != null) {
                 rchild.right = null;
             }

             q.add(lchild);
             q.add(rchild);
         }
         return tree;
    }

    /*

Case 1:
    left leaf most node:
            predessessor is null
            Sucessor is parent.

case 2:
     left right most leaf node:
            predecessor is parent
            Successor is root
case 3:
     non leaf node:
            predecessor: left -> right mode most node
     */

    Node rightMostNode(Node node){
         Node temp = node;
         //case two
         while(temp.right != null){
             temp=temp.right;
         }
         return temp;
    }


    Node leftmostNode(Node node){
        Node temp = node;
        //case 1 leaf node


        while(temp.left != null){
            temp=temp.right;
        }
        return temp;
    }


/*
Inorder Successor:
Case 1:
Right child of the node is NOT NULL
    left most node of the right child

case 2:
Right child of the node is NULL.
    keep find the parent p such that p.left = x

 */

// works but needs modification
void inorderSuccessor(Node temp, int x, Node prev){

    if(temp == null){
        return;
    }

    inorderSuccessor(temp.left,x, prev);
    if(temp.data == x){
        prev=temp;
    }
    inorderSuccessor(temp.right,x, prev);

    if (prev !=null && prev.data == x && prev != temp){
        System.out.println("Successor "+temp.data);
        prev=null;
    }
}

void inOrderSuccessorOfBinaryTree(Node temp, int x, Node prev){


    if(temp.right != null){
        inOrderSuccessorOfBinaryTree(temp.right, x, prev);
    }

    if(temp.data == x){
        System.out.println("Successor of  " + x + " is: "
            + (prev != null ? prev.data : "null"));
    }


    if(temp.left != null){
        inOrderSuccessorOfBinaryTree(temp.left, x, prev);
    }
    prev=temp;
}

void morrisInorderTraversal(Node node){
    Node current = node;
    while(current != null){

        if(current.left == null){
            //print the node
            System.out.println(current.data);
            current = current.right;
        } else {
            Node pred = predecessorForMorris(current);
            if(pred.right == null){
                pred.right = current;
                current=current.left;
            } else{
                pred.right = null;
                System.out.println(current.data);
                current=current.right;

                ArrayList<Integer> a = new ArrayList<Integer>();
                a.size();

            }
        }
    }
}

Node predecessorForMorris(Node node){
    Node node1 = node.left;
    while(node1 != null && node1.right != null){
        if(node1.right == node){
            return node1;
        }
        node1=node1.right;
    }
    return node1;
}

void searializeBtree(Node cur){
    // do level order tree traversal and print -1 if the node does not have childs.

}

} //class








