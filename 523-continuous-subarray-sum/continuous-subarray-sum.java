import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map to store remainder and earliest index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case: sum=0 at index -1

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            // If remainder seen before, check distance
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
