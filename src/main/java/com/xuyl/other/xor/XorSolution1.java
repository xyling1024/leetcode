package com.xuyl.other.xor;

// 一个数组，里面有一个数出现了奇数次，其他数都是出现偶数次，请把这一个出现奇数次的数找出来。

import com.xuyl.anno.Done;
import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2020/6/8 20:03
 */
@Done
public class XorSolution1 {

    @Test
    public void test() {
        int[] num = {3, 5, 3, 2, 6, 3, 2, 5, 6};
        findNum(num);
    }

    /**
     * 通过异或特性，从头到尾全部异或得到的结果，偶数次出现的数一定会被消掉，最后剩下的就是出现奇数次的结果了。
     * @param numArr
     */
    public void findNum(int[] numArr) {
        int num = 0;
        for (int i = 0; i < numArr.length; i++) {
            num ^= numArr[i];
        }
        System.out.println(num);
    }
}