import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = (n - 1) / 2;  // middle of left half
        int right = n - 1;       // end of right half

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--];   // smaller numbers
            } else {
                nums[i] = sorted[right--];  // larger numbers
            }
        }
    }
}
