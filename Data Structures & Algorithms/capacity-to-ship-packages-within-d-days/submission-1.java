class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0; int r = 0;
        for (int w: weights) {
            l = Math.max(l, w);
            r = r + w;
        }

        int result = r;

        while (l <= r) {
            int capacity = l + (r - l)/2;

            if (canShip(weights, days, capacity)) {
                result = capacity;
                r = capacity - 1;
            } else {
                l = capacity + 1;
            }
        }
        return result;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currCap  = capacity;
        int time = 1;

        for (int weight : weights) {
            if (currCap  < weight) {
                time++;
                currCap  = capacity;
            }

            currCap  = currCap - weight;
        }

        if (time <= days) {
            return true;
        } else {
            return false;
        }
    }
}