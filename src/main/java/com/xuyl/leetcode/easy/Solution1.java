package com.xuyl.leetcode.easy;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {

    /**
     * 思考: 是否可以新建一个string数组, 该数组按照nums成员顺序排序, 并且其中存放的对象格式为: nums[i]_index
     * 这样我们再次使用指针挪移的方式找到两个数值后, 直接就能取出这两个数值在原数组中对应的索引了, 而不用再遍历一遍!!
     *
     * error: 超出时间限制
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        LinkedList<String> numsIndex = new LinkedList<>();
        // 排序
        int numsj;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ( j >= numsIndex.size() ) {
                    numsIndex.addLast(nums[i] + "_" + i);
                    break;
                } else if ( nums[i] < (numsj = Integer.valueOf(numsIndex.get(j).split("_")[0])) ) {
                    numsIndex.add(j, nums[i] + "_" + i);
                    break;
                }
            }
        }
        // 使用指针挪移的方式获取相加可得到target的两个数
        int i = 0, j = numsIndex.size() - 1;
        while (i < j) {
            String[] s1 = numsIndex.get(i).split("_");
            String[] s2 = numsIndex.get(j).split("_");
            int num1 = Integer.valueOf(s1[0]);
            int num2 = Integer.valueOf(s2[0]);
            int sum = num1 + num2;
            if ( sum == target ) {
                result[0] = Integer.valueOf(s1[1]);
                result[1] = Integer.valueOf(s2[1]);
                break;
            } else if ( sum < target ) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }


    /**
     * todo 可优化
     * 执行用时 :47 ms, 在所有 java 提交中击败了34.47%的用户
     * 内存消耗 :37.4 MB, 在所有 java 提交中击败了89.43%的用户
     *
     * 将原数组copy一份, 然后对原数组进行排序. 以数组指针挪移的方式, 找到两个相加后和为target的数值;
     * 然后对copy出的数组遍历, 找到这两个数所在的索引;
     */
    public int[] twoSum(int[] nums, int target) {
        int[] originNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if ( sum == target ) {
                break;
            } else if ( sum < target ) {
                i++;
            } else {
                j--;
            }
        }
        Map<String, Integer> map = new HashMap();
        for (int z = 0; z < originNums.length; z++) {
            if ( originNums[z] == nums[i] && !map.containsKey("i") ) {
                map.put("i", z);
            } else if (  originNums[z] == nums[j] && !map.containsKey("j") ) {
                map.put("j", z);
            }
            if ( map.containsKey("i") && map.containsKey("j") ) {
                break;
            }
        }
        return map.values().stream().mapToInt(Integer::valueOf).toArray();
    }

    @Test
    public void testTwoSum2() {
        int[] nums = {3, 3};
        String[] numsIndex = new String[nums.length];
        nums = twoSum2(nums, 6);
        System.out.println(nums[0] + ":" + nums[1]);
    }

    @Test
    public void testTwoSum() {
        int[] nums = {-1,-2,-3,-4,-5};
        nums = twoSum(nums, -8);
        System.out.println(nums[0] + ":" + nums[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
