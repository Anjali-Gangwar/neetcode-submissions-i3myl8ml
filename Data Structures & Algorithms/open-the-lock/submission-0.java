

class Solution {
    public int openLock(String[] deadends, String target) {
            Set<String> dead = new HashSet<>(Arrays.asList(deadends));

                    if (dead.contains("0000")) return -1;
                            if (target.equals("0000")) return 0;

                                    Queue<String> queue = new LinkedList<>();
                                            Set<String> visited = new HashSet<>();

                                                    queue.offer("0000");
                                                            visited.add("0000");

                                                                    int steps = 0;

                                                                            while (!queue.isEmpty()) {
                                                                                        int size = queue.size();

                                                                                                    while (size-- > 0) {
                                                                                                                    String curr = queue.poll();

                                                                                                                                    if (curr.equals(target))
                                                                                                                                                        return steps;

                                                                                                                                                                        for (int i = 0; i < 4; i++) {
                                                                                                                                                                                            char[] arr = curr.toCharArray();

                                                                                                                                                                                                                // Rotate wheel forward
                                                                                                                                                                                                                                    arr[i] = (char) ((arr[i] - '0' + 1) % 10 + '0');
                                                                                                                                                                                                                                                        String next = new String(arr);

                                                                                                                                                                                                                                                                            if (!dead.contains(next) && visited.add(next))
                                                                                                                                                                                                                                                                                                    queue.offer(next);

                                                                                                                                                                                                                                                                                                                        // Rotate wheel backward
                                                                                                                                                                                                                                                                                                                                            arr = curr.toCharArray();
                                                                                                                                                                                                                                                                                                                                                                arr[i] = (char) ((arr[i] - '0' + 9) % 10 + '0');
                                                                                                                                                                                                                                                                                                                                                                                    next = new String(arr);

                                                                                                                                                                                                                                                                                                                                                                                                        if (!dead.contains(next) && visited.add(next))
                                                                                                                                                                                                                                                                                                                                                                                                                                queue.offer(next);
                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                        steps++;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        return -1;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }