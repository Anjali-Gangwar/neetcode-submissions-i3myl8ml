// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         StringBuilder res = new StringBuilder();

//         int i = 0;
//         int j = 0;

//         while(i < word1.length() && j < word2.length()){
//             res.append(word1.charAt(i));
//             i++;

//             res.append(word2.charAt(j));
//             j++;
//         }

//         while(i < word1.length()){
//             res.append(word1.charAt(i));
//             i++;
//         }

//         while(j < word2.length()){
//             res.append(word2.charAt(j));
//             j++;
//         }

//         return res.toString();
//     }
// }

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(word1.length() > len) {
            sb.append(word1.substring(len));
        }else if (word2.length() > len)
            sb.append(word2.substring(len));
        return sb.toString();
    }
}