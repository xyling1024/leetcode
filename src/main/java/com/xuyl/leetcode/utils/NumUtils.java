package com.xuyl.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 工具类
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2019/10/18 11:15
 */
public class NumUtils {

    /**
     * 求一个数N的所有约数。
     * 我们只需要将N开方sqrt(N)，然后遍历2~sqrt(N), 如果N能整除遍历到的数i，那么这个除数i和商N/i都是约数。
     * @param n  n > 0
     * @return 返回一个数的所有约数(包括1和它本身)。
     */
    public static List<Integer> divisorNum(int n) {
        List<Integer> numList = new ArrayList<>();
        if (n == 0) return numList;
        double length = Math.sqrt(n);
        for (int i = 1; i <= length; i++) {
            if (n%i == 0) {
                numList.add(i);
                int j = n/i;
                if (j != i) {
                    numList.add(j);
                }
            }
        }
        return numList;
    }
}