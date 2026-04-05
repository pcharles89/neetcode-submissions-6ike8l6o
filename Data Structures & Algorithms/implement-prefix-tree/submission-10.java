class PrefixTree {

    private PrefixTreeNode root;

    public PrefixTree() {
        root = new PrefixTreeNode();
    }

    public void insert(String word) {
        PrefixTreeNode curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new PrefixTreeNode();
            }
            
            curr = curr.children[index];
        }

        curr.isWord = true;

    }

    public boolean search(String word) {
        PrefixTreeNode node = findNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    public PrefixTreeNode findNode(String str){
        PrefixTreeNode curr = root;

        for(char c : str.toCharArray()){
            int index = c - 'a';

            if(curr.children[index] == null){
                return null;
            }

            curr = curr.children[index];
        }

        return curr;
    }

    private static class PrefixTreeNode{
        PrefixTreeNode[] children;
        boolean isWord;

        PrefixTreeNode(){
            children = new PrefixTreeNode[26];
            isWord = false;
        }
    }
}
