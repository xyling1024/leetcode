package com.xuyl.leetcode.dynamic_programming;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划

import org.junit.jupiter.api.Test;

/**
 * @description: 爬楼梯  f(n) = f(n-1) + f(n-2)
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/10/16 21:45
 */
public class Solution70 {

    // 时间复杂度太高
    int recursion(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        } else {
            return recursion(n - 1) + recursion(n - 2);
        }
    }

    int circulation(int n) {
        if (n == 0) return 0;
        int i = 1, a = 1, b = 1, c = 1;
        while (i++ < n) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


    @Test
    public void test() {
        int n = 2;
        System.out.println(recursion(n));
        System.out.println(circulation(n));
    }

}