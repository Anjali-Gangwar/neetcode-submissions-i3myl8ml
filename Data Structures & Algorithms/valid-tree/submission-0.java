class Solution {
        int[] parent;
            int[] rank;

                public boolean validTree(int n, int[][] edges) {
                        // A tree with n nodes must have exactly n-1 edges
                                if (edges.length != n - 1) return false;

                                        parent = new int[n];
                                                rank = new int[n];

                                                        for (int i = 0; i < n; i++) {
                                                                    parent[i] = i;
                                                                            }

                                                                                    for (int[] edge : edges) {
                                                                                                if (!union(edge[0], edge[1])) {
                                                                                                                return false; // Cycle found
                                                                                                                            }
                                                                                                                                    }

                                                                                                                                            return true;
                                                                                                                                                }

                                                                                                                                                    private int find(int x) {
                                                                                                                                                            if (parent[x] != x) {
                                                                                                                                                                        parent[x] = find(parent[x]); // Path Compression
                                                                                                                                                                                }
                                                                                                                                                                                        return parent[x];
                                                                                                                                                                                            }

                                                                                                                                                                                                private boolean union(int x, int y) {
                                                                                                                                                                                                        int px = find(x);
                                                                                                                                                                                                                int py = find(y);

                                                                                                                                                                                                                        if (px == py) return false; // Cycle

                                                                                                                                                                                                                                // Union by Rank
                                                                                                                                                                                                                                        if (rank[px] < rank[py]) {
                                                                                                                                                                                                                                                    parent[px] = py;
                                                                                                                                                                                                                                                            } else if (rank[px] > rank[py]) {
                                                                                                                                                                                                                                                                        parent[py] = px;
                                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                                            parent[py] = px;
                                                                                                                                                                                                                                                                                                        rank[px]++;
                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                        return true;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            }
