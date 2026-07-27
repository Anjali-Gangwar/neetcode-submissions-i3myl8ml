class Solution {
        public int swimInWater(int[][] grid) {
                int n = grid.length;

                        int[][] dist = new int[n][n];
                                for (int[] row : dist) {
                                            Arrays.fill(row, Integer.MAX_VALUE);
                                                    }

                                                            PriorityQueue<int[]> pq = new PriorityQueue<>(
                                                                        (a, b) -> a[0] - b[0]
                                                                                );

                                                                                        dist[0][0] = grid[0][0];
                                                                                                pq.offer(new int[]{grid[0][0], 0, 0});

                                                                                                        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

                                                                                                                while (!pq.isEmpty()) {
                                                                                                                            int[] cur = pq.poll();

                                                                                                                                        int time = cur[0];
                                                                                                                                                    int r = cur[1];
                                                                                                                                                                int c = cur[2];

                                                                                                                                                                            if (r == n - 1 && c == n - 1)
                                                                                                                                                                                            return time;

                                                                                                                                                                                                        for (int[] d : dir) {
                                                                                                                                                                                                                        int nr = r + d[0];
                                                                                                                                                                                                                                        int nc = c + d[1];

                                                                                                                                                                                                                                                        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                                                                                                                                                                                                                                                            int newTime = Math.max(time, grid[nr][nc]);

                                                                                                                                                                                                                                                                                                if (newTime < dist[nr][nc]) {
                                                                                                                                                                                                                                                                                                                        dist[nr][nc] = newTime;
                                                                                                                                                                                                                                                                                                                                                pq.offer(new int[]{newTime, nr, nc});
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                                                                                return -1;
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
