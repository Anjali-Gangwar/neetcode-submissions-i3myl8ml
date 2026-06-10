class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);

        backtrack(0, candidates, target, new ArrayList<>());

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

        curr.add(nums[idx]);
        backtrack(idx+1, nums, target - nums[idx], curr);

        curr.remove(curr.size()-1);

        while(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }

        backtrack(idx+1, nums, target, curr);
    }
}
