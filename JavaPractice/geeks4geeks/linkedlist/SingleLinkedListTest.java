package linkedlist;

public class SingleLinkedListTest {

    public static void main(String [] args ) {
        LinkedLIst l1 = new LinkedLIst("list1 ");
        l1.insert(1);
        l1.insert(2);
        l1.insert(3);
        l1.insert(4);
        l1.insert(5);
        l1.insert(6);
        //l1.insert(7);

        l1.printlist();

        l1.head = l1.swapNodesInpairs(l1.head);
        l1.printlist();
        /*
        l1.deleteNode(3);
        l1.insertAtFront(0);
        l1.printlist();

        l1.IsloopDetected();

        //creating a loop in list
        l1.setLoopAtEle(2);

        l1.IsloopDetected();
        //return the loop node and print the ele
        System.out.println("Loop is at node " + l1.loopNode().data);
        */

        //swap two nodes
        //l1.swapTwoNodes(0,1);
        //l1.printlist();

        //l1.swapAdjacentNodes();
        //l1.printlist();

        LinkedLIst l2 = new LinkedLIst(" list2 ");
        l2.insert(3);
        l2.insert(5);
        l2.insert(7);
        l2.insert(10);
        l2.insert(15);
       // l2.printlist();

        //LinkedLIst l3 = l1.interSectionOfTwoSortedList(l1.head, l2.head);
        //l3.printlist();


    }
}
