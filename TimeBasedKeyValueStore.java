import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eduard_Sardyka
 */
public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeMap map = new TimeMap();
        map.set("foo", "bar", 1);
        System.out.println(map.get("foo", 1));
        System.out.println(map.get("foo", 3));
        map.set("foo", "bar2", 4);
        System.out.println(map.get("foo", 4));
        System.out.println(map.get("foo", 5));
    }
}

/**
 * https://leetcode.com/problems/time-based-key-value-store
 * Design a time-based key-value data structure that can store multiple
 * values for the same key at different time stamps and retrieve
 * the key's value at a certain timestamp.
 * <p>
 * Implement the TimeMap class:
 * <p>
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp)
 * Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set
 * was called previously, with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the value associated
 * with the largest timestamp_prev. If there are no values, it returns ""
 * Example 1:
 * <p>
 * Input
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * Output
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 * <p>
 * Explanation
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
 * timeMap.get("foo", 1);         // return "bar"
 * timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at
 *                     timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
 * timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
 * timeMap.get("foo", 4);         // return "bar2"
 * timeMap.get("foo", 5);         // return "bar2"
 * <p>
 * Constraints:
 * <p>
 * 1 <= key.length, value.length <= 100
 * key and value consist of lowercase English letters and digits.
 * 1 <= timestamp <= 10^7
 * All the timestamps timestamp of set are strictly increasing.
 * At most 2 * 10^5 calls will be made to set and get.
 */
class TimeMap {

    private Map<String, List<TimeValue>> map = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        List<TimeValue> list = map.get(key);
        if (list == null) {
            List<TimeValue> timeValues = new ArrayList<>();
            TimeValue timeValue = new TimeValue(value, timestamp);
            timeValues.add(timeValue);
            map.put(key, timeValues);
        } else {
            list.add(new TimeValue(value, timestamp));
        }
    }

    public String get(String key, int timestamp) {
        List<TimeValue> list = map.get(key);
        if (list == null || list.get(0).getTimestamp() > timestamp) {
            return "";
        }
        int index = Collections.binarySearch(list, new TimeValue(key, timestamp),
            (tv1, tv2) -> tv1.getTimestamp() - tv2.getTimestamp());
        if (index < 0) {
            // If the key = new TimeValue(key, timestamp) is not present,
            // BinarySearch returns "(-(insertion point) - 1)"
            index = -index;
            index -= 2;
        }
        return list.get(index).getValue();
    }

    class TimeValue {

        private String value;
        private int timestamp;

        TimeValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public String getValue() {
            return this.value;
        }

        public int getTimestamp() {
            return this.timestamp;
        }
    }
}