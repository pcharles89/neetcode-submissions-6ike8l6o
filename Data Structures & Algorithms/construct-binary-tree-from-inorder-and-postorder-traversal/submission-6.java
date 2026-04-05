class Solution {
    int postIndex;
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right){
        if(left > right){
            return null;
        }

        int rootVal = postorder[postIndex];
        postIndex--;

        TreeNode root = new TreeNode(rootVal);
        int inOrderIndex = inOrderMap.get(rootVal);

        root.right = build(inorder, postorder, inOrderIndex + 1, right);
        root.left = build(inorder, postorder, left, inOrderIndex - 1);
        
        return root;
    }
}