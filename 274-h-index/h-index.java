class Solution {
    public int hIndex(int[] citations) {
        int size = citations.length;
        int[] counts = new int[size + 1];

        for (int i = 0; i < size; i++) {
            int cur = Math.min(size, citations[i]);
            counts[cur]++;
        }

        int indx = size;
        int count = 0;

        for (int i = size; i >= 0; i--) {
            int cur = counts[i];
            count += cur;
            if (count >= indx) {
                return indx;
            }
            indx--;
        }

        return 0;
    }
}