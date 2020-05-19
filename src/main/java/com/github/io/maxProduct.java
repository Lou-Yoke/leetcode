package com.github.io;

import com.alibaba.fastjson.JSON;

/**
 * @Author:lupengfei3
 * @Description: 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * @Date: Created in 10:39 上午 2020/5/18
 */
public class maxProduct {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int i = maxProduct(nums);
        System.out.println(JSON.toJSONString(i));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
        }

        int res = dp[0][1];
        for (int i = 1; i < dp.length; i++) {
            res = Math.max(res,dp[i][1]);
        }
        return res;

    }
}
