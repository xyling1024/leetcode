package com.xuyl.leetcode.dynamic_programming;
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution213 {
    /**
     * 假设我们使用O(n)代表围成一圈的n栋房屋能偷窃到的最大金额；f(i, n)代表一条直线从nums[i]到nums[n]的房屋能偷窃到的最大金额；
     * 分析：可以将这个问题分解为两种情况：①。不包含尾部的最佳情况，即：f(n-1)；②。包含尾部的最佳情况，即：f(1, n-2) + nums[n]
     *      取以上两种情况的最大值即为本题的最大金额。
     * 进一步：②中公式 f(1, n-2) + nums[n]在此题中等价于f(1, n)
     * 因此，可得公式：O(n) = Math.max(f(0, n-1), f(1, n))
     * 该公式表达的含义很好理解：由于头尾相连不能同时被选中，那么我们考虑选中头和选中尾两种情况即可。
     *      即：①。包头不包尾的最大金额；②。包尾不包头的最大金额；取这两种情况的最大值即为本题的最大金额。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        Solution198 solution198 = new Solution198();
        int rob = 0;
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) {
            rob = nums[0];
        } else {
            rob = Math.max(solution198.rob(Arrays.copyOfRange(nums, 1, nums.length))
                    , solution198.rob(Arrays.copyOfRange(nums, 0, nums.length - 1)));
        }
        return rob;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(new Solution213().rob(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
