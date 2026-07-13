class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
                List<Integer>[] graph = new ArrayList[numCourses];
                        int[] indegree = new int[numCourses];

                                for (int i = 0; i < numCourses; i++) {
                                            graph[i] = new ArrayList<>();
                                                    }

                                                            for (int[] p : prerequisites) {
                                                                        graph[p[1]].add(p[0]);
                                                                                    indegree[p[0]]++;
                                                                                            }

                                                                                                    Queue<Integer> queue = new LinkedList<>();

                                                                                                            for (int i = 0; i < numCourses; i++) {
                                                                                                                        if (indegree[i] == 0) {
                                                                                                                                        queue.offer(i);
                                                                                                                                                    }
                                                                                                                                                            }

                                                                                                                                                                    int count = 0;

                                                                                                                                                                            while (!queue.isEmpty()) {
                                                                                                                                                                                        int course = queue.poll();
                                                                                                                                                                                                    count++;

                                                                                                                                                                                                                for (int next : graph[course]) {
                                                                                                                                                                                                                                if (--indegree[next] == 0) {
                                                                                                                                                                                                                                                    queue.offer(next);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                return count == numCourses;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    }
