import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // If start or end is blocked
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        // Directions: 8 possible moves
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},
                        {1,1},{1,-1},{-1,1},{-1,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1}); // row, col, pathLength
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], len = cur[2];
            
            // If reached destination
            if (r == n-1 && c == n-1) return len;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    !visited[nr][nc] && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, len+1});
                }
            }
        }
        
        return -1; // no path
    }
}