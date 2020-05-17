package com.github.io;

import com.alibaba.fastjson.JSON;

/**
 * @Author:lupengfei3
 * @Description: 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Date: Created in 8:12 下午 2020/5/17
 */
public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int i = removeDuplicates(nums);
        System.out.println(JSON.toJSONString(i));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= nums[x]){
                x++;
                nums[x] = nums[i];
            }
        }
        x++;
        return x;
    }
}
