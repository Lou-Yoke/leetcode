package com.github.io;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * <p>
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */
public class findOrder {


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
//        int[][] prerequisites = {{0,1}};
//        int[][] prerequisites = new int[0][];
        int[] res = findOrder(numCourses, prerequisites);
        System.out.println(JSON.toJSONString(res));
    }

    /**
     * 拓扑排序
     * BFS 的总体思路
     * 1. 建立入度表，入度为 0 的节点先入队
     * 2. 当队列不为空，节点出队，标记学完课程数量的变量加 1，并记录该课程
     * 3. 将课程的邻居入度减 1
     * 4. 若邻居课程入度为 0，加入队列
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        // 建立入度表
        int[] inDegrees = new int[numCourses];
        // 对于有先修课的课程，计算有几门先修课
        for (int[] p : prerequisites) {
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        // 记录可以学完的课程数量
        int count = 0;
        // 可以学完的课程
        int[] res = new int[numCourses];
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            // 将可以学完的课程加入结果当中
            res[count++] = curr;
            for (int[] p : prerequisites) {
                if (p[1] == curr) {
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) queue.offer(p[0]);
                }
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }


}
