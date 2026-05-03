
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        int count = 1;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count > n / 3) {
                    res.add(nums[i - 1]);
                }
                count = 1;
            }
        }

        // last element check
        if (count > n / 3) {
            res.add(nums[n - 1]);
        }

        return res;
    }
}