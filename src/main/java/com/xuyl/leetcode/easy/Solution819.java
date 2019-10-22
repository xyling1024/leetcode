package com.xuyl.leetcode.easy;
//给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。题目保证至少有一个词不在禁用列表中，而且答案唯一。
//
// 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。 
//
// 
//
// 示例： 
//
// 输入: 
//paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
//banned = ["hit"]
//输出: "ball"
//解释: 
//"hit" 出现了3次，但它是一个禁用的单词。
//"ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。 
//注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"）， 
//"hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
// 
//
// 
//
// 说明： 
//
// 
// 1 <= 段落长度 <= 1000. 
// 1 <= 禁用单词个数 <= 100. 
// 1 <= 禁用单词长度 <= 10. 
// 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。) 
// paragraph 只包含字母、空格和下列标点符号!?',;. 
// 不存在没有连字符或者带有连字符的单词。 
// 单词里只包含字母，不会出现省略号或者其他标点符号。 
// 
// Related Topics 字符串


import org.springframework.util.StringUtils;

import java.sql.SQLOutput;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution819 {
    /**
     * 将paragraph按空格切割成数组, 然后对这些数组进行排序, 这样相同的单词一定会在一起.
     * 对banned同样进行排序操作.
     * 我们对这些排好序的单词进行遍历, 每当发现一个与前面单词不一样的新单词, 去banned通过指针进行查找,一旦发现banned索引位置处的单词 > 当前遍历到的单词, 说明不在banned中. 继续下一次遍历.
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        // ================ 处理数据 start ===============
        String[] strList = paragraph.replace("!", " ")
                .replace("?", " ").replace("'", " ")
                .replace(",", " ").replace(";", " ")
                .replace(".", " ").replaceAll(" +"," ").toLowerCase().split(" ");
        // 对strList进行排序
        Arrays.sort(strList);
        // 对banned进行排序
        Arrays.sort(banned);
        // ================ 处理数据 end ===============

        int curFreq = 1;
        int max = 1;
        int resultIndex = 0;
        int bannedIndex = 0;
        for (int i = 1; i < strList.length; i++) {
            // 当前对象与上一个对象不等, 或者当前对象为最后一个对象
            if ( !strList[i].trim().equals(strList[i - 1].trim()) || i == strList.length - 1 ) {
                if ( curFreq > max ) {
                    boolean isBanned = false;
                    // 判断是否在banned中
                    while (bannedIndex < banned.length) {
                        int value = banned[bannedIndex].compareTo(strList[i - 1].trim());
                        if ( value == 0 ) {
                            isBanned = true;
                            break;
                        } else if ( value < 0 ) {
                            bannedIndex++;
                        } else {
                            break;
                        }
                    }
                    if ( !isBanned ) {
                        resultIndex = i - 1;
                        max = curFreq;
                        curFreq = 1;
                    } else {
                        curFreq = 0;
                    }
                }
            } else {
                curFreq++;
            }
        }
        return strList[resultIndex].trim();
    }

    public static void main(String[] args) {
        /**
         "abc abc? abcd the jeff!"
         ["abc","abcd","jeff"]
         */
        String paragraph = "abc abc? abcd the jeff!";
        String[] banned = {"abc","abcd","jeff"};
        System.out.println(new Solution819().mostCommonWord(paragraph, banned));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
