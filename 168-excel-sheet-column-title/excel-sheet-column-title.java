class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; // adjust because Excel columns are 1-based
            int digit = columnNumber % 26;
            sb.append((char) ('A' + digit));
            columnNumber /= 26;
        }
        
        return sb.reverse().toString();
    }
}
