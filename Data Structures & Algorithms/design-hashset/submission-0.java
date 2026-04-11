class MyHashSet {

    private int size = 1000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[size]    ;
    }

    private int hash(int key){
        return key % size;
    }
    
    public void add(int key) {
        int idx = hash(key);

        if(buckets[idx] == null){
            buckets[idx] = new LinkedList<>();
        }

        if(!buckets[idx].contains(key)){
            buckets[idx].add(key);
        }
    }
    
    public void remove(int key) {
        int idx = hash(key);

        if(buckets[idx] != null){
            buckets[idx].remove((Integer) key);
        }
    }
    
    public boolean contains(int key) {
        int idx = hash(key);

        if(buckets[idx] != null){
            return buckets[idx].contains(key);
        }

        return false;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */