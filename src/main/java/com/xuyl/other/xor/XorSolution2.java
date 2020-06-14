package com.xuyl.other.xor;

// 一个数组，里面有两个数出现了奇数次，其他数都是出现偶数次，请把这两个出现奇数次的数找出来。

import com.xuyl.anno.Done;
import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: yaling.xu
 * @signature 天王盖地虎，胖墩吃脑腐。
 * @date: 2020/6/8 20:03
 */
@Done
public class XorSolution2 {

    @Test
    public void test() {
        int[] num = {3, 5, 3, 2, 3, 2, 5, 6};
        findNum(num);
    }

    /**
     * 1. 遍历一次对所有数都进行异或，最终得到的结果将是出现奇数次的数进行异或的结果。即xor = a ^ b
     * 2. 得到xor后如何求a, b ? 根据异或特性，只要求出了其中一个，那么另一个也能通过 b = xor ^ a 得到。
     * 3. 如何求a ? 根据异或特性，相同为0，相异为1。假设我们能通过xor获取到xor除最低位1外其他位皆为0的数，对于当前为1的那一位，由于是a ^ b得到，说明a, b对于该位一定是一个是0，一个是1。   例：假设xor = 0011 0110, 如果我们能通过运算获得rightOneBit = 0000 0010。 那么根据异或特性，a, b一定是 xxxx xx0x, xxxx xx1x。
     * 4. 根据3， 我们只需要通过一种运算，使num[i]与rightOneBit进行运算能区分开低位1是0或1的一波，仅将这一波数字与原xor进行异或，由于出现偶数次的会互相抵消，最后得到的结果就是我们需要求的a或b了。
     * 5. 如何根据xor获取仅有一位为1的数字？  xor = xor & (~xor + 1)  原因：根据&特性，有一个为0则是0，两个都是1才是1. 对xor取反后与自身进行&，那么一定是0，因为每一位都是相反的，必有其一是0. 而将xor进行取反+1操作，则先将原本是0的位数变为1，最低位为1的变为了0，当+1后，正好向前进位，低位1全都变成了0，最低位的0晋升为了1. 这样与自身进行与后，正好保留了最低位的1。
     * 6. 如何将数组中低位1那一位是0和1的区分开？ rightOneBit & num[i] != 0 则过滤出了低位1的那一位是1的数字。
     *
     * @param numArr
     */
    public void findNum(int[] numArr) {
        int xor = 0;
        for (int i = 0; i < numArr.length; i++) {
            xor ^= numArr[i];
        }
//        System.out.println(xor);
        int num1 = xor;
        int rightOne = num1 & (~num1 + 1);
        for (int i = 0; i < numArr.length; i++) {
            if ((rightOne & numArr[i]) != 0) {
                num1 ^= numArr[i];
            }
        }
        System.out.println("num1 = " + num1 + ", num2 = " + (xor ^ num1));
    }
}