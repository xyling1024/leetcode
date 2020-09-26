package com.xuyl.algorithm.sort;

import org.junit.jupiter.api.Test;

/**
 * @description: 快速排序：任选数组中一个对象，将比这个对象大的扔到对象的左边，小的放到对象的右边。
 *                对已经分好的对象左右两边的数组继续进行这个操作，直到最后两边都只剩一个对象，整个数组就变成有序的了
 *      时间复杂度：nlog(n)
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/11/18 11:25
 */
public class QuickSort {

//    private int[] nums = {453, 75, 223, 89, 23, 0};
    private int[] nums = {423, 453, 75, 23, 89, 223, 75, 0, 5};

    /**
     * 选数组中的第一个对象, 存入一个临时的变量tmp中. 申明两个指针, 一个指针i(从前向后移动), 一个指针j(从后向前移动):
     *      将 tmp 与 nums[j] 比较, 如果 tmp > nums[j], 则赋值 nums[i] = nums[j], 同时 i++;
     *      比较 tmp 与 nums[i], 如果 tmp < nums[i], 则赋值 nums[j] = nums[i], 同时 j++;
     *      不断循环以上过程, 直到 i == j, 说明数组中所有对象都已比较完毕.
     *      此时, 原数组已经被我们分成了: 比临时变量小的数组 + 临时变量 + 比临时变量大的数组
     *      对除临时变量外的两个数组重复进行如上步骤, 直到数组的长度小于等于1, 长度为1的数组天然有序, 那么整体数组也就有序了.
     * @return
     */
    public void quickSort(int start, int end) {
        // 长度为1的数组天然有序, 直接返回
        if ( end - start < 1 ) {
            return;
        }
        int tmpStart = start, tmpEnd = end;
        // 第一个元素作为分界对象
        int tmp = nums[start];
        // 比较前面的元素还是后面的元素
        boolean compareStart = false;
        while (true) {
            if (!compareStart) {
                if (tmp > nums[end]) {
                    nums[start++] = nums[end];
                    compareStart = !compareStart;
                } else {
                    end--;
                }
            } else {
                if (tmp < nums[start]) {
                    nums[end--] = nums[start];
                    compareStart = !compareStart;
                } else {
                    start++;
                }
            }
            if (start == end) {
                break;
            }
        }
        nums[start] = tmp;
        quickSort(tmpStart, start - 1);
        quickSort(end + 1, tmpEnd);
    }

    @Test
    public void test() {
        quickSort(0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}