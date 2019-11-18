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
     *
     * 选数组中的第一个对象, 存入一个临时的变量tmp中. 申明两个指针, 一个指针i(从前向后移动), 一个指针j(从后向前移动):
     *      将 tmp 与 nums[j] 比较, 如果 tmp > nums[j], 则赋值 nums[i] = nums[j], 同时 i++;
     *      比较 tmp 与 nums[i], 如果 tmp < nums[i], 则赋值 nums[j] = nums[i], 同时 j++;
     *      不断循环以上过程, 直到 i == j, 说明数组中所有对象都已比较完毕.
     *      此时, 原数组已经被我们分成了: 比临时变量小的数组 + 临时变量 + 比临时变量大的数组
     *      对除临时变量外的两个数组重复进行如上步骤, 直到数组的长度小于等于1, 长度为1的数组天然有序, 那么整体数组也就有序了.
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums, int start, int end) {
        // 长度为1的数组天然有序, 直接返回
        if ( end - start < 1 ) {
            return nums;
        }
        int tmpStart = start, tmpEnd = end;
        // 第一个元素作为分界对象
        int tmp = nums[start];
        // 比较前面的元素还是后面的元素
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
            if (start == end) {
                break;
            }
        }
        nums[start] = tmp;
        quickSort(nums, tmpStart, start - 1);
        quickSort(nums, end + 1, tmpEnd);
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {453, 75, 223, 89, 23, 0};
//        int[] nums = {423, 453, 75, 23, 89, 223, 75, 0, 5};
        int[] ints = quickSort(nums, 0, nums.length - 1);
        for (int num : ints) {
            System.out.println(num);
        }
    }




/*
    public int[] quickSort(int[] nums) {
        LinkedList<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            numList.add(num);
        }
        numList = quickSort(numList);
        for (int i = 0; i < numList.size(); i++) {
            nums[i] = numList.get(i);
        }
        return nums;
    }

    public LinkedList<Integer> quickSort(LinkedList<Integer> nums) {
        LinkedList<Integer> leftNums = new LinkedList<>();
        LinkedList<Integer> rightNums = new LinkedList<>();
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) <= nums.get(0)) {
                leftNums.add(nums.get(i));
            } else {
                rightNums.add(nums.get(i));
            }
        }
        if (leftNums.size() > 1) {
            leftNums = quickSort(leftNums);
        }
        if (rightNums.size() > 1) {
            rightNums = quickSort(rightNums);
        }
        leftNums.addLast(nums.get(0));
        leftNums.addAll(rightNums);
        return leftNums;
    }
*/









}