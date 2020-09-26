package com.xuyl.algorithm.sort;

import org.junit.jupiter.api.Test;

/**
 * @description: 冒泡排序：从第一个对象开始，将相邻的两个对象进行比较，如果前一个对象比后一个对象小，就进行交换。一直比较到最后一个对象；
 *      *          之后再从第二个对象依次向后进行下一轮比较。n轮遍历完成后，就是一个有序的数组了。
 *              优化：加一个标志位，如果在进行一轮两两比较的过程中，没有进行过任何交换，我们就可以认为这个数组已经是有序的，不用继续下一轮遍历了。
 *      时间复杂度：n^2
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/11/18 11:25
 */
public class BubbleSort {

    public int[] bubbleSort(int[] nums) {
        boolean sorted = true;
        for (int i = 0; i < nums.length;) {
            for (int j = i; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    sorted = false;
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                }
            }
            if (sorted) {
                break;
            } else {
                sorted = true;
            }
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {453, 75, 223, 89, 75, 23, 0};
//        int[] nums = {423, 453, 75, 23, 89, 223, 75, 0, 5};
        int[] ints = bubbleSort(nums);
        for (int num : ints) {
            System.out.println(num);
        }
    }
}