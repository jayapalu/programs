import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L981_timebasedKeyVal {

    public static void main(String[] args){

    }


}

    class TreeMap {

    class Entry{
        int timestamp;
        String val;

        Entry(int timestamp, String val){
            this.timestamp = timestamp;
            this.val = val;
        }
    }

    Map<String, List<Entry>> map;

    TreeMap() {
        map = new HashMap<>();
    }

    void set(String key, String val, int timestamp) {

        if(map.containsKey(key)) {
            map.get(key).add(new Entry(timestamp ,val));
        }else {
            List<Entry> list = new ArrayList<>();
            list.add(new Entry(timestamp, val));
        }
    }

    String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }

        return binarySearch(map.get(key), timestamp);

    }

    private String binarySearch(List<Entry> list, int timestamp) {

        int start = 0;
        int end = list.size() - 1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(timestamp == list.get(mid).timestamp) {
                return list.get(mid).val;
            }else if(timestamp > list.get(mid).timestamp){
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }
        return list.get(start).val;

    }

}