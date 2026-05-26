class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        dfs(0, adj, visited);

        return visited.size() == n;

    }

    private void dfs(int node, Map<Integer, List<Integer>> adj, Set<Integer> visited){
        if(visited.contains(node)){
            return;
        }

        visited.add(node);

        for(int neighbor : adj.get(node)){
            dfs(neighbor, adj, visited);
        }
    }
}
