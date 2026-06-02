class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            if(!uf.union(a, b)){
                return edge;
            }
        }

        return new int[0];
    }

    class UnionFind{
        private int[] parent;
        private int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY){
                return false;
            }

            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }
            else if(rank[rootY] > rank[rootX]){
                parent[rootX] = rootY;
            }
            else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }
    }
}
