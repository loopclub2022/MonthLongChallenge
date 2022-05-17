// link: https://leetcode.com/problems/deepest-leaves-sum/
// 1302. Deepest Leaves Sum
/*
    Approach: Traverse Level order and sum each leve individually and store return the last sum.
    T: O(N)
    S: O(N)
*/
class Solution {    
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(root);
        q.add(null);
        int sum = 0;
        // res.add(root.val);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr == null){
                
                sum = 0;
                for(int i=0; i<res.size(); i++){
                    sum += res.get(i);
                }
                // System.out.print(sum+" ");
                res.clear();
                if(q.isEmpty()) break;
                q.add(null);
                continue;
            }
            res.add(curr.val);

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            
        }
        return sum;
    }
}
/*
        Approach:
        T: O(2N) = O(N)
        S: O(1)
        Find the depth of the tree.
        Then traverse and add the value of the nodes at depth level to the answer.

class Solution {
    private int depth = 0, maxDepth = 0;
    private void getDepth(TreeNode root){
        if(root == null) return;
        depth++;
        maxDepth = Math.max(depth, maxDepth);
        getDepth(root.left);
        getDepth(root.right);
        depth--;
    }
    private int sum = 0, dep = 0;
    private int getSum(TreeNode root){ 
        if(root==null) return sum;
        dep++;
        getSum(root.left);
        if(dep == maxDepth){
            sum += root.val;
        }
        getSum(root.right);
        dep--;
        return sum;
    }
    public int deepestLeavesSum(TreeNode root) {
        getDepth(root);
        return getSum(root);
    }
}
*/