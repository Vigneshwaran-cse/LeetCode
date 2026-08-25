class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Step 1: Count frequency of characters in t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding window setup
        Map<Character, Integer> have = new HashMap<>();
        int required = need.size();   // distinct chars needed
        int formed = 0;               // distinct chars matched
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        // Step 3: Expand window with right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            have.put(c, have.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && have.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Step 4: Contract window from left if all chars matched
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char lc = s.charAt(left);
                have.put(lc, have.get(lc) - 1);
                if (need.containsKey(lc) && have.get(lc) < need.get(lc)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
