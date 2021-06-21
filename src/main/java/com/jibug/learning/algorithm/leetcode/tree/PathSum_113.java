package com.jibug.learning.algorithm.leetcode.tree;

import com.jibug.learning.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: PathSum_113.java
 * @Package com.jibug.learning.algorithm.leetcode.tree
 * @Description:
 * @Author: 0003613 heyingcai
 * @Date: 2021-06-17 13:56
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class PathSum_113 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> data) {
        if (root == null) {
            return;
        }
        data.add(root.value);
        sum = sum - root.value;
        if (sum == 0 && (root.left == null && root.right == null)) {
            result.add(new ArrayList<>(data));
        }
        dfs(root.left, sum, data);
        dfs(root.right, sum, data);
        data.remove(data.size() - 1);
    }

}
