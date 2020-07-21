//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找 
// 👍 331 👎 0

package com.cute.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
//        int[]res1 = solution.twoSum(new int[]{2, 7, 11, 15},9);
        int[]res2 = solution.twoSum(new int[]{5,25,75},
        100);
        Arrays.stream(res2).forEachOrdered(System.out::println);
        System.out.println("");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 二分
         * 时间复杂度：O(n \log n)O(nlogn)，其中 nn 是数组的长度。需要遍历数组一次确定第一个数，
         * 时间复杂度是 O(n)O(n)，寻找第二个数使用二分查找，时间复杂度是 O(\log n)O(logn)，因此总时间复杂度是 O(n \log n)O(nlogn)。
         *
         * 空间复杂度：O(1)O(1)。
         *
         * @answer
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum1(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; ++i) {
                int low = i + 1, high = numbers.length - 1;
                while (low <= high) {
                    int mid = (high - low) / 2 + low;
                    if (numbers[mid] == target - numbers[i]) {
                        return new int[]{i + 1, mid + 1};
                    } else if (numbers[mid] > target - numbers[i]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return new int[]{-1, -1};
        }

        /**
         * 栓指针
         *
         * 时间复杂度：O(n)O(n)，其中 nn 是数组的长度。两个指针移动的总次数最多为 nn 次。
         *
         * 空间复杂度：O(1)O(1)。
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum2(int[] numbers, int target) {
            int low = 0, high = numbers.length - 1;
            while (low < high) {
                int sum = numbers[low] + numbers[high];
                if (sum == target) {
                    return new int[]{low + 1, high + 1};
                } else if (sum < target) {
                    ++low;
                } else {
                    --high;
                }
            }
            return new int[]{-1, -1};
        }

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 299 ms
         * , 在所有 Java 提交中击败了
         * 5.22%
         * 的用户
         * 内存消耗：
         * 40.2 MB
         * , 在所有 Java 提交中击败了
         * 6.67%
         * 的用户
         * @param numbers
         * @param target
         * @return
         */
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        int sum=target;
        int[] res=new int[2];
//        双指针
        while(i<j){
//            如果i比结果大，直接结束
            if (numbers[i]>target){
                return null;
            }
//            开始计算
            sum-=numbers[i];
//            System.out.println(sum+"，"+numbers[i]);
            int tmp=j;
//            开始循环遍历j，如果没能找到，则i++然后再次遍历j
            while (sum!=numbers[j]){
                j--;
                if (j<0){
                    j=tmp;
                    break;
                }
            }

//            找到了，就结束
            if (sum==numbers[j]) {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }

            i++;
            sum=target;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}