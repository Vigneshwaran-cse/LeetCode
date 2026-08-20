class Solution {
    public int heightChecker(int[] heights) {
        int[] ex=new int[heights.length];
        int count=0;
        for(int i=0;i<heights.length;i++){
            ex[i]=heights[i];
        }
        
        
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights.length-i-1;j++){
                if(heights[j]>heights[j+1])
                {
                    int temp=heights[j];
                    heights[j]=heights[j+1];
                    heights[j+1]=temp;
                }
            }
        }
        for(int p=0;p<heights.length;p++)
        {
            if(heights[p]!=ex[p])
            {
                count++;
            }
        }
        return count;
    }
}