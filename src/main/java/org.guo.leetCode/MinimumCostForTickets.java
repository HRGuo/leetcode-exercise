package org.guo.leetCode;

import java.util.Arrays;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int minCost = Math.min(costs[0], Math.min(costs[1], costs[2]));
        dp[0] = minCost;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.min(dp[i], dp[i-1] + minCost);
            for (int j = 0; j < i; j++) {
                int diff = days[i] - days[j];
                if (diff < 7) {
                    dp[i] = Math.min(dp[i], (j-1 < 0 ? 0 : dp[j-1]) + costs[1]);
                } else if(diff >= 7 && diff < 30) {
                    dp[i] = Math.min(dp[i], (j-1 < 0 ? 0 : dp[j-1]) + costs[2]);
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCostForTickets().mincostTickets(
                new int[]{1,4,6,7,8,20},
                new int[]{7,2,15}));
    }

}
