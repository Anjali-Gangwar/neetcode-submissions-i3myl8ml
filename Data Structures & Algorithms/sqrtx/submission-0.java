class Solution {
    public int mySqrt(int x) {

        int start = 0;
        int end = x;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            long square = (long) mid * mid; // overflow avoid

            if (square == x) {
                return mid;
            }
            else if (square < x) {
                ans = mid; // possible answer
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return ans;
    }
}