package com.xuyl.leetcode.dynamic_programming;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划


import org.junit.jupiter.api.Test;

/**
 * @description: 求连续子数组的最大和
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/10/16 21:45
 */
public class Solution53 {

    /**
     * 设f(i)为##与第i个成员保持连续##的前i个成员的连续子数组的最大和。
     * 例如{-2, 1, -3, 4, -1, 2, 1, -5, 4}，f(2)为-2，连续子数组为{1,-3};而不是1，连续子数组为{1}
     *
     * 1. 比较nums[i]与f(i-1) + nums[i]的值哪个大，将最大值赋值给临时变量a;
     * 2. 比较1中最大的值即临时变量a与f(i-1)哪个大，如果f(i-1)大并且f(i-1)比historyMax大，那么将f(i-1)赋值给historyMax
     * 3. 将临时变量a赋值给max作为下一轮f(i-1)的值
     * 从0开始遍历每一个成员执行以上操作，得到了max和historyMax，最大的一个即为连续子数组最大和。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int historyMax = max;
        for (int i = 1; i < nums.length; i++) {
            int a = Math.max(max + nums[i], nums[i]);
            if (max > a && max > historyMax) {
                historyMax = max;
            }
            max = a;
        }
        return Math.max(max, historyMax);
    }

    @Test
    public void testMaxSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}