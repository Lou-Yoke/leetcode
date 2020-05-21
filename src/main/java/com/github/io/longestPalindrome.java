package com.github.io;

/**
 * @Author:lupengfei3
 * @Description: 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @Date: Created in 11:31 上午 2020/5/21
 */
public class longestPalindrome {
    public static void main(String[] args) {
        String s = "eabcbcb";
        String s1 = "abbbbb";
        String ss1 = longestPalindrome(s1);
        String ss2 = longestPalindrome2(s);
        System.out.println(ss1);
        System.out.println(ss2);

    }

    /**
     * 中心扩散法
     * 首先往左寻找与当期位置相同的字符，直到遇到不相等为止。
     * 然后往右寻找与当期位置相同的字符，直到遇到不相等为止。
     * 最后左右双向扩散，直到左和右不相等。
     * <p>
     * 缺点：
     * 做了很多重复计算。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }

        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    /**
     * 动态规划
     * 空间换时间
     * <p>
     * 转移公示：P(i,j)=P(i+1,j−1)∧(Si==Sj)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s==null || s.length() < 2 ){
            return s;
        }
        int len = s.length();
        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
