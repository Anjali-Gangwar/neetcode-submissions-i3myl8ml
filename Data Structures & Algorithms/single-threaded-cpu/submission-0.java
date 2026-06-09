class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // [enqueueTime, processingTime, originalIndex]
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        // Sort by enqueue time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Min Heap: processingTime -> index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] ans = new int[n];
        int idx = 0;      // answer pointer
        int i = 0;        // pointer for sorted tasks
        long time = 0;    // current CPU time

        while (i < n || !pq.isEmpty()) {

            // If CPU is idle and no task is available
            if (pq.isEmpty()) {
                time = Math.max(time, arr[i][0]);
            }

            // Add all available tasks to heap
            while (i < n && arr[i][0] <= time) {
                pq.offer(arr[i]);
                i++;
            }

            // Pick task with smallest processing time
            int[] curr = pq.poll();

            ans[idx++] = curr[2]; // original index
            time += curr[1];      // processing time
        }

        return ans;
    }
}