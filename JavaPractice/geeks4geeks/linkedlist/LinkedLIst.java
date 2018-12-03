package linkedlist;

public class LinkedLIst {

    String listname;
    Node head = null;

    LinkedLIst(String name) {
        this.listname = name;
    }

    public LinkedLIst() {

    }

    class Node {
        int data;
        Node next;

        Node(int ele) {
            data = ele;
            next = null;
        }
    };

    void insert(int ele) {
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

    void insertAtFront(int ele) {
        Node n1 = new Node(ele);
        if (head == null) {
            head = n1;
        } else {
            n1.next = head;
            head = n1;
        }
    }

    void printlist() {
        System.out.println("List name:"+ this.listname + " elements are");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    void printlist(Node head1) {
        System.out.println("List elements are");
        Node temp = head1;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    void deleteNode(int ele) {
        System.out.println("Delete element");

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (ele == temp.data) {
                // first element
                if (temp == head) {
                    head = temp.next;
                    temp.next = null;
                    return;
                }

                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    Node detectLoop() {

        if (head == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    Node findNode(int ele) {
        System.out.println("Searching for node");

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (ele == temp.data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    Node findLastNode() {
        System.out.println("return last node in list ");

        Node temp = head;
        Node prev = null;

        if (head == null) {
            return null;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    void setLoopAtEle(int ele) {
        Node n1 = findNode(ele);
        findLastNode().next = n1;
        System.out.println("Loop is set at element: " + n1.data);
    }

    void IsloopDetected() {
        System.out.println("Loop detected in list: " + (detectLoop() == null ? false : true));
    }

    Node loopNode() {
        Node meetingNode = detectLoop();
        Node n1 = head;

        if (meetingNode != null) {
            while (meetingNode != n1) {
                n1 = n1.next;
                meetingNode = meetingNode.next;
            }
            return n1;
        }
        return null;
    }

    Node getElePrevNode(int ele) {
        Node n1 = head;
        Node n1prev = null;

        while (n1 != null) {
            if (n1.data == ele) {
                break;
            }
            n1prev = n1;
            n1 = n1.next;
        }
        return n1prev;
    }

    //Case1: Two nodes apart by more than 1
    //Case 2: adjacent nodes
    void swapTwoNodes(int ele1, int ele2) {
        Node n1prev = getElePrevNode(ele1);
        Node n2prev = getElePrevNode(ele2);

        Node n1, n2;
        Node n1Next, n2Next;
        //n1 is head node
        if (n1prev == null) {
            n1 = head;

            n1Next = n1.next;
            n2 = n2prev.next;
            n2Next = n2.next;

            // n1 and n2 are ajacent nodes
            // If it is not handled then loop will be formed in list at n2->n2
            if(n1.next == n2){
                n2.next = n1;
                n1.next = n2Next;
            } else {
                n2.next = n1Next;
                n2prev.next = n1;
                n1.next = n2Next;
            }

            head = n2;
        } else {
            n1 = n1prev.next;
            n2 = n2prev.next;

            n1Next = n1.next;
            n2Next = n2.next;

            // adjacent nodes
            // If it is not handled then loop will be formed in list at n2->n2
            if(n1.next == n2){
                n2.next = n1;
                n1.next = n2Next;
                n1prev.next = n2;
            } else {
                n1prev.next = n2;
                n2.next = n1Next;

                n2prev.next = n1;
                n1.next = n2Next;
            }
        }
    }

    void swapAdjacentNodes() {
        Node first = head;
        Node second = first.next;
        Node third = second.next;

        while (second != null) {
            swapTwoNodes(first.data, second.data);
            first = third;
            if (third == null || third.next == null) {
                second = null;
            } else {
                second = third.next;
                third = second.next;
            }
        }
    }

    LinkedLIst interSectionOfTwoSortedList(Node list1, Node list2) {

        Node move = null;
        Node temp = null;
        Node newHead = null;

        System.out.println("Intersection of lists ...");
        while(list1 !=null && list2 != null){

            if(list1.data == list2.data) {
                if(newHead == null){
                    temp = new Node(list1.data);
                    newHead = temp;
                    move=temp;
                } else {
                    temp = new Node(list1.data);
                    move.next=temp;
                    move=temp;
                }
                list1=list1.next;
                list2 = list2.next;
            }else if(list1.data > list2.data){
                list2=list2.next;
            }else{
                list1=list1.next;
            }
        }
        //printlist(newHead);
        LinkedLIst l3 = new LinkedLIst("Intersection list ");
        l3.head = newHead;
        return l3;
    }
}
