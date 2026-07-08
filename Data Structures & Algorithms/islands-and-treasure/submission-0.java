class Solution {
        public void islandsAndTreasure(int[][] grid) {
                int m = grid.length;
                        int n = grid[0].length;

                                Queue<int[]> q = new LinkedList<>();

                                        // Add all treasure cells (0) to the queue
                                                for (int i = 0; i < m; i++) {
                                                            for (int j = 0; j < n; j++) {
                                                                            if (grid[i][j] == 0) {
                                                                                                q.offer(new int[]{i, j});
                                                                                                                }
                                                                                                                            }
                                                                                                                                    }

                                                                                                                                            int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

                                                                                                                                                    while (!q.isEmpty()) {
                                                                                                                                                                int[] curr = q.poll();

                                                                                                                                                                            for (int[] d : dir) {
                                                                                                                                                                                            int r = curr[0] + d[0];
                                                                                                                                                                                                            int c = curr[1] + d[1];

                                                                                                                                                                                                                            if (r < 0 || c < 0 || r >= m || c >= n ||
                                                                                                                                                                                                                                                grid[r][c] != Integer.MAX_VALUE) {
                                                                                                                                                                                                                                                                    continue;
                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                    grid[r][c] = grid[curr[0]][curr[1]] + 1;
                                                                                                                                                                                                                                                                                                                    q.offer(new int[]{r, c});
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                            }
