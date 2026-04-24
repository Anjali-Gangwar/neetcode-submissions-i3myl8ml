class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Step 1: target mil gaya
            if (nums[mid] == target) {
                return true;
            }

            // Step 2: duplicates case (confusing case)
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }

            // Step 3: left part sorted
            else if (nums[left] <= nums[mid]) {
                // check target is in left range
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Step 4: right part sorted
            else {
                // check target is in right range
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}