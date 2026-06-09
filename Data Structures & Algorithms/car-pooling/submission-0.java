class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // {to, passengers}

        int currentPassengers = 0;

        for (int[] trip : trips) {

            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            // Drop off passengers whose destination has arrived
            while (!pq.isEmpty() && pq.peek()[0] <= from) {
                currentPassengers -= pq.poll()[1];
            }

            // Pick up new passengers
            currentPassengers += passengers;

            if (currentPassengers > capacity) {
                return false;
            }

            pq.offer(new int[]{to, passengers});
        }

        return true;
    }
}