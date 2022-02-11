package com.algorithm.homework.weeksix.p673;

import java.util.Arrays;
import java.util.List;

/**
 * @author qiuch
 * 从P300 lengthOfLis 递进而来，增加数组记录出现相同（最大）长度的次数
 * dp equation: dp[i]=max((a[i]~a[j]){dp[j]+1})
 * Time complexity : O(n^2)
 * Space complexity : O(n)
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int answer = 0, currentMax = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] == dp[j] + 1) {
                        count[i] = count[i] + count[j];
                    } else {
                        //dp[i] = Math.max(dp[i], dp[j] + 1);
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            count[i] = count[j];
                        }
                    }
                }
            }

            if (dp[i] == currentMax) {
                answer = answer + count[i];
            } else if (dp[i] > currentMax) {
                currentMax = dp[i];
                answer = count[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }
}
