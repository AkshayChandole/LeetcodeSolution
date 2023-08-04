package BinarySearch.TimeBasedKeyValueStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

/**
 * Time Complexity for constructor TimeStamp() - O(1)
 * Time Complexity for set(String key, String value, int timestamp) - O(1)
 * Time Complexity for get(String key, int timestamp) - O(log(n))
 * Space Complexity - O(n)
 */
class Pair {
    public String value;
    public int timestamp;

    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null) return "";

        int start = 0;
        int end = list.size();

        while (start < end) {
            final int mid = (start + end) / 2;
            if (list.get(mid).timestamp > timestamp) end = mid;
            else start = mid + 1;
        }

        return start == 0 ? "" : list.get(start - 1).value;
    }

}
