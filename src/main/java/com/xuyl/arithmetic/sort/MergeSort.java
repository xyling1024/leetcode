package com.xuyl.arithmetic.sort;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @description: 归并排序
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/11/18 11:25
 */
public class MergeSort {

    private int[] nums = {423, 453, 75, 23, 89, 223, 75, 0, 5};

    /**
     * 归并排序：将所有对象先分为只包含一个元素的数组, 然后两两合并. 保证每一个数组都是有序的, 最后整体有序.
     * @return
     */
    private void mergeSort(int start, int end) {
        // 需要排序的数列中超过一个对象
        if (end > start) {
            int mid = (end - start)/2 + start;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            // 将以上两个有序数列合并
            mergeSort(start, mid, end);
        }
    }

    private void mergeSort(int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        int i = 0;
        while (start1 <= end1 && start2 <= end2) {
            temp[i++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
        }
        while (start1 <= end1) {
            temp[i++] = nums[start1++];
        }
        while (start2 <= end2) {
            temp[i++] = nums[start2++];
        }
        for (int n = 0; n < temp.length; n++) {
            nums[start++] = temp[n];
        }
    }

    @Test
    public void test() {
        mergeSort(0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}