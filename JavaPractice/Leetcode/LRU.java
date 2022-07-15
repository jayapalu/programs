import java.util.HashMap;

//Double linked list
 class DLnode {
     int key;
     int value;
     DLnode next;
     DLnode prev;

     DLnode() {
     }

    DLnode(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
     }
 }

public class LRU {
    DLnode head;
    DLnode tail;
    DLnode node;
    int capacity;
    int count;

    HashMap<Integer, DLnode> map = new HashMap<Integer, DLnode>();
    LRU(int capatciy){
        this.capacity = capatciy;
        int count = 1;

        head = new DLnode(0,0);
        tail = new DLnode(0,0);

        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    int get(int key){
        System.out.println(" Get key="+key );
        if(map.containsKey(key)){
            node = map.get(key);
            System.out.println("Get key="+node.key + " val="+node.value);

            // move the key to the front of the list.

            return node.value;
        }
        System.out.println("Get NOT found ");
        return -1;
    }

    void set(int key, int val){
        System.out.println(" Set key="+key + " value="+val);
        // if the key is NOT in the map
        if(!map.containsKey(key)){
            System.out.println("Key is not there in the map");
            //check if the capacity is reached then delete the last element from the DL
            if(count == capacity){
                System.out.println("capacity full so deleting "+tail.prev.value);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
            }

            node = new DLnode(key, val);
            //add the node to the front of the list
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            map.put(key, node);

            if(count < capacity){
                count++;
            }
        }else{
            System.out.println("Key is in the map");
            //if key is already there then delete from the current position and add it to the front
            node = map.get(key);
            //delete the node links
            node.prev.next = node.next;
            node.next.prev = node.prev;

            //move to front
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            map.put(key, node);
        }
    }

    public static void main(String[] args){
        LRU l1 = new LRU(4);
        l1.set(1,1);
        l1.set(2,2);
        l1.get(1);
        l1.set(3,3);
        l1.get(2);
        l1.set(4,4);
        l1.get(1);
        l1.get(3);
        l1.get(4);

        //Ans: [ 1 -1  -1, 3, 4]
    }
}
