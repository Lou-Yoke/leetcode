package com.github.io;

import com.alibaba.fastjson.JSON;

/**
 * @Author:lupengfei3
 * @Description: 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * @Date: Created in 8:24 下午 2020/5/17
 */
public class maxProfit {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(nums);
        System.out.println(JSON.toJSONString(i));

    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
}
