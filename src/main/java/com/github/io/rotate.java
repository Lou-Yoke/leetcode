package com.github.io;

import com.alibaba.fastjson.JSON;

/**
 * @Author:lupengfei3
 * @Description: 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @Date: Created in 9:16 下午 2020/5/17
 */
public class rotate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        rotate(nums,k);
        System.out.println(JSON.toJSONString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0){
            return;
        }
        k = k%n;
        if (k == 0){
            return;
        }
        int count = 0;//计数
        for (int i = 0; count < n; i++) {
            int cur = i;
            int pre = nums[cur];
            do {
                int next = (cur+k)%n;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            }while(i != cur);
        }

    }
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] nnums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int x = (i+k)%nums.length;
            nnums[x] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nnums[i];
        }
    }
}
