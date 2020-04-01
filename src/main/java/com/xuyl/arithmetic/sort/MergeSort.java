//package com.xuyl.arithmetic.sort;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.LinkedList;
//
///**
// * @description: 归并排序 todo 有报错，先注释
// * @author: yaling.xu
// * @signature 天王盖地虎，胖墩吃脑腐。
// * @date: 2019/11/18 11:25
// */
//public class MergeSort {
//
//    /**
//     * 归并排序：将所有对象先分为只包含一个元素的数组, 然后两两合并. 保证每一个数组都是有序的, 最后整体有序.
//     * @param nums
//     * @return
//     */
//    public int[] mergeSort(int[] nums) {
//        for(int i = 0; i < nums.length; i++) {
//            if (i < nums1.length) {
//                nums1[i] = nums[i];
//            } else {
//                nums2[i] = nums[i];
//            }
//        }
//
//
//        return nums;
//    }
//
//    public int[] mergeSort(int[] nums, int start1, int end1, int start2, int end2) {
//        int i = start1, j = start2;
////        for (int i = 0; i < (nums1.length < nums2.length ? nums1.length : nums2.length);) {
////            if ( nums1[i] < nums2[j] ) {
////
////            }
////        }
//        int size = (end1 - start1) < (end2 - start2) ? end1 - start1 : end2 - start2;
//
//        while (true) {
//            if ( nums[i] < nums[j] ) {
//                i++;
//            } else {
//                nums[i] = nums[i] ^ nums[j];
//                nums[j] = nums[i] ^ nums[j];
//                nums[i] = nums[i] ^ nums[j];
//                j++;
//            }
//            if ( i >= end1 || j >= end2 ) {
//
//            }
//        }
//
//
//
//        return nums;
//    }
//
//    @Test
//    public void test() {
//        int[] nums = {423, 453, 75, 23, 89, 223, 75, 0, 5};
//        int[] ints = mergeSort(nums);
//        for (int num : ints) {
//            System.out.println(num);
//        }
//    }
//}