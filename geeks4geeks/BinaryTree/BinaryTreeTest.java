package BinaryTree;

public class BinaryTreeTest {

    public static void main(String [] args){
         BinaryTree btree = new BinaryTree();

         for(int i=1;i<8; i++) {
             btree.insert(i);
         }

        BinaryTree.Node temp = btree.root;
         //btree.BFS();
     //    BinarySearchTree.Node temp1 = btree.searchEle(temp, 7);
       //  if(temp1 != null){
       //      System.out.println("Search element found "+temp1.data);
        // } else {
        //     System.out.println("Search Not element found ");
        // }

         //btree.preorder(temp);
         //btree.preOrderWithoutRecursion();
        //btree.BFS();

        //System.out.println("post order elements are ");
        //btree.postorder(temp);
        //btree.postOrderWithoutRecursion();

        //boolean mirror = btree.isSymetric(temp);
        //if(mirror){
          //  System.out.println("Tree is mirror");
        //}else{
         //   System.out.println("Tree is NOT mirror");
        //}

        //btree.spiralPrint(temp);
        //btree.levelOrderLinebyLine(temp);
        //btree.modifyTreeToPreodrderRightSubtree(temp);
        //btree.preorder(temp);
       // btree.NthNodeInPostOrder(temp, 5, 0);

        //TODO: moris tree traversal
        //btree.printBoundryOfTree(temp);
       // int h = btree.heightFromInorder(temp, 1,1);
        //System.out.println("Height of tree ="+h);

        //BinarySearchTree.Node rightTree = btree.modifyTreeToPreodrderRightSubtree(temp);
        //btree.preorder(temp);
        //BinarySearchTree.Node tree1 = btree.dllToTree(rightTree);
        //btree.preorder(tree1);

        //converting btree to DLL is same as modifyTreeToPreodrderRightSubtree
        //BinarySearchTree.Node prev = null;
        //btree.inorderSuccessor(temp,1, prev);
      // btree.morrisInorderTraversal(temp);

        btree.BFS();

        BinaryTree.Node temp1 = btree.root;
        btree.searializeBtree(temp1);
    }
}
