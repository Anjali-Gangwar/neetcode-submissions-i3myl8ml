/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Step 1: Find Peak
        int peak = findPeak(mountainArr, n);

        // Step 2: Search in left (ascending)
        int left = binarySearch(mountainArr, target, 0, peak, true);
        if (left != -1) return left;

        // Step 3: Search in right (descending)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int findPeak(MountainArray arr, int n) {
        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr.get(mid) < arr.get(mid + 1)) {
                l = mid + 1; // going up
            } else {
                r = mid; // going down
            }
        }
        return l; // peak index
    }

    private int binarySearch(MountainArray arr, int target, int l, int r, boolean isAsc) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;

            if (isAsc) {
                if (val < target) l = mid + 1;
                else r = mid - 1;
            } else {
                if (val < target) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }
}