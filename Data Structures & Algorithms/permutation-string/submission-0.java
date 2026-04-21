class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Fill count1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        int k = s1.length();

        // First window
        for (int i = 0; i < k; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Compare first window
        if (matches(count1, count2)) return true;

        // Sliding window
        for (int i = k; i < s2.length(); i++) {
            // Add new char
            count2[s2.charAt(i) - 'a']++;

            // Remove old char
            count2[s2.charAt(i - k) - 'a']--;

            if (matches(count1, count2)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
