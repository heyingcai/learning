package com.jibug.learning.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge_56 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        System.out.println(Arrays.toString(merge(a)));
    }

    public static int[][] merge(int[][] intervals) {
        // 按照起始位置升序排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int i = -1;
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            // 如果此时结果集没有数据的话，直接加入结果集
            // 如果当前区间的起始值大于结果集的结束值，则证明没有重叠，直接加入结果集
            if (result.isEmpty() || interval[0] > result.get(i)[1]) {
                result.add(interval);
                i++;
            } else {
                // 走到这里，说明有重复区间，则取：结果集和当前区间的结束值最大的那个
                result.get(i)[1] = Math.max(result.get(i)[1], interval[1]);
            }
        }
        int[][] res = new int[result.size()][2];
        for (int j = 0; j < result.size(); j++) {
            res[j] = result.get(j);
        }
        return res;
    }

}
