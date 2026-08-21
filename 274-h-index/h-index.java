class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // sort ascending
        int n = citations.length;
        int h = 0;
        
        for (int i = 0; i < n; i++) {
            int candidate = Math.min(citations[i], n - i);
            h = Math.max(h, candidate);
        }
        
        return h;
    }
}
