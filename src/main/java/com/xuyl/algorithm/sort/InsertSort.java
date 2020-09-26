package com.xuyl.algorithm.sort;

import org.junit.jupiter.api.Test;

/**
 * @description: 插入排序：将一个对象插入到有序列表中。
 *          实现：选一个对象nums[i]赋给临时变量temp, 将temp与前面的依次比较
 *             如果当前对象比temp小，就把temp放在j+1的位置，退出当前循环，对i++后重新一轮遍历比较；
 *             如果当前对象比temp大，就把当前对象后移一位。并判断当前是否是最后一个被比较的对象了，如果是，将temp赋予nums[j]；继续当前循环；
 *      时间复杂度：n^2
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/11/21 9:23
 */
public class InsertSort {

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    nums[j + 1] = temp;
                    break;
                }
                if (j == 0) {
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 增加哨兵，第一个元素为哨兵：用于存储临时变量以及省略边界条件的判断（j == 0）
     */
    public void insertSortAddSentry(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[i];
            int j = i - 1;
            while (nums[j] > nums[0]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = nums[0];
        }
    }

    @Test
    public void testInsertSort() {
        int[] nums = {423, 75, 23, 89, 223, 75, 0, 5, 453};
        insertSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    @Test
    public void testInsertSortAddSentry() {
        // 第0个元素为哨兵
        int[] nums = {0, 423, 75, 23, 89, 223, 75, 0, 5, 453};
        insertSortAddSentry(nums);
        // 跳过第0个元素打印，因为第0个元素为哨兵
        for (int i = 1; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}