class Solution {

    private boolean[] used;
    private int target;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        target = sum / k;

        Arrays.sort(nums);

        reverse(nums);

        if (nums[0] > target) {
            return false;
        }

        used = new boolean[nums.length];

        return backtrack(nums, 0, 0, k);
    }

    private boolean backtrack(int[] nums, int start, int currSum, int k) {

        if (k == 1) {
            return true;
        }

        if (currSum == target) {
            return backtrack(nums, 0, 0, k - 1);
        }

        for (int i = start; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (currSum + nums[i] > target) {
                continue;
            }

            used[i] = true;

            if (backtrack(nums, i + 1,
                         currSum + nums[i], k)) {
                return true;
            }

            used[i] = false;
        }

        return false;
    }

    private void reverse(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;
        }
    }
}