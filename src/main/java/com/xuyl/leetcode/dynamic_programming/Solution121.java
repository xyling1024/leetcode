package com.xuyl.leetcode.dynamic_programming;
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。 
//
// 注意你不能在买入股票前卖出股票。 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution121 {
    /**
     * f(i) = nums[i] - min(i-1)
     * 记录前i个成员的最小值，以及前i个成员的最大利润；
     * 每次遍历时使用当前第i个成员的值减去最小值得到当前利润，如果当前利润小于0，则更新前i个成员的最小值为当前第i个成员的值；取当前利润与历史最大利润中大的那个更新为历史最大利润。
     * 依次遍历完成后，该历史最大利润即为所求的最大利润。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int a = prices[i] - min;
            if (a < 0) {
                min = prices[i];
            } else {
                maxProfit = Math.max(a, maxProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(new Solution121().maxProfit(prices));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
