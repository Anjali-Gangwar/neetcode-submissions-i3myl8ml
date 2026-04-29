class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean [] visited = new boolean[nums.length];
        dfs(nums,visited, path ,ans);
        return ans;
    }

    private void dfs(int [] nums,boolean [] visited ,List<Integer> path, List<List<Integer>> ans){
        if(path.size() == nums.length) {
            ans.add(new ArrayList(path));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums,visited,path,ans);
            //back track
            visited[i] = false;
            path.remove(path.size()-1);
        }
    }
}
