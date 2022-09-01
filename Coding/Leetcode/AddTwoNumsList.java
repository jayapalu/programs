
//2. Add Two Numbers - https://leetcode.com/problems/add-two-numbers/
/*

 */
public class AddTwoNumsList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        int sum;
        int add = 0;

        ListNode resList = null;
        ListNode resHead = null;

        while (l1 != null && l2 != null) {

            System.out.println(" l1.val="+l1.val + " l2.val="+l2.val);
            sum = l1.val + l2.val + carry; //carry should come here
            if (sum > 9) {
                add = sum % 10 ;
                carry = 1;
            } else {
                add = sum ;
                carry = 0;
            }

            if (resHead == null) {
                System.out.println("First node");

                ListNode temp = new ListNode(add);
                resList = temp;
                resHead = temp;
            } else {
                System.out.println("=====");
                ListNode temp = new ListNode(add);
                resList.next = temp;
                resList = resList.next;
            }
            System.out.println("add =" + add + " carry = " + carry);


            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {
            sum = l1.val + carry; // carry comes here only

            if (sum > 9) {
                add = sum % 10 ;
                carry = 1;
            } else {
                add = sum ;
                carry = 0;
            }
            resList.next = new ListNode(add);
            resList = resList.next;

            l1 = l1.next;
        }


        while (l2 != null) {
            sum = l2.val + carry;  // carry comes here only

            if (sum > 9) {
                add = sum % 10 ;
                carry = 1;
            } else {
                add = sum ;
                carry = 0;
            }
            resList.next = new ListNode(add);
            resList = resList.next;

            l2= l2.next;
        }

        if(carry == 1){
            resList.next = new ListNode(carry);
        }
        return resHead;
    }//method
}
