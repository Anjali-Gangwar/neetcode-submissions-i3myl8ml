class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        int cycles = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            int time = 0;

            for (int i = 0; i <= n; i++) {

                if (!pq.isEmpty()) {

                    int count = pq.poll();
                    count--;

                    if (count > 0) {
                        temp.add(count);
                    }

                    time++;
                }
            }

            for (int count : temp) {
                pq.offer(count);
            }

            if (pq.isEmpty()) {
                cycles += time;
            } else {
                cycles += (n + 1);
            }
        }

        return cycles;
    }
}