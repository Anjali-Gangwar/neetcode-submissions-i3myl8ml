class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

                boolean[][] pre = new boolean[numCourses][numCourses];

                        // Direct prerequisites
                                for (int[] edge : prerequisites) {
                                            pre[edge[0]][edge[1]] = true;
                                                    }

                                                            // Floyd-Warshall (Transitive Closure)
                                                                    for (int k = 0; k < numCourses; k++) {
                                                                                for (int i = 0; i < numCourses; i++) {
                                                                                                if (!pre[i][k]) continue;

                                                                                                                for (int j = 0; j < numCourses; j++) {
                                                                                                                                    if (pre[k][j]) {
                                                                                                                                                            pre[i][j] = true;
                                                                                                                                                                                }
                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                                    }

                                                                                                                                                                                                                            List<Boolean> ans = new ArrayList<>();

                                                                                                                                                                                                                                    for (int[] q : queries) {
                                                                                                                                                                                                                                                ans.add(pre[q[0]][q[1]]);
                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                return ans;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    }
