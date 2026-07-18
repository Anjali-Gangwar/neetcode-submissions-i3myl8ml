class Solution {

        class DSU {
                int[] parent;
                        int[] rank;

                                DSU(int n) {
                                            parent = new int[n + 1];
                                                        rank = new int[n + 1];

                                                                    for (int i = 1; i <= n; i++) {
                                                                                    parent[i] = i;
                                                                                                }
                                                                                                        }

                                                                                                                int find(int x) {
                                                                                                                            if (parent[x] != x)
                                                                                                                                            parent[x] = find(parent[x]); // Path Compression
                                                                                                                                                        return parent[x];
                                                                                                                                                                }

                                                                                                                                                                        boolean union(int x, int y) {
                                                                                                                                                                                    int px = find(x);
                                                                                                                                                                                                int py = find(y);

                                                                                                                                                                                                            if (px == py)
                                                                                                                                                                                                                            return false; // Cycle found

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

                                                                                                                                                                                                                                                                                                                                                                        public int[] findRedundantConnection(int[][] edges) {

                                                                                                                                                                                                                                                                                                                                                                                int n = edges.length;
                                                                                                                                                                                                                                                                                                                                                                                        DSU dsu = new DSU(n);

                                                                                                                                                                                                                                                                                                                                                                                                for (int[] edge : edges) {
                                                                                                                                                                                                                                                                                                                                                                                                            if (!dsu.union(edge[0], edge[1])) {
                                                                                                                                                                                                                                                                                                                                                                                                                            return edge;
                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                                                        return new int[0];
                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
