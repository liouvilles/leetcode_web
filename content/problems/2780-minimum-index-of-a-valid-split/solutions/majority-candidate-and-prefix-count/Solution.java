class Solution {
    public int minimumIndex(List<Integer> nums){
        int candidate=0,balance=0;
        for(int value:nums){
            if(balance==0)candidate=value;
            balance+=value==candidate?1:-1;
        }
        int total=0;
        for(int value:nums)if(value==candidate)total++;
        int prefix=0,n=nums.size();
        for(int i=0;i<n-1;i++){
            if(nums.get(i)==candidate)prefix++;
            if(prefix*2>i+1&&(total-prefix)*2>n-i-1)return i;
        }
        return -1;
    }
}
