class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode current = queue.poll();
                level.add(current.val);

                if(current.left != null){
                    queue.offer(current.left);
                }

                if(current.right != null){
                    queue.offer(current.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
