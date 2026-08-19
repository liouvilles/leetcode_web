class Solution {
    public int findKOr(int[] nums,int k){
        int answer=0;
        for(int bit=0;bit<31;bit++){
            int count=0,mask=1<<bit;
            for(int value:nums)if((value&mask)!=0)count++;
            if(count>=k)answer|=mask;
        }
        return answer;
    }
}
