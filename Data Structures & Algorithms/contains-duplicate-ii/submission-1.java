class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) return false;

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int abs = Math.abs(i - j);
            if (abs <= k) {
                if (nums[i] == nums[j]) return true;  
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}