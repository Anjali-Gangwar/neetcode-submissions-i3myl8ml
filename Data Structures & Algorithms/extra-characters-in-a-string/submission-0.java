class Solution {

        class TrieNode {
                TrieNode[] children = new TrieNode[26];
                        boolean eow = false;
                            }

                                TrieNode root = new TrieNode();
                                    int[] dp;

                                        public int minExtraChar(String s, String[] dictionary) {

                                                // Build Trie
                                                        for (String word : dictionary) {
                                                                    insert(word);
                                                                            }

                                                                                    dp = new int[s.length()];
                                                                                            Arrays.fill(dp, -1);

                                                                                                    return solve(0, s);
                                                                                                        }

                                                                                                            private void insert(String word) {
                                                                                                                    TrieNode curr = root;

                                                                                                                            for (int i = 0; i < word.length(); i++) {
                                                                                                                                        int idx = word.charAt(i) - 'a';

                                                                                                                                                    if (curr.children[idx] == null) {
                                                                                                                                                                    curr.children[idx] = new TrieNode();
                                                                                                                                                                                }

                                                                                                                                                                                            curr = curr.children[idx];
                                                                                                                                                                                                    }

                                                                                                                                                                                                            curr.eow = true;
                                                                                                                                                                                                                }

                                                                                                                                                                                                                    private int solve(int i, String s) {

                                                                                                                                                                                                                            if (i == s.length()) {
                                                                                                                                                                                                                                        return 0;
                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                        if (dp[i] != -1) {
                                                                                                                                                                                                                                                                    return dp[i];
                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                    // Option 1: current char ko extra maan lo
                                                                                                                                                                                                                                                                                            int ans = 1 + solve(i + 1, s);

                                                                                                                                                                                                                                                                                                    TrieNode curr = root;

                                                                                                                                                                                                                                                                                                            // Option 2: dictionary word match karo
                                                                                                                                                                                                                                                                                                                    for (int j = i; j < s.length(); j++) {

                                                                                                                                                                                                                                                                                                                                int idx = s.charAt(j) - 'a';

                                                                                                                                                                                                                                                                                                                                            if (curr.children[idx] == null) {
                                                                                                                                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                                                    curr = curr.children[idx];

                                                                                                                                                                                                                                                                                                                                                                                                if (curr.eow) {
                                                                                                                                                                                                                                                                                                                                                                                                                ans = Math.min(ans, solve(j + 1, s));
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                                                                                                            return dp[i] = ans;
                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                }