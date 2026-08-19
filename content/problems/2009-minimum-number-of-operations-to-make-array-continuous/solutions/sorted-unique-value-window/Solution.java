class Solution {
    public int minOperations(int[] nums){
        int n=nums.length;
        Arrays.sort(nums);
        int[] unique=new int[n];
        int size=0;
        for(int value:nums)if(size==0||unique[size-1]!=value)unique[size++]=value;
        int left=0,maximum=0;
        for(int right=0;right<size;right++){
            while(unique[right]>=unique[left]+n)left++;
            maximum=Math.max(maximum,right-left+1);
        }
        return n-maximum;
    }
}
