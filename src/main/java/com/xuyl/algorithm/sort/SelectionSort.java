package com.xuyl.algorithm.sort;

import org.junit.jupiter.api.Test;

/**
 * @description: 选择排序：取第一个与后面的对象依次比较，如果有大的就与第一个互换，直到所有的都与第一个比较完成，第一个就成为最大的对象了；
 *      *          依次取每一个进行一轮这样的遍历，所有对象就都是有序的了。
 *      时间复杂度：n^2
 *      稳定排序：no
 *      就地排序：yes
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/11/18 11:25
 */
public class SelectionSort {

    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    nums[i] = nums[i]^nums[j];
                    nums[j] = nums[i]^nums[j];
                    nums[i] = nums[i]^nums[j];
                }
            }
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {0, 5, 10, 12, 15};
//        int[] nums = {423, 453, 75, 23, 89, 223, 75, 0, 5};
        int[] ints = selectionSort(nums);
        for (int num : ints) {
            System.out.println(num);
        }
    }
}