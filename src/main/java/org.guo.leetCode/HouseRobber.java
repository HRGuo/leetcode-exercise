package org.guo.leetCode;

public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i -1; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{2,7,9,3,1}));
    }
}
