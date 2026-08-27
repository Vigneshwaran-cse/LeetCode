class Solution {
    public int kthGrammar(int n, int k) {
         if (n == 1) {
            return 0;
        }

        // Find the midpoint of current row
        int mid = (int) Math.pow(2, n - 2);

        if (k <= mid) {
            // First half → same as previous row
            return kthGrammar(n - 1, k);
        } else {
            // Second half → flipped value of previous row
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }
    }