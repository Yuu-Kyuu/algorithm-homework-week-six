package com.algorithm.homework.weeksix.p120;

import java.util.Arrays;
import java.util.List;

/**
 * @author qiuch
 * dp equation: dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
 * Time complexity : O((1+n)*n/2) ->O(n^2)
 * Space complexity : O(n)
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //  节约空间，计算结果层层往上覆盖就行
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

//        //Space complexity : O(n^2)
//        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            for (int j = 0; j <= i; j++) {
//                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
//            }
//        }
//        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        )));
    }
}
