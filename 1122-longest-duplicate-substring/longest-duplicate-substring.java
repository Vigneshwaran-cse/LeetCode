import java.util.*;

class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int base = 26;
        long mod = (1L << 31) - 1;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - 'a';
        }

        int left = 1, right = n;
        int start = -1, maxLen = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int idx = check(nums, mid, base, mod, s);
            if (idx != -1) {
                start = idx;
                maxLen = mid;
                left = mid + 1;   // try longer
            } else {
                right = mid - 1;  // try shorter
            }
        }
        return start == -1 ? "" : s.substring(start, start + maxLen);
    }

    private int check(int[] nums, int len, int base, long mod, String s) {
        long hash = 0, power = 1;
        for (int i = 0; i < len; i++) {
            hash = (hash * base + nums[i]) % mod;
            power = (power * base) % mod;
        }
        Map<Long, List<Integer>> seen = new HashMap<>();
        seen.put(hash, new ArrayList<>(Arrays.asList(0)));

        for (int i = len; i < nums.length; i++) {
            hash = (hash * base + nums[i]) % mod;
            hash = (hash - nums[i - len] * power % mod + mod) % mod;

            if (seen.containsKey(hash)) {
                for (int start : seen.get(hash)) {
                    if (s.substring(start, start + len).equals(s.substring(i - len + 1, i + 1))) {
                        return start;
                    }
                }
            }
            seen.computeIfAbsent(hash, k -> new ArrayList<>()).add(i - len + 1);
        }
        return -1;
    }
}
