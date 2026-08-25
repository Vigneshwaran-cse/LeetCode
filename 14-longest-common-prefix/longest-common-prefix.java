class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the prefix
        String prefix = strs[0];

        // Compare with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix
            while (!strs[i].startsWith(prefix)) {
                // Shorten the prefix by removing the last character
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
