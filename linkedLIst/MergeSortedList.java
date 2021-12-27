
public class MergeSortedList {


     static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    static void insert(Node head, int ele) {
        Node n1 = new Node(ele);
        if (head == null) {
            head = n1;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n1;
        }
    }

    static void printlist(Node head) {

        if(head == null) {
            return;
        }
        System.out.println(head.val);
        printlist(head.next);
        return;
    }

    public static void main(String[] args){
        Node head1 = new Node(8);
        insert(head1, 7);
        insert(head1,  9 );

        plusOne(head1, 0);
        printlist(head1);

        Node head2 = new Node(3);
        insert(head2, 4);
        insert(head2, 16);
        insert(head2, 20);
        System.out.println("print list2");
        printlist(head2);

        System.out.println("print after merge");
        Node result = mergeSortedListsWithOutDuplicates(head1, head2);
        printlist(result);
    }

    public static Node mergeSortedListsWithOutDuplicates(Node l1, Node l2 ) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

         if(l1.val <= l2.val) {
            l1.next = mergeSortedListsWithOutDuplicates(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeSortedListsWithOutDuplicates(l1, l2.next);
            return l2;
        }
    }



    // l1 and l2 may contain same value nodes. final list contains duplicates.
    public static Node mergeSortedListsWithDuplicates(Node l1, Node l2 ) {

        Node dummyHead = new Node(-1);
        Node prev = dummyHead;
        // in this we are attaching nodes from l1 and l2 to the prev. This will be separate list.
        //travers two lists
        while(l1 != null && l2 != null){
            //if l1.val is less then attach the list to the prev
            if(l1.val <= l2.val){
                prev.next = l1;
                l1=l1.next;
            }else {
                //attach l2 list to the prev
                prev.next = l2;
                l2=l2.next;
            }
            //move the prev
            prev=prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

     static int plusOne(Node node, int carry) {

        if(node == null) {
            return 1;
        }

        int res = plusOne(node.next, 0);

        if(node.val + res == 10) {
            node.val = 0;
            return 1;
        }
         node.val = node.val  + res;
        return 0;
    }
}