package com.jibug.learning.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum_18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int l, k;
        for (int i = 0; i < nums.length -3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length -2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                l = j + 1;
                k = nums.length - 1;
                while (l < k) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[k];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[k]));
                        while (l < k && nums[l] == nums[l+1]) {
                            l++;
                        }
                        while (l < k && nums[k] == nums[k-1]) {
                            k--;
                        }
                        l++;
                        k--;
                    }else if (sum < target) {
                        l++;
                    }else {
                        k--;
                    }

                }
            }

        }
        return result;
    }

    public static List<List<Integer>> fourSum_1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        int n = nums.length;
        //(1)先对数组进行降序排序
        Arrays.sort(nums);
        //(2)遍历[0~n-3)个元素，即【四个元素中左第一个元素】
        for (int i = 0; i < n - 3; i++) {
            //去重1：起点是0，当i==i-1时，说明i-1已经计算过，跳过i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            //剪枝1：当当前i为起点的最左边四个元素（降序）总和都比target大时，后续的遍历更大，直接break
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target)
                break;

            //剪枝2：当当前i为起点的元素+最右边三个元素之和都比target小时，以i为起点的遍历不可能比target大，跳过i
            int max = nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (max < target)
                continue;

            //(3)遍历[i~n-2)个元素，即【四个元素中左第二个元素】
            for (int j = i + 1; j < n - 2; j++) {
                //去重2：起点是i+1，当j==j-1时，说明i-1已经计算过，跳过i
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                //剪枝3：同剪枝1思想，只是起点是第二个元素即j
                min = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min > target)
                    break;

                //剪枝4：同剪枝2思想，只是起点是第二个元素即j
                max = nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (max < target)
                    continue;

                //(4)双指针，查找等于target的值，思想同题目【三数之和】
                //left对应【四个元素的左第三个元素】
                int left = j + 1;
                //right对应【四个元素的左第四个元素】
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重3：当四个元素的左第三个元素存在重复，跳过
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        //去重4：当四个元素的左第四个元素存在重复，跳过
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-3,-2,-1,0,0,1,2,3};
        System.out.println(fourSum_1(a,0));
        System.out.println(fourSum(a,0));
    }
}
