package com.xuyl.leetcode.math;

import org.junit.jupiter.api.Test;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1:
//
// 输入: 121
//输出: true
//
//
// 示例 2:
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3:
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 进阶:
//
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学
public class Solution9 {

    @Test
    public void test() {
        int num = 12333;
        System.out.println(isPalindromeAdvance(num));
    }

    public boolean isPalindromeBase(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        if (stringBuilder.toString().equals(stringBuilder.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isPalindromeAdvance(int x) {
        char[] chars = (x + "").toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }
}