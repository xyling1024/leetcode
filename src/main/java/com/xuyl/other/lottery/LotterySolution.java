package com.xuyl.other.lottery;

// 有1~36个数，用户从中选取其中6个数，作为彩票组合。
// 开奖也是选取6个数，顺序不论，如果开奖时用户与奖号所有数都对上了，那么是一等奖；如果仅有一个数不同，则是二等奖。
//
// 请实现一种方案，使每次开奖一定不会有一等奖产生，二等奖的获得者不超过十个。


import com.xuyl.anno.Todo;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description: 彩票问题
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2020/6/8 19:49
 */
@Todo
public class LotterySolution {

    public static final Random r = new Random();

    /**
     * 尝试使用排序的方法找到规律获取不能超过10个二等奖的数
     */
    @Todo
    public void sortTest() {
        Set<Set<Integer>> totalSet = new TreeSet<>((x1, x2) -> {
            Iterator<Integer> iterator1 = x1.iterator();
            Iterator<Integer> iterator2 = x2.iterator();
            int n = 0;
            while (iterator1.hasNext() && n == 0) {
                n = iterator1.next() - iterator2.next();
            }
            return n;
        });
        for (int i = 0; i < 10000; i++) {
            totalSet.add(getNum());
        }
        totalSet.forEach(x -> System.out.println(x));
    }

    /**
     * 模拟从1~18中获取6个数字，并排序
     * @return
     */
    private static Set<Integer> getNum() {
        Set<Integer> numSet = new TreeSet<>((x1, x2) -> x1 - x2);
        while (numSet.size() < 6) {
            int num = r.nextInt(18) + 1;
            if (numSet.contains(num)) {
                continue;
            }
            numSet.add(num);
        }
        return numSet;
    }
}