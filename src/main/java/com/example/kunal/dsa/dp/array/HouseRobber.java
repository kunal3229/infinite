package com.example.kunal.dsa.dp.array;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Integer.MIN_VALUE;
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }
}
