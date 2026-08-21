class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int p1=0;
        for(int num:arr2)
        {
            for(int p2=p1;p2<arr1.length;p2++)
            {
                if(arr1[p2]==num)
                {
                    int temp = arr1[p1];
                    arr1[p1] = arr1[p2];
                    arr1[p2] = temp;

                    p1++;
                }
            }
        }
        Arrays.sort(arr1,p1,arr1.length);
        return arr1;
    }
}