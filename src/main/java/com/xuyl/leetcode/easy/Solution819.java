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


import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.sql.SQLOutput;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution819 {
    /**
     * todo 可优化
     * 执行用时 : 30 ms, 在所有 java 提交中击败了50.25%的用户
     * 内存消耗 : 37.7 MB, 在所有 java 提交中击败了79.68%的用户
     *
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
        int max = 0;
        int resultIndex = strList.length - 1;
        int bannedIndex = 0;
        for (int i = 1; i <= strList.length; i++) {
            // 当前对象与上一个对象不等, 或者上一个对象为最后一个对象
            if ( i == strList.length || !strList[i].equals(strList[i - 1]) ) {
                if ( curFreq > max ) {
                    boolean isBanned = false;
                    // 判断是否在banned中
                    while (bannedIndex < banned.length) {
                        int value = banned[bannedIndex].compareTo(strList[i - 1]);
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
                    }
                }
                curFreq = 1;
            } else {
                curFreq++;
            }
        }
        return strList[resultIndex];
    }

    @Test
    public void test() {
//        String paragraph = "L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! U' M! j? V; l. S! j? r, K. O? k? p? p, H! t! z' X! v. u; F, h; s? X? K. y, Y! L; q! y? j, o? D' y? F' Z; E? W; W' W! n! p' U. N; w? V' y! Q; J, o! T? g? o! N' M? X? w! V. w? o' k. W. y, k; o' m! r; i, n. k, w; U? S? t; O' g' z. V. N? z, W? j! m? W! h; t! V' T! Z? R' w, w? y? y; O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' X! u. y, Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X' V, b. z, x! Q; y, g' j; j. q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T? l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! G? r; Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z? Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. R. R, O. S! w; p' T. u? U! n, V, M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q; W? m? y, Z! x. y. j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u; U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'";
//        String[] banned = {"m","i","s","w","y","d","q","l","a","p","n","t","u","b","o","e","f","g","c","x"};
        String paragraph = "abc abc? abcd the jeff!";
        String[] banned = {"abc","abcd","jeff"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
