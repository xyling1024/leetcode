package com.xuyl.leetcode.easy;
//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
//    F(0) = 0,   F(1) = 1
//    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//    给定 N，计算 F(N)。


/**
 * @description: F(N) = F(N - 1) + F(N - 2)
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/10/16 21:45
 */
public class Solution509 {

    // 时间复杂度太高
    int recursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return recursion(n - 1) + recursion(n - 2);
        }
    }

    int circulation(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int i = 1, a = 0, b = 1, c = 0;
        while (i++ < N) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution509().recursion(n));
        System.out.println(new Solution509().circulation(n));
    }
}