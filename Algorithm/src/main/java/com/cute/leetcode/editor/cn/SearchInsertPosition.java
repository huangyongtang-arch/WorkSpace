//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 569 👎 0

package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();

        System.out.println(solution.searchInsert(new int[]{1,3,5,7},2));
        System.out.println(solution.searchInsert(new int[]{1,3,5,7,9},10));
        System.out.println(solution.searchInsert(new int[]{1,3,5,7,9},8));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int mid,res=nums.length;
        while(i<=j){
            mid=((j-i)>>1)+i;
            if (nums[mid]<target){
                i=mid+1;
            }if (nums[mid]>=target){
                res=mid;
                j=mid-1;
            }
        }
        return res;

        }

//        List<Integer> list= new ArrayList<>();
//        list= Arrays.stream(nums).boxed().collect(Collectors.toList());
//        list.add(target);
//        list.sort((x,y)->x-y);
//        return list.indexOf(target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

