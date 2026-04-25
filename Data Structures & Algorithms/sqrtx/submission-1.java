class Solution {
    public int mySqrt(int x) {
        //        int l = 0;
//        int r = x;
//
//        while (l <= r) {
//            int m = l + (r - l) / 2;
//            long sq = (long) m * m;
//
//            if (sq > x) {
//                r = m - 1;
//            } else {
//                l = m + 1;
//            }
//        }
//
//        return r;


        /////////////////////////

        if (x == 0) {
            return 0;
        }

        long r = x;

        while (r * r > x) {
            r = (r + x / r) / 2;
        }

        return (int) r;
    }
}