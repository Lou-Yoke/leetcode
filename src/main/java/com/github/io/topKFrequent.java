package com.github.io;

import java.util.*;

import com.alibaba.fastjson.JSON;

/**
 * @Author:lupengfei3
 * @Description: 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 输入: nums = [1,1,1,2,2,3], k = 2 输出: [1,2]
 * @Date: Created in 5:49 下午 2020/5/15
 */
public class topKFrequent {

    public static int[] topKFrequent(int[] nums, final int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (final int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (final Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        final int[] res = new int[k];
        int n = 0;
        while (!pq.isEmpty()) {
            res[n++] = pq.remove();
        }
        return res;
    }

    public static int[] topKFrequent2(int[] nums, final int k) {
        int[] res = new int[k];
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<Integer>();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        int i = 0;
        for (int j = list.length - 1; j >= 0 && i<k; j--) {
            if (list[j] == null) {
                continue;
            }
            for (Object o : list[j]) {
                res[i++] = (int) o;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        int[] res2 = topKFrequent2(nums, k);
        System.out.println(JSON.toJSONString(res));
        System.out.println(JSON.toJSONString(res2));
    }

}
