package com.algorithm.homework.weeksix.p70;

/**
 * @author qiuch
 * dp equation: dp[n] = dp[n-1]+dp[n-2]
 * Time complexity : O(n)
 * Space complexity : O(1)
 */
class Solution {
    public int climbStairs(int n) {
        //定义数组空间有些浪费，用滚动向前计算优化空间
        if (n <= 2) return n;
        int before = 1, twoBefore = 0, result = 1;
        for (int i = 1; i < n; i++) {
            twoBefore = before;
            before = result;
            result = before + twoBefore;
        }
        return result;

//        方便理解，下标从1开始，Space complexity : O(n)
//        int dp[] = new int[n > 2 ? n + 1 : 3];
//        dp[1] = 1;
//        dp[2] = 2;
//        if (n > 2) {
//            for (int i = 3; i <= n; i++) {
//                dp[i] = dp[i - 1] + dp[i - 2];
//            }
//        }
//        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Solution().climbStairs(i));
        }
    }
}
