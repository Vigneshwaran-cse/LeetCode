class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder largeNumber = new StringBuilder();
        String[] numbers = new String[nums.length];
        for (int i =0;i<nums.length;i++){
            numbers[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numbers, (a,b) -> (b+a).compareTo(a+b));
        if (numbers[0].equals("0")) {
            return "0";
        }
        for(String s : numbers){
            largeNumber.append(s);
        }
    return largeNumber.toString();
    }
}