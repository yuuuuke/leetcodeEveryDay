package com.example.myapplication;

public class leetcode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        read(root1,root2);
        return root1;
    }

    private void read(TreeNode root1, TreeNode root2) {
        if (root1.left == null && root2.left != null) {
            root1.left = root2.left;
        } else if (root1.left != null && root2.left != null) {
            read(root1.left, root2.left);
        }

        root1.val = root1.val + root2.val;

        if (root1.right == null && root2.right != null) {
            root1.right = root2.right;
        } else if (root1.right != null && root2.right != null) {
            read(root1.right, root2.right);
        }
    }
}
