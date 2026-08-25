class Solution {
    public String longestPalindrome(String s) {
        String ans = "";    
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome (center at i)
            ans = expandAndUpdate(s, i, i, ans);
            // Even-length palindrome (center between i and i+1)
            ans = expandAndUpdate(s, i, i + 1, ans);
        }  
        return ans;
    }
    private String expandAndUpdate(String s, int l, int r, String ans) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // If current palindrome is longer, update ans
            if (r - l + 1 > ans.length()) {
                ans = s.substring(l, r + 1);
            }
            l--;
            r++;
        }
        return ans;
    }
}