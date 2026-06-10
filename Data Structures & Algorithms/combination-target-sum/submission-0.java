class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        backtrack(0, nums, target, new ArrayList<>());
        return ans;
    }

    private void backtrack(int idx, int[] nums, int target, List<Integer> curr){
        
         if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(idx == nums.length || target <= 0){
            return;
        }

        //take
        curr.add(nums[idx]);
        backtrack(idx,nums, target - nums[idx], curr);

       // backtrack
        curr.remove(curr.size()-1);

        //skip curr element
        backtrack(idx+1,nums, target, curr);
    }
}
