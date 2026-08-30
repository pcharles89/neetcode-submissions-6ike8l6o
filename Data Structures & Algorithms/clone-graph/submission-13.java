class Solution {

    Map<Node, Node> oldToNew = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        if(oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        
        oldToNew.put(node, copy);

        for(Node neighbor : node.neighbors){
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
}