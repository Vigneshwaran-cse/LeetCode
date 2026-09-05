class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        
        // Initialize parent array
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            
            int pu = find(parent, u);
            int pv = find(parent, v);
            
            if (pu == pv) {
                // u and v already connected → cycle
                return edge;
            }
            parent[pu] = pv; // union
        }
        
        return new int[0]; // should never happen
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // path compression
        }
        return parent[x];
    }
}
