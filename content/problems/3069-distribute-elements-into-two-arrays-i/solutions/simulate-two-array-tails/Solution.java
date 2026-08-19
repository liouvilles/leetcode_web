class Solution {
    public int[] resultArray(int[] nums){
        int n=nums.length;
        int[] first=new int[n],second=new int[n];
        int firstSize=1,secondSize=1;
        first[0]=nums[0];second[0]=nums[1];
        for(int index=2;index<n;index++){
            if(first[firstSize-1]>second[secondSize-1])first[firstSize++]=nums[index];
            else second[secondSize++]=nums[index];
        }
        int[] answer=new int[n];
        System.arraycopy(first,0,answer,0,firstSize);
        System.arraycopy(second,0,answer,firstSize,secondSize);
        return answer;
    }
}
