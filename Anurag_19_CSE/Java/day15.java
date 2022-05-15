//Link For Problem : https://leetcode.com/problems/deepest-leaves-sum/

import java.util.LinkedList;
import java.util.Queue;

public class day15 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * First Solution Involves BFS traversal.
     * 
     * Keep a sum pointer and keep resetting it to 0
     * in each iteration.
     * By this, sum will only contain the sum of deepest leaves(leaf nodes) after
     * the loop ends.
     * 
     * TC : O(n)
     * 
     * SC : O(n)
     */

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0;

            while (size-- > 0) {
                TreeNode temp = q.poll();
                sum += temp.val;

                if (temp.left != null)
                    q.offer(temp.left);

                if (temp.right != null)
                    q.offer(temp.right);
            }
        }

        return sum;
    }

    /*
     * Second Solution involves DFS traversal.
     * 
     * Maintain a deep variable pointing to the deepest level currently processed.
     * Maintain a depth variable pointing to the current level being processed.
     * Rest is Self Explanatory.
     * 
     * TC : O(n)
     * 
     * SC : O(1)
     */

    int deep = 0, sum;

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        return dfsHelper(root, 0);
    }

    private int dfsHelper(TreeNode root, int depth) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {

            if (depth == deep) {
                sum += root.val;
            } else if (depth > deep) {
                deep = depth;
                sum = root.val;
            }
        }

        dfsHelper(root.left, depth + 1);
        dfsHelper(root.right, depth + 1);

        return sum;
    }
}
