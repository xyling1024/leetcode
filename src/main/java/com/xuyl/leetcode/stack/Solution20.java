package com.xuyl.leetcode.stack;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import org.junit.jupiter.api.Test;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {
    /**
     * todo 可优化
     * 执行用时 : 69 ms, 在所有 java 提交中击败了6.62%的用户
     * 内存消耗 : 36 MB, 在所有 java 提交中击败了45.50%的用户
     *
     * 将左括号作为key, 右括号作为value一对一对存入map中.
     * 将string转为linkedlist, 遍历linkedlist.
     *      当遇到存在于map中的key时(即左括号), 我们判断它的相邻的 list.get(i + 1) 是否与map.get(key)相等
     *       (此处需先判断i + 1是否大于list.size(), 如果大, 那么证明没有右括号, 不是一个有效的字符串, 返回false, 结束遍历):
     *          如果相等, 从list中移去i即i+1所在位置的对象;
     *          如果不相等, 那么一定不是一个有效的字符串, 返回false.
     *  当遍历正常完成后, 我们可认为这是一个有效的字符串. 因为如果不是一个有效的字符串, 一定会在中途结束.
     *
     */
    public boolean isValid(String s) {
        if ( s.length() % 2 != 0 ) {
            return false;
        }
        HashMap<String, String> map = new HashMap() {
            {
                put("(", ")");
                put("[", "]");
                put("{", "}");
            }
        };
        LinkedList<String> chars = new LinkedList(Arrays.asList(s.split("")));
        for (int i = chars.size() - 1; i >= 0; i--) {
            if ( map.containsKey(chars.get(i)) ) {
                if ( i + 1 >= chars.size() || !map.get(chars.get(i)).equals(chars.get(i + 1)) ) {
                    return false;
                }
                chars.remove(i);
                chars.remove(i);
            }
        }
        return true;
    }

    /**
     * todo 可优化
     * 执行用时 : 13 ms, 在所有 java 提交中击败了9.53%的用户
     * 内存消耗 : 35.8 MB, 在所有 java 提交中击败了58.09%的用户
     *
     * 将左括号作为key, 右括号作为value一对一对存入map中.
     * 创建一个linkedlist作为栈用于稍后存储数据.
     * 将string转为数组, 遍历数组.
     *      如果当前对象在map中存在该key(即左括号), 我们将它push进栈中;
     *      如果当前对象在map中不存在该key, 我们将栈中对象poll出来, 并判断以poll出来的对象作为key, 从map中取出的value值与当前对象是否相等.
     *          如果不相等, 返回false.
     * 当遍历正常完成后, 判断栈长度: 如果大于0, 返回false; 否则返回true.
     *
     */
    public boolean isValid2(String s) {
        if ( s.length() % 2 != 0 ) {
            return false;
        }
        if ( s.length() == 0 ) {
            return true;
        }
        HashMap<String, String> map = new HashMap() {
            {
                put("(", ")");
                put("[", "]");
                put("{", "}");
            }
        };
        LinkedList<String> list = new LinkedList<>();
        String[] strings = s.split("");
        for (int i = 0; i < strings.length; i++) {
            if ( map.containsKey(strings[i]) ) {
                list.push(strings[i]);
            } else {
                if ( !strings[i].equals(map.get(list.poll())) ) {
                    return false;
                }
            }
        }
        if ( list.size() > 0 ) {
            return false;
        }
        return true;
    }

    @Test
    public void testIsValid(){
        System.out.println(isValid2(""));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
