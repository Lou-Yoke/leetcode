package com.github.io;

/**
 * @Author:lupengfei3
 * @Description: 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @Date: Created in 2:25 下午 2020/5/19
 */
public class validPalindrome {

    public static void main(String[] args) {
        String s = "aba";
        boolean b = validPalindrome(s);
        System.out.println(b);

    }

    public static boolean validPalindrome(String s) {
        int low = 0,high = s.length()-1;
        while(low<high){
            char cl = s.charAt(low),ch = s.charAt(high);
            if (cl == ch){
                low++;
                high--;
            }else{
                boolean flag1 = true,flag2 = true;
                for (int i = low,j = high-1;i<j;i++,j--){
                    char c3 = s.charAt(i),c4 = s.charAt(j);
                    if (c3 != c4){
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low+1,j = high;i<j;i++,j--){
                    char c3 = s.charAt(i),c4 = s.charAt(j);
                    if (c3 != c4){
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
}
