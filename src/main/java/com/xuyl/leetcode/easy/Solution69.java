package com.xuyl.leetcode.easy;
//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


import com.xuyl.anno.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.SQLOutput;

//leetcode submit region begin(Prohibit modification and deletion)
@Todo("可以优化为二分法实现")
class Solution69 {

    public int mySqrt(int x) {
        if ( x == 0 || x == 1 ) {
            return x;
        }
        int last = 1;
        int len = x/2;
        for (int i = 1; i <= len; i++) {
            int current = i * i;
            if ( current == x ) {
                return i;
            // 这里current < last主要是考虑存在溢出的可能
            } else if ( current < last || current > x ) {
                return i - 1;
            } else {
                last = current;
            }
        }
        return len;
    }

    @Test
    public void testMySqrt() {
        System.out.println(new Solution69().mySqrt(0));
        System.out.println(new Solution69().mySqrt(1));
        System.out.println(new Solution69().mySqrt(2));
        System.out.println(new Solution69().mySqrt(4));
        System.out.println(new Solution69().mySqrt(8));
        System.out.println(new Solution69().mySqrt(9));
        System.out.println(new Solution69().mySqrt(2147483647));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
