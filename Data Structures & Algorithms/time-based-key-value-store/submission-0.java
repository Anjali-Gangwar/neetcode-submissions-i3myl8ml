class TimeMap {

    // pair class
    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        // agar key present nahi hai
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        // list me pair add kar do
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        // key exist hi nahi karti
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int low = 0;
        int high = list.size() - 1;

        String ans = "";

        // binary search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // valid timestamp
            if (list.get(mid).timestamp <= timestamp) {

                ans = list.get(mid).value;

                // aur bada valid timestamp dhundho
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }
}