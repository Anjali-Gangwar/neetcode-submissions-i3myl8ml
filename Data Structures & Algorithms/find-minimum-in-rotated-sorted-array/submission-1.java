class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int n = nums.length;
        int minx = nums[0];
        while(l <= r){
            if(nums[l] < nums[r]){
                return Math.min(minx, nums[l]);
            }
            int mid = (l+r)/2;
            // https://youtu.be/4qjprDkJrjY?si=KN_spsmf3HUGwoas
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            if(nums[prev] >= nums[mid] && nums[mid] <= nums[next]){
                return nums[mid];
            }
            if(nums[l] <= nums[mid]){
                // search in right, since left half is alredy sorted and mid will be high
                l = mid + 1;
            }else {
                r  = mid - 1;
            }
        }
        return minx;
    }
}

