class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // Check if s exists in doubled string excluding first and last char
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}
