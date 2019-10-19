package com.xuyl.leetcode.dynamic_programming;
//爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
//
// 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作： 
//
// 
// 选出任一 x，满足 0 < x < N 且 N % x == 0 。 
// 用 N - x 替换黑板上的数字 N 。 
// 
//
// 如果玩家无法执行这些操作，就会输掉游戏。 
//
// 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：2
//输出：true
//解释：爱丽丝选择 1，鲍勃无法进行操作。
// 
//
// 示例 2： 
//
// 输入：3
//输出：false
//解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
// 
//
// 
//
// 提示： 
//
//

// 1 <= N <= 1000 
// 
// Related Topics 数学 动态规划


import com.xuyl.leetcode.utils.NumUtils;

import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1025 {
    /**
     * 1. 当N为奇偶数时，n一定有两个约数，1和2（为了表述方便暂且说1是约数）. 且 f(n-1) = !f(n-2) || ...
     * 因此：f(n) = !f(n-1) || !f(n-2) || ...
     *           = f(n-2) || !f(n-2) || ...
     *           = true
     * 2. 当N为奇数时，约数一定是奇数；那么N减去约数得到的一定是一个偶数；由1知，偶数必赢，因此奇数必输。
     */
    public boolean divisorGame(int N) {
        return N%2 == 0;
    }

    /**
     * 动态规划：时间复杂度太高高高高高高高高高高高高
     * 公式：f(n) = !( f(n-i1) && f(n-i2) && f(n-i3) && ... )
     */
    public boolean dynamicProgramming(int N) {
        if (N <= 1) return false;
        boolean flag = true;
        List<Integer> divisorNum = NumUtils.divisorNum(N);
        divisorNum.add(1);
        for (Integer num : divisorNum) {
            flag = flag && dynamicProgramming(N - num);
        }
        return !flag;
    }

    /**
     * 递归记忆化搜索
     * 创建一个字典，如果能从字典取值，直接取出；如果取不出，计算得到后存入字典，返回字典的值；
     * @param N
     * @return
     */
    public boolean memorizedSearch(int N, Boolean[] dict) {
        if (dict == null) dict = new Boolean[N + 1];
        if (dict[N] == null) {
            boolean flag = true;
            if (N > 1) {
                List<Integer> divisorNum = NumUtils.divisorNum(N);
                divisorNum.add(1);
                for (Integer num : divisorNum) {
                    flag = flag && memorizedSearch(N - num, dict);
                }
            }
            dict[N] = !flag;
        }
        return dict[N];
    }

    /**
     * for循环记忆化搜索
     * 从0遍历到N，查每一个的约数，然后flag = flag&& dict[num]得到值，存入dict中
     * @param N
     * @return
     */
    public boolean memorizedSearch(int N) {
        Boolean[] dict = new Boolean[N + 1];
        for (int i = 0; i < dict.length; i++) {
            if (i <= 1) {
                dict[i] = false;
                continue;
            }
            boolean flag = true;
            List<Integer> divisorNum = NumUtils.divisorNum(i);
            divisorNum.add(1);
            for (Integer num : divisorNum) {
                flag = flag && dict[i - num];
            }
            dict[i] = !flag;
        }
        return dict[N];
    }

    public static void main(String[] args) {
        Solution1025 solution1025 = new Solution1025();
        for (int i = 1; i < 100; i++) {
            if (solution1025.memorizedSearch(i) != solution1025.divisorGame(i)) {
                System.out.println("failed:" + i + "; memorizedSearch:" + solution1025.memorizedSearch(i));
                return;
            }
        }
        System.out.println("success");
    }

}
//leetcode submit region end(Prohibit modification and deletion)
