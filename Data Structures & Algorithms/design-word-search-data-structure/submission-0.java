class WordDictionary {

        class TrieNode {
                TrieNode[] children;
                        boolean eow;

                                TrieNode() {
                                            children = new TrieNode[26];
                                                        eow = false;
                                                                }
                                                                    }

                                                                        private TrieNode root;

                                                                            public WordDictionary() {
                                                                                    root = new TrieNode();
                                                                                        }

                                                                                            public void addWord(String word) {
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

                                                                                                                                                                                                    public boolean search(String word) {
                                                                                                                                                                                                            return dfs(word, 0, root);
                                                                                                                                                                                                                }

                                                                                                                                                                                                                    private boolean dfs(String word, int pos, TrieNode curr) {

                                                                                                                                                                                                                            if (pos == word.length()) {
                                                                                                                                                                                                                                        return curr.eow;
                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                        char ch = word.charAt(pos);

                                                                                                                                                                                                                                                                // Normal character
                                                                                                                                                                                                                                                                        if (ch != '.') {
                                                                                                                                                                                                                                                                                    int idx = ch - 'a';

                                                                                                                                                                                                                                                                                                if (curr.children[idx] == null) {
                                                                                                                                                                                                                                                                                                                return false;
                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                        return dfs(word, pos + 1, curr.children[idx]);
                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                        // Dot character
                                                                                                                                                                                                                                                                                                                                                                for (int i = 0; i < 26; i++) {
                                                                                                                                                                                                                                                                                                                                                                            if (curr.children[i] != null) {
                                                                                                                                                                                                                                                                                                                                                                                            if (dfs(word, pos + 1, curr.children[i])) {
                                                                                                                                                                                                                                                                                                                                                                                                                return true;
                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                                                                                                                            return false;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                }

