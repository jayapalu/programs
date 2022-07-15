import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class L460_LFU {

    public static void main(String[] args) {

        LFU l1 = new LFU(4);
        l1.put(2,1);
        l1.put(2,2);  //here key with different value. So delete/overwrite with frequency 1
        l1.get(2);
        l1.put(1,1);
        l1.put(4,1);
        l1.get(2);

//        LFU l2 = new LFU(2);
//        l2.put(1,1);
//        l2.put(2,2);
//        l2.get(1);
//        l2.put(3,3);
//        l2.get(2);
////        l2.get(3);
////        l2.put(4,4);
////        l2.get(1);
////        l2.get(3);
////        l2.get(4);


    }
}

class LFU {

    int size = 0;
    int capacity = 0;

    //map<key, val>
    HashMap<Integer, Integer> keyValmap = new HashMap<>();
    //map<key, frequency>
    HashMap<Integer, Integer> freqMap = new HashMap<>();

    //  <freq, map<key1, key2>>
    TreeMap<Integer, LinkedHashMap<Integer, Integer>> treeMap = new TreeMap<Integer, LinkedHashMap<Integer, Integer>>();


    public LFU(int capacity) {
        this.capacity = capacity;

        LinkedHashMap<Integer, Integer> zeroFreq = new LinkedHashMap<>();
        // this is need to for first time to delete the zero key linkedhashmap from the tree map in method updateFreqTreeMap
        treeMap.put(0, zeroFreq);
    }

    public void put(int key, int val) {
        System.out.println("PUT adding key " +key +" value= " + val);

        if(this.capacity < 1) {
            return ;
        }

        int frequency = 0;

        boolean updateExisting = freqMap.containsKey(key);
        //TODO: check if the value is different for the same key

        if(updateExisting) {
            frequency += freqMap.get(key);
            System.out.println("key= " +key +" already exist with freq "+frequency);
        }

        // key is not there, and size is full. replace the LFU key
        if(this.size == this.capacity && !updateExisting) {
            System.out.println("key NOT exist Size full ");

            //get the lease freq key for the delete and add the new key
            LinkedHashMap <Integer, Integer> leastFreq = treeMap.get(treeMap.firstKey());
            int leastRecentKey = leastFreq.keySet().iterator().next();
            System.out.println(" PUT keyslist " + leastFreq.keySet());
            System.out.println(" PUT keyslist " + leastFreq.values());

            System.out.println(" PUT removing the key  " + leastRecentKey +" with freq= "+ leastFreq.values().iterator().next() );

            keyValmap.remove(leastRecentKey);
            freqMap.remove(leastRecentKey);
            leastFreq.remove(leastRecentKey);
        }

        // size is not full
        if(this.size <= this.capacity) {
            this.size++;
        }

        //adding the new key
        keyValmap.put(key,val);
        updateFreqTreeMap(key);
        freqMap.put(key, frequency+1);

    } //method

    int get(int key) {
        System.out.println("Get: called KEY    " + key);
        if(!keyValmap.containsKey(key)) {
            System.out.println("    Get: KEY not present  " + key +" returning -1");
            return -1;
        }

        updateFreqTreeMap(key);

        int freq = freqMap.get(key);
        freqMap.put(key, freq+1);
        System.out.println("    Get: returning key  val " + key);
        return keyValmap.get(key);
    }



    /*
    1. remove the key from the linkedhashmap
    2. On removing linkedhashmap emty then delete key from treemap
    3. if the frequency+1 is not there then add entry into treemap
    4. update the treemap linkedhashmap with the key

     */

    void updateFreqTreeMap(int key) {

        int frequecy = freqMap.getOrDefault(key, 0);
        System.out.println("        Update: key= " +key + " freq   " + frequecy);

        //from the treemap linkedhashmap remove this key because this key will go into new frequency
        if(treeMap.containsKey(frequecy) && treeMap.get(frequecy).containsKey(key)) {
            System.out.println("        Update:  removing key  from linkedhashmap ");
            treeMap.get(frequecy).remove(key);
        }
        //if there are no keys with this frequency then remove the freq from map
        if(treeMap.containsKey(frequecy) && treeMap.get(frequecy).isEmpty()) {
            System.out.println("        Update:  zero keys for this freq so removing key  from treemap ");
            treeMap.remove(frequecy);
        }

        // if the frequency+1 is not there in the map then create entry for it and add the key
        if(!treeMap.containsKey(frequecy+1)) {
            LinkedHashMap <Integer, Integer> nextFreqmap = new LinkedHashMap<>();

            treeMap.put(frequecy+1, nextFreqmap);
        }

        System.out.println("        Update:  updated key freq in treemap to "+ (frequecy+1));
        treeMap.get(frequecy+1).put(key, key);
    }



}
