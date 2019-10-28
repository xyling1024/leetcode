package com.xuyl.leetcode.array;
//在一个给定的数组nums中，总是存在一个最大元素 。
//
// 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。 
//
// 如果是，则返回最大元素的索引，否则返回-1。 
//
// 示例 1: 
//
// 输入: nums = [3, 6, 1, 0]
//输出: 1
//解释: 6是最大的整数, 对于数组中的其他整数,
//6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
// 
//
// 
//
// 示例 2: 
//
// 输入: nums = [1, 2, 3, 4]
//输出: -1
//解释: 4没有超过3的两倍大, 所以我们返回 -1.
// 
//
// 
//
// 提示: 
//
// 
// nums 的长度范围在[1, 50]. 
// 每个 nums[i] 的整数范围在 [0, 100]. 
// 
// Related Topics 数组


import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution747 {
    /**
     * 求得数组中最大的数以及第二大的数并记录他们的索引.
     * 如果最大的数是第二大的数的两倍, 返回最大的数的索引. 否则返回-1
     */
    public int dominantIndex(int[] nums) {
        if ( nums.length == 1 ) {
            return 0;
        }
        int maxIndex = 0;
        int secondIndex = 1;
        if ( nums[1] > nums[0] ) {
            maxIndex = 1;
            secondIndex = 0;
        }
        for (int i = 2; i < nums.length; i++) {
            if ( nums[i] > nums[secondIndex] ) {
                if ( nums[i] > nums[maxIndex] ) {
                    secondIndex = maxIndex;
                    maxIndex = i;
                } else {
                    secondIndex = i;
                }
            }
        }
        return nums[secondIndex] == 0 ? (nums[maxIndex] == 0 ? -1 : maxIndex) :
                (nums[maxIndex]/nums[secondIndex] >= 2 ? maxIndex : -1);
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(dominantIndex(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
