class Solution {

    class Pair {
        int freq;
        char ch;

        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((x, y) -> y.freq - x.freq);

        if (a > 0) pq.offer(new Pair(a, 'a'));
        if (b > 0) pq.offer(new Pair(b, 'b'));
        if (c > 0) pq.offer(new Pair(c, 'c'));

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {

            Pair first = pq.poll();

            int n = ans.length();

            if (n >= 2 &&
                ans.charAt(n - 1) == first.ch &&
                ans.charAt(n - 2) == first.ch) {

                if (pq.isEmpty()) {
                    break;
                }

                Pair second = pq.poll();

                ans.append(second.ch);
                second.freq--;

                if (second.freq > 0) {
                    pq.offer(second);
                }

                pq.offer(first);
            }
            else {

                ans.append(first.ch);
                first.freq--;

                if (first.freq > 0) {
                    pq.offer(first);
                }
            }
        }

        return ans.toString();
    }
}