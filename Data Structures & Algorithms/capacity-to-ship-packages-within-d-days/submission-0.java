class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;

        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }

        int low = max;
        int high = sum;
        int ans = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1; // try smaller capacity
            } else {
                low = mid + 1;  // need bigger capacity
            }
        }

        return ans;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int d = 1;
        int curr = 0;

        for (int w : weights) {
            if (curr + w <= cap) {
                curr += w;
            } else {
                d++;
                curr = w;
            }
        }

        return d <= days;
    }
}