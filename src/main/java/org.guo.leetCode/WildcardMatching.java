package org.guo.leetCode;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0 ) {
            return true;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // initial value
        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            if(p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i-1];
            } else {
                dp[0][i] = false;
            }
        }

        // recurrence
        for (int i = 1; i < s.length() + 1; i++) {
            char ch = s.charAt(i - 1);
            for (int j = 1; j < p.length() + 1; j++) {
                char chp = p.charAt(j - 1);
                if (chp == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1];
                } else if (chp == ch || chp == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("adceb","*a*b"));
    }
}