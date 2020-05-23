package com.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 */
public class minWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }

    public static String minWindow(String s, String t) {
        if (s == null || "".equals(s) || t == null || "".equals(t) || s.length() < t.length()) {
            return "";
        }
        //t表示每个字母出现的次数
        int[] needs = new int[128];
        //滑动窗口中每次出现的次数
        int[] window = new int[128];
        //初始化needs
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        String res = "";
        int count = 0;
        int minLen = s.length() + 1;
        //ADOBECODEBANC
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            if (needs[c] > 0 && needs[c] >= window[c]) {
                count++;
            }
            //移动到不满足条件为止
            while (count == t.length()) {
                c = s.charAt(left);
                if (needs[c] > 0 && needs[c] >= window[c]) {
                    count--;
                }
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window[c]--;
                left++;
            }
            right++;
        }
        return res;
    }
}
