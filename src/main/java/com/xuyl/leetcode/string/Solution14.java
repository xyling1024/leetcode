package com.xuyl.leetcode.string;//编写一个函数来查找字符串数组中的最长公共前缀。
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
    public String longestCommonPrefix2(String[] strs) {
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

    /**
     * 遍历所有成员，获取每个成员与当前得到的公共前缀的公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        byte[] resultByte = strs[0].getBytes();
        int resultLen = resultByte.length;
        for (int i = 1; i < strs.length; i++) {
            // 获取strs[i]与result的公共前缀
            byte[] bytes = strs[i].getBytes();
            int len = resultLen > bytes.length ? bytes.length : resultLen;
            boolean resetLen = true;
            for (int j = 0; j < len; j++) {
                if (bytes[j] != resultByte[j]) {
                    resultLen = j;
                    resetLen = false;
                    break;
                }
            }
            if (resetLen) {
                resultLen = len;
            }
            if (resultLen == 0) {
                return "";
            }
        }
        return new String(resultByte, 0, 0, resultLen);
    }

    @Test
    public void test(){
        String[] strs = {"a", "a", "b"};
        System.out.println(longestCommonPrefix(strs));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
