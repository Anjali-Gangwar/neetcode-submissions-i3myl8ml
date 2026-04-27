class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = getMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int totalHours = 0;

            // calculate total time for this k = mid
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid; // ceil(pile/mid)
            }

            if (totalHours <= h) {
                // valid → try smaller k
                high = mid - 1;
            } else {
                // invalid → increase k
                low = mid + 1;
            }
        }

        return low; // minimum valid k
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}