package Data_Structure.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    public TreeNode root;

    BinarySearchTree() {

    }

    public TreeNode addBST(TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            root = newNode;
            return root;
        } else {
            TreeNode temp = root;
            while (true) {
                if (newNode.value < temp.value) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        break;
                    }
                    else
                        temp = temp.left;
                }
                else {
                    if (temp.right == null) {
                        temp.right = newNode;
                        break;
                    }
                    else
                        temp = temp.right;
                }
            }
            return root;
        }
    }

    public TreeNode addByRecursion(TreeNode root, int value) {
        if (root == null)
            return new TreeNode(value);

        if (value < root.value) {
            if (root.left == null)
                root.left = new TreeNode(value);
            else
                addByRecursion(root.left, value);
        }
        else {
            if (root.right == null)
                root.right = new TreeNode(value);
            else
                addByRecursion(root.right, value);
        }

        return root;
    }

    public TreeNode findLastLeft(TreeNode root) {
        if (root == null)
            return null;
        TreeNode lastLeft = root;
        while (lastLeft.left != null)
            lastLeft = lastLeft.left;
        return lastLeft;
    }

    public TreeNode findLastRight(TreeNode root) {
        if (root == null)
            return null;
        TreeNode lastRight = root;
        while (lastRight.right != null)
            lastRight = lastRight.right;
        return lastRight;
    }

    public TreeNode deleteBST(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.value)
            root.left = deleteBST(root.left,key);
        else if (key > root.value)
            root.right = deleteBST(root.right,key);
        else {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left != null && root.right == null)
                return root.left;
            else if (root.left == null && root.right != null)
                return root.right;

            /*
            TreeNode lastLeft = findLastLeft(root.right);
            root.value = lastLeft.value;
            root.right = deleteNode(root.right,lastLeft.value);
             */

            TreeNode lastRight = findLastRight(root.left);
            root.value = lastRight.value;
            root.left = deleteBST(root.left, lastRight.value);
        }
        return root;
    }

    public TreeNode searchBST(TreeNode root, int value) {
        if (root == null)
            return null;
        if (value < root.value)
            return searchBST(root.left,value);
        else if (value > root.value)
            return searchBST(root.right,value);
        else
            return root;
    }

    List<Integer> ds = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return ds;
        ds.add(root.value);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ds;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return ds;
        inorderTraversal(root.left);
        ds.add(root.value);
        inorderTraversal(root.right);
        return ds;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return ds;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        ds.add(root.value);
        return ds;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        int result = Math.max(maxLeft,maxRight) + 1;
        return result;
    }

    public boolean duyet(TreeNode curNode, int curSum, int targetSum) {
        if (curNode == null)
            return false;

        curSum += curNode.value;
        if (curNode.left == null && curNode.right == null)
            return curSum == targetSum;

        boolean kqTrai = duyet(curNode.left,curSum,targetSum);
        boolean kqPhai = duyet(curNode.right,curSum,targetSum);
        return kqTrai || kqPhai;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return duyet(root,0,targetSum);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.value == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum - root.value) ||
                hasPathSum(root.right, sum - root.value);
    }
}
