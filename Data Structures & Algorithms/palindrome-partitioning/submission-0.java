class Solution {

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        
        backtrack(0, s);

        return ans;
    }

    private void backtrack(int start, String s){

        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++){

            if(isPalindrome(s, start, end)){

                path.add(s.substring(start, end+1));

                backtrack(end+1, s);

                path.remove(path.size()-1);
            }
        }
        
    }

    public boolean isPalindrome(String s, int l, int r){

        while(l < r){

            if(s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
