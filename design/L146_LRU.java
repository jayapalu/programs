import java.util.HashMap;

class LRUCache {
    /*
    Add at the head
    On full remove the node from tail
    on found move to head
     */

    class DLLNode {
        int key;
        int val;

        DLLNode next;
        DLLNode prev;

        DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // insert after the head   h->n1 , insert n2
    void addAfterHead(DLLNode node) {
        //1. n2.next = n1
        node.next = head.next;
        // update the head next prev.
        head.next.prev = node;

        //head is dettached now. update the head to point to n2
        //after this  h ->n2 ->n1
        head.next = node;
        node.prev = head;
    }


    void removeNode(DLLNode node) {
        // we will always have head and tail. This delete node is for LRU only not generic DLL delete
        //n1->n2->n3 ... delete n2. :n1->n2

        //1. update the n2 prev node links to n2 next node

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    DLLNode popTail() {
        // remove the node before tail;
        DLLNode node = tail.prev;
        removeNode(node);
        return node;
    }


    int capacity;
    int size;
    DLLNode head;
    DLLNode tail;

    HashMap<Integer, DLLNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;

        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);

        head.prev = null;
        tail.next = null;

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {

        if(map.containsKey(key)) {
            System.out.println("key " +key + " found");
            DLLNode node = map.get(key);
            //remove the node and add at the head
            removeNode(node);
            addAfterHead(node);
            return node.val;
        }

        System.out.println("key NOT found ");
        return -1;
    }

    public void put(int key, int val) {

        DLLNode node = map.get(key);

        if(node == null) {
            //key not found. 1. create node and add at the front
            // after add check the size and remove from the tail.

            System.out.println(" PUT key NOT found ... adding key "+key);
            DLLNode newNode = new DLLNode(key, val);
            map.put(key, newNode);
            addAfterHead(newNode);

            //System.out.println(" PUT size  "+ size);
            // start with 0 so <
            if(size < capacity) {
                size++;

            }else {
                DLLNode tailNode =  popTail();
                map.remove(tailNode.key);
                System.out.println(" PUT size is full removing "+tailNode.key);
            }
        }else {
            //key is already there then update the value
            node.val = val;
            //move to head
            removeNode(node);
            addAfterHead(node);
            System.out.println(" PUT key is present moving it to head " +key);
        }
    }
}

public class L146_LRU {

    public static void main(String[] args) {

        LRUCache l1 = new LRUCache(4);

        l1.put(1,1);
        l1.put(2,2);
        l1.get(1);
        l1.put(3,3);
        l1.get(2);
        l1.put(4,4);
        l1.put(5,5);
        l1.put(6,6);
        l1.get(1);



    }

}
