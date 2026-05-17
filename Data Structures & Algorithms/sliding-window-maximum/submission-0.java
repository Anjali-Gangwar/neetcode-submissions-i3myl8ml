

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new LinkedList<>();

        int n = nums.length;
        int[] res = new int[n - k + 1];

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // remove outside window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // add current index
            dq.offerLast(i);

            // window complete
            if (i >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}