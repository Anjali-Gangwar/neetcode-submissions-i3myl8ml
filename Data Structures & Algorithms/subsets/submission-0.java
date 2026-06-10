class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
        backtrack(0, nums, new ArrayList<>());
        return ans;

    }

    private void backtrack(int idx, int[] nums, List<Integer> curr){

        if(idx == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        //include
        curr.add(nums[idx]);
        backtrack(idx+1, nums, curr);

        //backtrack
        curr.remove(curr.size()-1);

        //exclude
        backtrack(idx+1, nums, curr);
    }
}
