
  //Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class OddEvenList328 {

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenHead = new ListNode();
        evenHead.next = even;

        while(odd !=null && odd.next != null){
            //odd is odd position nodes, even is even position nodes
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead.next;
        return head;

    }
        // this solution has problem for the terminating condition
        public ListNode oddEvenList1(ListNode head) {

            if(head == null) {
                return null;
            }

            ListNode lastNode = head;;

            while(lastNode.next != null) {
                lastNode = lastNode.next;
            }

            // lastNode pointing to the last node of the list

            // now we need to move alternate node to the end

            //alternate node pointer from 1st node onwards
            ListNode firstAltNodePtr = head;

            //alternate node pointer from 2nd node onwards
            ListNode secondAltNodePtr = head.next;

            ListNode trailPtr = lastNode;

            while(firstAltNodePtr != lastNode && firstAltNodePtr.next != lastNode ) {

                // 1->2->3->4->5   firstAltptr= 1 secondAltrPtr=2
                //update the first alternate point next
                firstAltNodePtr.next = secondAltNodePtr.next;

                //moved the second alt pointer to last
                trailPtr.next = secondAltNodePtr;
                secondAltNodePtr.next = null;

                firstAltNodePtr = firstAltNodePtr.next;
                secondAltNodePtr = firstAltNodePtr.next;

                trailPtr = trailPtr.next;
            }

            return head;

        }
}
