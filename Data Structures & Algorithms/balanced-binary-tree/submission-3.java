class Solution {
    public boolean isBalanced(TreeNode root) {
        return dsf(root) != -1;
    }

    private int dsf(TreeNode root){
        if(root == null){
            return 0;
        }

        int rightHeight = dsf(root.right);
        if(rightHeight == -1){
            return -1;
        }

        int leftHeight = dsf(root.left);
        if(leftHeight == -1){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return 1 + (Math.max(leftHeight, rightHeight));
        
    }
}
