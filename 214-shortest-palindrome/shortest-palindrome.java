class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        // Compute KMP prefix table
        int[] lps = new int[combined.length()];
        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // lps[combined.length()-1] gives longest palindromic prefix length
        int longestPrefix = lps[combined.length() - 1];
        String add = rev.substring(0, rev.length() - longestPrefix);
        return add + s;
    }
}
