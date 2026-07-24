class Solution {

        class Pair {
                int node;
                        int dist;

                                Pair(int node, int dist) {
                                            this.node = node;
                                                        this.dist = dist;
                                                                }
                                                                    }

                                                                        public int networkDelayTime(int[][] times, int n, int k) {

                                                                                ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

                                                                                        for (int i = 0; i <= n; i++)
                                                                                                    adj.add(new ArrayList<>());

                                                                                                            for (int[] edge : times) {
                                                                                                                        adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
                                                                                                                                }

                                                                                                                                        int[] dist = new int[n + 1];
                                                                                                                                                Arrays.fill(dist, Integer.MAX_VALUE);

                                                                                                                                                        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

                                                                                                                                                                dist[k] = 0;
                                                                                                                                                                        pq.offer(new Pair(k, 0));

                                                                                                                                                                                while (!pq.isEmpty()) {

                                                                                                                                                                                            Pair curr = pq.poll();

                                                                                                                                                                                                        int node = curr.node;
                                                                                                                                                                                                                    int d = curr.dist;

                                                                                                                                                                                                                                if (d > dist[node])
                                                                                                                                                                                                                                                continue;

                                                                                                                                                                                                                                                            for (Pair nei : adj.get(node)) {

                                                                                                                                                                                                                                                                            int next = nei.node;
                                                                                                                                                                                                                                                                                            int wt = nei.dist;

                                                                                                                                                                                                                                                                                                            if (dist[node] + wt < dist[next]) {

                                                                                                                                                                                                                                                                                                                                dist[next] = dist[node] + wt;
                                                                                                                                                                                                                                                                                                                                                    pq.offer(new Pair(next, dist[next]));
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                                                                int ans = 0;

                                                                                                                                                                                                                                                                                                                                                                                                        for (int i = 1; i <= n; i++) {

                                                                                                                                                                                                                                                                                                                                                                                                                    if (dist[i] == Integer.MAX_VALUE)
                                                                                                                                                                                                                                                                                                                                                                                                                                    return -1;

                                                                                                                                                                                                                                                                                                                                                                                                                                                ans = Math.max(ans, dist[i]);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                return ans;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
}