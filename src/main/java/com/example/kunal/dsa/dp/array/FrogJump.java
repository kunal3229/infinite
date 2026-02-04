package com.example.kunal.dsa.dp.array;

//Problem statement
//There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair.
//'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair,
//the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ).
//If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair.
//Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
//
//        For Example
//If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair
//        (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost).
//So, the total energy lost is 20.
public class FrogJump {

    public static void main(String[] args) {

        int[] height = new int[]{10, 20, 30, 10};
        int num = height.length-1;

        System.out.println(frog(num, height));
    }

    // Recursion
    // T.C - O(2^n)
    private static int frog(int num, int[] height) {
        if (num == 0) return 0;
        int oneJump = frog(num-1, height) + Math.abs(height[num] - height[num-1]);
        int secondJump = Integer.MAX_VALUE;
        if(num > 1) secondJump = frog(num-2, height) + Math.abs(height[num] - height[num-2]);
        return Math.min(secondJump, oneJump);
    }

    // Memoization
    // S.C - O(n) + O(n)
    // T.C - O(n)
    static int[] dp;
    private static int frogDp(int num, int[] height) {
        if (num == 0) return 0;
        if (dp[num] != -1) return dp[num];
        int oneJump = frogDp(num-1, height) +  Math.abs(height[num] - height[num-1]);
        int secondJump = Integer.MAX_VALUE;
        if (num > 1) secondJump = frogDp(num-2, height) +  Math.abs(height[num] - height[num-2]);

        dp[num] = Math.min(secondJump, oneJump);
        return dp[num];
    }

    // Tabulation
    // S.C - O(n)
    // T.C - O(n)
    private static int frogDp2(int num, int[] height) {
        int n = height.length;
        int[] dp = new int[n];

        dp[0] = 0;
        for(int i=1; i<n; i++){
            int oneJump = dp[i-1] + Math.abs(height[i-1] - height[i]);
            int secondJump = Integer.MAX_VALUE;
            if(i > 1) secondJump = dp[i-2] + Math.abs(height[i-2] - height[i]);
            dp[i] = Math.min(secondJump, oneJump);
        }
        return dp[n-1];
    }

    // Optimized
    // S.C - O(1)
    // T.C - O(n)
    private static int frogDp3(int num, int[] height) {
        int n = height.length;
        int prev1 = 0, prev2 = 0;
        for (int i=1; i<n; i++){
            int oneJump = prev1 + Math.abs(height[i-1] -height[i]);
            int secondJump = Integer.MAX_VALUE;
            if (i > 1) secondJump = prev2 + Math.abs(height[i-1] - height[i]);
            int curr = Math.min(secondJump, oneJump);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
