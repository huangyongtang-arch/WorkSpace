//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 304 👎 0

package com.cute.leetcode.editor.cn;

import java.util.*;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        int[] res1=solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] res2=solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        Arrays.stream(res1).forEach(System.out::println);
        System.out.println();
        Arrays.stream(res2).forEach(System.out::println);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * @Wrong
         * @param nums1
         * @param nums2
         * @return
         */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    list.add(nums1[i]);
                    break;
                }
            }
        }
//list通过stream转成流，再通过mapToInt把stream(Integer)调用Integer::valueOf转成IntStream在toArray()成数组;
        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }

        /**
         * 通过哈希表计算值是否大于一的，大于一的值在另一个数组存在，则可以添加到结果集
         * @param nums1
         * @param nums2
         * @return
         */
    public int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i:nums1){
            count = map.getOrDefault(i,0)+1;
            map.put(i,count);
        }
        int[] res = new int[nums1.length];
        int j=0;
        for(int i:nums2){
            count=map.getOrDefault(i,0);
            if(count>0){
                res[j] = i;
                j++;
                count--;
                if(count>0){
                    map.put(i,count);
                }else{
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(res,0,j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}