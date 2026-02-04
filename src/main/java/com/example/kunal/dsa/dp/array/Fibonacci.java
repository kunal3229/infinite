package com.example.kunal.dsa.dp.array;

public class Fibonacci {

    static int[] dp;

    // Recursion
    // S.C - O(1)
    // T.C - O(2^n)
    public static int fibo(int num){
        if(num <= 1) return num;
        return fibo(num-1) + fibo(num-2);
    }

    // Memoization
    // S.C - O(n) + O(n) recursion stack
    // T.C - O(n)
    public static int fibDp1(int num){
        if(num <= 1) return num;
        if (dp[num] != 0) return dp[num];

        int sum = fibo(num-1) + fibo(num-2);
        dp[num] = sum;
        return sum;
    }

    // Tabulation
    // S.C - O(n)
    // T.C - O(n)
    public static int fibDp2(int num){
        if (num <= 1) return num;
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[num];
    }

    // Optimized
    // S.C - O(1)
    // T.C - O(n)
    public static int fibDp3(int num){
        if (num <= 1) return num;
        int prev = 1, prev1 = 0;
        for (int i = 2; i <= num; i++) {
            int curr = prev + prev1;
            prev = prev1;
            prev1 = curr;
        }
        return prev;
    }

    public static void main(String[] args) {

        int num = 5;
        System.out.println(fibo(num));
    }
}
