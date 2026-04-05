
class Solution {

    private int diam = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diam;
    }
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        diam = Math.max(diam, left + right);
        return 1 + Math.max(left, right);
        
    }
}
