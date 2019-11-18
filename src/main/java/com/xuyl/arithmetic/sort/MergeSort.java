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

    /**
     * 归并排序：
     * @param nums
     * @return
     */
    public int[] mergeSort(int[] nums) {
        int size = nums.length / 4;
        int[] nums1 = new int[size];
        int[] nums2 = new int[size];
        for(int i = 0; i < nums.length; i++) {
            if (i < nums1.length) {
                nums1[i] = nums[i];
            } else {
                nums2[i] = nums[i];
            }
        }


        return nums;
    }

    public int[] mergeSort(int[] nums1, int[] nums2) {



        return null;
    }

    @Test
    public void test() {
        int[] nums = {423, 453, 75, 23, 89, 223, 75, 0, 5};
        int[] ints = mergeSort(nums);
        for (int num : ints) {
            System.out.println(num);
        }
    }
}