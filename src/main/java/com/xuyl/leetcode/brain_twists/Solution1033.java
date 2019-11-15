package com.xuyl.leetcode.brain_twists;
//三枚石子放置在数轴上，位置分别为 a，b，c。
//
// 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。 
//
// 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。 
//
// 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves] 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 2, c = 5
//输出：[1, 2]
//解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
// 
//
// 示例 2： 
//
// 输入：a = 4, b = 3, c = 2
//输出：[0, 0]
//解释：我们无法进行任何移动。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 100 
// 1 <= b <= 100 
// 1 <= c <= 100 
// a != b, b != c, c != a 
// 
// Related Topics 脑筋急转弯


import org.junit.jupiter.api.Test;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1033 {
    /**
     * 最小移动次数:
     * 先将三个整数顺序确定, 以 x < y < z 的顺序排列;
     *  ①. 如果 z - y == 2 或者 y - x == 2, 那么一定可以一步将另一个数移动到y的旁边, 变成3个连续的整数. 因此, 此时最小移动次数为1;
     *  ②. 排除 ① 的情况, 若存在 z - y > 1(或 > 2, 因为 == 2 的情况已经包含在 ① 中了), 最小移动次数 +1;
     *                   若存在 y - x > 1, 最小移动次数 +1; 即可得出最小移动次数;
     * max = z - x - 2;
     */
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = new int[2];
        // 将三个数按照从小到大的顺序排序
        if ( a > b ) {
            a = a^b;
            b = a^b;
            a = a^b;
        }
        if ( b > c ) {
            b = b^c;
            c = b^c;
            b = b^c;
        }
        if ( a > b ) {
            a = a^b;
            b = a^b;
            a = a^b;
        }
        int cb = c - b;
        int ba = b - a;
        if ( cb == 2 || ba == 2 ) {
            nums[0] = 1;
        } else {
            if ( cb > 2 ) {
                nums[0]++;
            }
            if ( ba > 2 ) {
                nums[0]++;
            }
        }
        nums[1] = cb + ba - 2;
        return nums;
    }

    @Test
    public void testNumMovesStones(){
        int[] nums = numMovesStones(1, 2, 4);
        System.out.println(nums[0] + ":" + nums[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
