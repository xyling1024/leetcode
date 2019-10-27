package com.xuyl.leetcode.easy;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


import org.junit.jupiter.api.Test;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    /**
     * 对字符串数组进行排序后, 比较第一个和最后一个得到的公共前缀即为我们所求!
     */
    public String longestCommonPrefix(String[] strs) {
        String commonPreffix = "";
        if ( strs == null || strs.length <= 0 ) {
            return commonPreffix;
        } else if ( strs.length == 1 ) {
            return strs[0];
        }
        Arrays.sort(strs);
        if ( strs[0] == null || commonPreffix.equals(strs[0]) ) {
            return commonPreffix;
        }
        char[] chars0 = strs[0].toCharArray();
        char[] chars1 = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < chars0.length; i++) {
            if ( chars0[i] != chars1[i] ) {
                if ( i != 0 ) {
                    commonPreffix = strs[0].substring(0, i);
                }
                break;
            } else if ( i == chars0.length - 1 ) {
                commonPreffix = strs[0];
            }
        }
        return commonPreffix;
    }

    @Test
    public void test(){
        String[] strs = {"a", "a", "b"};
        System.out.println(longestCommonPrefix(strs));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
