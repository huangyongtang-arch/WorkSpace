//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 201 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int res[]=solution.intersection1(new int[] {61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81},
                                        new int[] {5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48});
        int res2[]=solution.intersection1(new int[] {4,9,5},new int[] {9,4,9,8,4});
        int res3[]=solution.intersection1(new int[] {2,1},new int[] {1,1});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println();
        Arrays.stream(res2).forEach(System.out::print);
        System.out.println();
        Arrays.stream(res3).forEach(System.out::print);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * [61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,
         * 7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,
         * 43,81,88,60,10,55,66,82,0,79,11,81]
         * [5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48]
         * 输出
         * [4,5,7,57,89,79]
         * 预期结果
         * [61,45,85,89,5,77,92,38,7,34,44,57,4,6,88,0,79]
         * TODO
         * @param nums1
         * @param nums2
         * @return
         */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersection(nums2,nums1);
        }
        Set<Integer> set = new HashSet<>();

        for(int i:nums1) {
            if(set.contains(i)){
                break;
            }
            for(int j=0;j<nums2.length;j++){
                if (i == nums2[j]) {
                    set.add(i);
                    break;
                }
            }
        }

        int[] res = set.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }

        /**
         * @OfficeAnswer1两个数组放在两个set里，用contains方法得出是否有相等的元素，存入结果集
         * @param set1
         * @param set2
         * @return
         */
        public int[] set_intersection1(HashSet<Integer> set1, HashSet<Integer> set2) {
            int [] output = new int[set1.size()];
            int idx = 0;
            for (Integer s : set1)
                if (set2.contains(s)) output[idx++] = s;

            return Arrays.copyOf(output, idx);
        }

        public int[] intersection1(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<Integer>();
            for (Integer n : nums1) set1.add(n);
            HashSet<Integer> set2 = new HashSet<Integer>();
            for (Integer n : nums2) set2.add(n);

            if (set1.size() < set2.size()) return set_intersection1(set1, set2);
            else return set_intersection1(set2, set1);
        }

        /**
         * @OfficeAnswer1使用集合方法retainAll直接取交集
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection2(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<Integer>();
            for (Integer n : nums1) set1.add(n);
            HashSet<Integer> set2 = new HashSet<Integer>();
            for (Integer n : nums2) set2.add(n);

            set1.retainAll(set2);

            int [] output = new int[set1.size()];
            int idx = 0;
            for (int s : set1) output[idx++] = s;
            return output;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}