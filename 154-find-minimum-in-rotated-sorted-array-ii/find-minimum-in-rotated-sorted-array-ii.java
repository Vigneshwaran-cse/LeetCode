class Solution {
    public int findMin(int[] nums) {
        int Min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            Min=Math.min(Min,nums[i]);
        }
        return Min;
    }
}