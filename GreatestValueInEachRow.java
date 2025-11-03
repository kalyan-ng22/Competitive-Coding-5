// Time Complexity : O(n).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : I followed BFS in solving this problem, at each level calculated the max of the node values. Each level can be differentiated by size level, so
// intialized max variable before each level traversal, calculated max and added to the result.

class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            int maxAtLevel = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){ //each level traversal
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.add(curr.left);
                    maxAtLevel = Math.max(maxAtLevel, curr.left.val); //calculate max for each left child
                }
                if(curr.right != null){
                    queue.add(curr.right);
                    maxAtLevel = Math.max(maxAtLevel, curr.right.val);//calculate max for each right child
                }

            }
            result.add(maxAtLevel);
        }
        result.remove(result.size()-1);//remove last element as we do the check at leaf nodes as well.
        return result;
    }
}