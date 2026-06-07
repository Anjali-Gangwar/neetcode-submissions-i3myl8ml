class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            pq.add(stone);
        }

        while(pq.size() > 1){

            int y = pq.remove();
            int x = pq.remove();

            if(y != x){
                pq.add(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
