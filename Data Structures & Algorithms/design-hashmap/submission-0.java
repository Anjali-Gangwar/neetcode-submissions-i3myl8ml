class MyHashMap {

    private int size = 1000;
    private LinkedList<Pair>[] buckets;

    // Pair class banayenge (important)
    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new LinkedList[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // check if key already exists
        for (Pair p : buckets[index]) {
            if (p.key == key) {
                p.value = value; // update
                return;
            }
        }

        // new insert
        buckets[index].add(new Pair(key, value));
    }

    public int get(int key) {
        int index = hash(key);

        if (buckets[index] != null) {
            for (Pair p : buckets[index]) {
                if (p.key == key) {
                    return p.value;
                }
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);

        if (buckets[index] != null) {
            for (Pair p : buckets[index]) {
                if (p.key == key) {
                    buckets[index].remove(p);
                    return;
                }
            }
        }
    }
}