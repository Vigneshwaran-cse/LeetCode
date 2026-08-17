class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        // Outer loop: start index of subarray
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            // Inner loop: end index of subarray
            for (int j = i; j < nums.length; j++) {
                sum += nums[j]; // add current element

                // Check if subarray sum equals k
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
