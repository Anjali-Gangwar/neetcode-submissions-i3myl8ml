class Solution {

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

            public List<List<Integer>> pacificAtlantic(int[][] heights) {

                    int m = heights.length;
                            int n = heights[0].length;

                                    boolean[][] pacific = new boolean[m][n];
                                            boolean[][] atlantic = new boolean[m][n];

                                                    // Pacific (Top row)
                                                            for(int j = 0; j < n; j++)
                                                                        dfs(0, j, pacific, heights);

                                                                                // Pacific (Left column)
                                                                                        for(int i = 0; i < m; i++)
                                                                                                    dfs(i, 0, pacific, heights);

                                                                                                            // Atlantic (Bottom row)
                                                                                                                    for(int j = 0; j < n; j++)
                                                                                                                                dfs(m - 1, j, atlantic, heights);

                                                                                                                                        // Atlantic (Right column)
                                                                                                                                                for(int i = 0; i < m; i++)
                                                                                                                                                            dfs(i, n - 1, atlantic, heights);

                                                                                                                                                                    List<List<Integer>> ans = new ArrayList<>();

                                                                                                                                                                            for(int i = 0; i < m; i++) {
                                                                                                                                                                                        for(int j = 0; j < n; j++) {
                                                                                                                                                                                                        if(pacific[i][j] && atlantic[i][j]) {
                                                                                                                                                                                                                            ans.add(Arrays.asList(i, j));
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                        return ans;
                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                private void dfs(int r, int c, boolean[][] vis, int[][] heights) {

                                                                                                                                                                                                                                                                                        if(vis[r][c]) return;

                                                                                                                                                                                                                                                                                                vis[r][c] = true;

                                                                                                                                                                                                                                                                                                        for(int[] d : dir) {

                                                                                                                                                                                                                                                                                                                    int nr = r + d[0];
                                                                                                                                                                                                                                                                                                                                int nc = c + d[1];

                                                                                                                                                                                                                                                                                                                                            if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length)
                                                                                                                                                                                                                                                                                                                                                            continue;

                                                                                                                                                                                                                                                                                                                                                                        if(vis[nr][nc])
                                                                                                                                                                                                                                                                                                                                                                                        continue;

                                                                                                                                                                                                                                                                                                                                                                                                    // Reverse flow: move only to equal or higher height
                                                                                                                                                                                                                                                                                                                                                                                                                if(heights[nr][nc] >= heights[r][c])
                                                                                                                                                                                                                                                                                                                                                                                                                                dfs(nr, nc, vis, heights);
                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                            }
