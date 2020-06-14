package com.xuyl.other.xor;

import com.xuyl.anno.Done;
import org.junit.jupiter.api.Test;

/**
 * @description: 两个数互换
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2020/6/8 20:04
 */
@Done
public class ExchangeNumSolution {

    @Test
    public void test() {
        int num1 = 23;
        int num2 = 545;
        xorExchange(num1, num2);
    }

    /**
     * 异或解法，运用特性：a ^ a = 0; a ^ 0 = a; ==> a ^ b ^ a = b
     * @param num1
     * @param num2
     */
    public static void xorExchange(int num1, int num2) {
        System.out.println("before：num1 = " + num1 + ", num2 = " + num2);
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("after：num1 = " + num1 + ", num2 = " + num2);
    }
}