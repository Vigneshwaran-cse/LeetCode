class Solution {
    public boolean repeatedSubstringPattern(String s) {
       int length = s.length();
       int upto = (int) Math.ceil(Math.sqrt(length));
       for(int i = 1; i <= upto; ++i){
        if(length%i == 0){
            if(i != length && check(s, s.substring(0, i)))
                return true;
            int j = length/i;
            if(j != 1 && j != length && check(s, s.substring(0, j)))
                return true;
        }
       }
       return false;
    }
    public boolean check(String s, String subString){
        return s.endsWith(subString) && subString.repeat(s.length()/subString.length()).equals(s);
    }
}