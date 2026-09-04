import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], x -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        // Min-heap: [cost, city, stops]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});

        // Track best cost with stops
        int[][] dist = new int[n][k+2];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], city = cur[1], stops = cur[2];

            if (city == dst) return cost;
            if (stops > k) continue;

            if (!graph.containsKey(city)) continue;
            for (int[] nei : graph.get(city)) {
                int nextCity = nei[0], price = nei[1];
                int newCost = cost + price;
                if (newCost < dist[nextCity][stops+1]) {
                    dist[nextCity][stops+1] = newCost;
                    pq.offer(new int[]{newCost, nextCity, stops+1});
                }
            }
        }
        return -1;
    }
}

