class Solution {

    private List<String> ans = new ArrayList<>();

    private String[] map = {
        "",      // 0
        "",      // 1
        "abc",   // 2
        "def",   // 3
        "ghi",   // 4
        "jkl",   // 5
        "mno",   // 6
        "pqrs",  // 7
        "tuv",   // 8
        "wxyz"   // 9
    };

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return ans;
        }

        backtrack(0, new StringBuilder(), digits);

        return ans;
    }

    private void backtrack(int idx, StringBuilder curr, String digits) {

        if (idx == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (char ch : letters.toCharArray()) {

            curr.append(ch);

            backtrack(idx + 1, curr, digits);

            curr.deleteCharAt(curr.length() - 1); // backtrack
        }
    }
}