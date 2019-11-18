package com.xuyl.arithmetic.sort;

import com.sun.deploy.util.ArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description: 快速排序
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/11/18 11:25
 */
public class QuickSort_Back {

    /**
     * 快速排序：任选数组中一个对象，将比这个对象大的扔到对象的左边，小的放到对象的右边。
     *          对已经分好的对象左右两边的数组继续进行这个操作，直到最后两边都只剩一个对象，整个数组就变成有序的了
     * @param nums
     * @return
     */
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

    @Test
    public void test() {
//        int[] nums = {453, 75, 223, 89, 75, 23, 0};
        int[] nums = {423, 453, 75, 23, 89, 223, 75, 0, 5};
        int[] ints = quickSort(nums);
        for (int num : ints) {
            System.out.println(num);
        }
    }
}