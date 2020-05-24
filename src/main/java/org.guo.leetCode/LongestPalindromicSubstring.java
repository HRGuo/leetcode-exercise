package org.guo.leetCode;

public class LongestPalindromicSubstring {

//    public String longestPalindrome(String s) { // 竟然是暴力解法
//        if (s.length() == 0) {
//            return "";
//        }
//        int max = 1;
//        String res = s.substring(0,1);
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i+1; j < s.length(); j++) {
//                String substring = s.substring(i, j+1);
//                boolean palindrome = true;
//                for(int k = 0; k < substring.length()/2; k++) {
//                    if (substring.charAt(k) != substring.charAt(substring.length() - k - 1)) {
//                        palindrome = false;
//                        break;
//                    }
//                }
//                if (palindrome) {
//                    max = Math.max(max, substring.length());
//                    res = substring;
//                }
//            }
//        }
//        return res;
//    }

    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int max = 1;
        int row = 0, col = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        // Arrays.fill(dp, false);
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                if (2 > max) {
                    max = 2;
                    row = i;
                    col = i + 1;
                }
            }
        }

        for (int range = 2; range < s.length(); range++) {
            for (int i = 0; i + range < s.length(); i++) {
                dp[i][i + range] = dp[i + 1][i + range - 1] && (s.charAt(i) == s.charAt(i + range));
                if (dp[i][i + range] && (range + 1 > max)) {
                    max = range + 1;
                    row = i;
                    col = i + range;
                }
            }
        }
        return s.substring(row, col + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("eabcb"));
    }
}
