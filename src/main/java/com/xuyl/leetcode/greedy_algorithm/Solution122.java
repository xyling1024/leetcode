package com.xuyl.leetcode.greedy_algorithm;//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 贪心算法 数组

import org.junit.jupiter.api.Test;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution122 {
    /**
     * 贪心算法: 计算每一步的最优解,最后得到的就是 整体的最优解.
     * 遍历所有对象执行以下操作:
     * 1. 如果num[i] < num[i-1], 卖掉股票即: max += (num[i-1] - prev); 并将num[i]作为下一次买入的值即: prev = num[i].
     * 2. 如果num[i] >= num[i-1]且i为最后一个元素, 那么卖掉股票即: max += (num[i-1] - prev);
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if ( prices == null || prices.length <= 0 ) {
            return 0;
        }
        int max = 0;
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                if ( i != 1) {
                    max += (prices[i-1] - prev);
                }
                prev = prices[i];
            } else if ( i == prices.length - 1) {
                max += (prices[i] - prev);
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
