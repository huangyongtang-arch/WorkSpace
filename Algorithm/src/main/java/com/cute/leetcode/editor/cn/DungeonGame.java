//
//
// 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿
//过地下城并通过对抗恶魔来拯救公主。 
//
// 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。 
//
// 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么
//包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。 
//
// 为了尽快到达公主，骑士决定每次只向右或向下移动一步。 
//
// 
//
// 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。 
//
// 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。 
//
// 
// 
// -2 (K) 
// -3 
// 3 
// 
// 
// -5 
// -10 
// 1 
// 
// 
// 10 
// 30 
// -5 (P) 
// 
// 
//
//
// 
//
// 说明: 
//
// 
// 
// 骑士的健康点数没有上限。 
// 
// 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。 
// Related Topics 二分查找 动态规划 
// 👍 317 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Arrays;

public class DungeonGame {
    public static void main(String[] args) {
        Solution solution = new DungeonGame().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        return 0;
    }

        /**
         * 我们希望「从出发点到当前点的路径和」尽可能大，而「从出发点到当前点所需的最小初始值」尽可能小。这两条路径各有优劣。
         *
         * 在上图中，我们知道应该选取绿色路径，因为蓝色路径的路径和太小，使得蓝色路径需要增大初始值到 44 才能走到终点，
         *
         * 而绿色路径只要 33 点初始值就可以直接走到终点。但是如果把终点的 -2−2 换为 00，蓝色路径只需要初始值 22，绿色路径仍然需要初始值 33，
         *
         * 最优决策就变成蓝色路径了。
         *
         * 因此，如果按照从左上往右下的顺序进行动态规划，我们无法直接确定到达 (1,2)(1,2) 的方案，
         *
         * 因为有两个重要程度相同的参数同时影响后续的决策。也就是说，这样的动态规划是不满足「无后效性」的。
         *
         * 于是我们考虑从右下往左上进行动态规划。令 dp[i][j]dp[i][j] 表示从坐标 (i,j)(i,j) 到终点所需的最小初始值。
         *
         * 换句话说，当我们到达坐标 (i,j)(i,j) 时，如果此时我们的路径和不小于 dp[i][j]dp[i][j]，我们就能到达终点。
         *
         * 这样一来，我们就无需担心路径和的问题，只需要关注最小初始值。对于 dp[i][j]dp[i][j]，我们只要关心 dp[i][j+1]dp[i][j+1]
         *
         * 和 dp[i+1][j]dp[i+1][j] 的最小值 \textit{minn}minn。记当前格子的值为 \textit{dungeon}(i,j)dungeon(i,j)，
         *
         * 那么在坐标 (i,j)(i,j) 的初始值只要达到 \textit{minn}-\textit{dungeon}(i,j)minn−dungeon(i,j) 即可。
         *
         * 同时，初始值还必须大于等于 11。这样我们就可以得到状态转移方程：
         *
         * dp[i][j] = \max(\min(dp[i+1][j], dp[i][j + 1]) - \textit{dungeon}(i, j), 1)
         * dp[i][j]=max(min(dp[i+1][j],dp[i][j+1])−dungeon(i,j),1)
         *
         * 最终答案即为 dp[0][0]dp[0][0]。
         *
         * 边界条件为，当 i=n-1i=n−1 或者 j=m-1j=m−1 时，dp[i][j]dp[i][j] 转移需要用到的 dp[i][j+1]dp[i][j+1] 和 dp[i+1][j]dp[i+1][j]
         *
         * 中有无效值，因此代码实现中给无效值赋值为极大值。特别地，dp[n-1][m-1]dp[n−1][m−1] 转移需要用到的 dp[n-1][m]dp[n−1][m]
         *
         * 和 dp[n][m-1]dp[n][m−1] 均为无效值，因此我们给这两个值赋值为 11。
         *
         * @param dungeon
         * @return
         */
        public int calculateMinimumHP1(int[][] dungeon) {
            int n = dungeon.length, m = dungeon[0].length;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; ++i) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[n][m - 1] = dp[n - 1][m] = 1;
            for (int i = n - 1; i >= 0; --i) {
                for (int j = m - 1; j >= 0; --j) {
                    int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(minn - dungeon[i][j], 1);
                }
            }
            return dp[0][0];
        }

        /**
         * 深度优先搜索+记忆化
         */
        int[][] memo; // 定义记忆化数组
        public int calculateMinimumHP2(int[][] dungeon) {
            memo = new int[dungeon.length][dungeon[0].length];
            return dfs(dungeon, dungeon.length, dungeon[0].length, 0, 0);
        }

        private int dfs(int[][] dungeon, int m, int n, int i, int j) {
            // 到达终点，递归终止。
            if (i == m - 1 && j == n - 1) {
                return Math.max(1 - dungeon[i][j], 1);
            }
            // 如果memo数组中有值，直接取出并返回，不进行后续的搜索。
            if (memo[i][j] > 0) {
                return memo[i][j];
            }
            // 同解法一，向右搜+向下搜
            int minRes = 0;
            if (i == m - 1) {
                minRes =  Math.max(dfs(dungeon, m, n, i, j + 1) - dungeon[i][j], 1);
            } else if (j == n - 1) {
                minRes = Math.max(dfs(dungeon, m, n, i + 1, j) - dungeon[i][j], 1);
            } else {
                minRes = Math.max(Math.min(dfs(dungeon, m, n, i + 1, j), dfs(dungeon, m, n, i, j + 1)) - dungeon[i][j], 1);
            }
            // 将结果存入memo数组
            return memo[i][j] = minRes;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}