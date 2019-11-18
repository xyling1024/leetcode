package com.xuyl.arithmetic.sort;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @description: 快速排序
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/11/18 11:25
 */
public class QuickSort {

    /**
     * 快速排序：任选数组中一个对象，将比这个对象大的扔到对象的左边，小的放到对象的右边。
     *          对已经分好的对象左右两边的数组继续进行这个操作，直到最后两边都只剩一个对象，整个数组就变成有序的了
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums, int start, int end) {
        int tmp = nums[start];
        boolean compareStart = false;
        while (true) {
            if (!compareStart) {
                if (tmp > nums[end]) {
                    nums[start] = nums[end];
                    compareStart = true;
                    start++;
                } else {
                    end--;
                }
            } else {
                if (tmp < nums[start]) {
                    nums[end] = nums[start];
                    compareStart = false;
                    end--;
                } else {
                    start++;
                }
            }
            if (start > end) {
                break;
            }
        }
        if (compareStart) {
            nums[(start--) - 1] = tmp;
            quickSort(nums, 0, start - 1);
            quickSort(nums, start, end - 1);
        } else {
            nums[++end] = tmp;
            quickSort(nums, 0, start - 1);
            quickSort(nums, start, end - 1);
        }
        return nums;
    }

    @Test
    public void test() {
//        int[] nums = {453, 75, 223, 89, 75, 23, 0};
        int[] nums = {423, 453, 75, 23, 89, 223, 75, 0, 5};
        int[] ints = quickSort(nums, 0, nums.length - 1);
        for (int num : ints) {
            System.out.println(num);
        }
    }
}