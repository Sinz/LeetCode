package com.leetcode;
//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 1262 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_101_SymmetricTree {
    private Deque<Integer> stack = new ArrayDeque<>();
    public boolean isSymmetric(TreeNode root) {
        if( root.left != root.right ){
            return false;
        }

        boolean res = true;
        dfsLeft(root.left);
        return dfsRight(root.right,res);

    }

    public boolean dfsRight(TreeNode root,boolean res){
        if( root == null ){
            return true;
        }

        if( stack.pop() == root.val){
            dfsRight(root.left, res);
            dfsRight(root.right,res);
        }else{
            res = false;
        }

        return res;
    }

    public void dfsLeft(TreeNode root){

        if( root == null ){
            return;
        }

        stack.push(root.val);
        dfsLeft(root.left);
        dfsLeft(root.right);


    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
