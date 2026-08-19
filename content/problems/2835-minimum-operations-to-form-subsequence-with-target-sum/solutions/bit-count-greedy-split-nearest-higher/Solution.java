class Solution {
    public int minOperations(List<Integer> nums,int target){
        long total=0;
        long[] count=new long[32];
        for(int value:nums){
            total+=value;
            count[Integer.numberOfTrailingZeros(value)]++;
        }
        if(total<target)return -1;
        int operations=0;
        for(int bit=0;bit<=30;bit++){
            if(((target>>bit)&1)==1){
                if(count[bit]==0){
                    int higher=bit+1;
                    while(higher<32&&count[higher]==0)higher++;
                    while(higher>bit){
                        count[higher]--;
                        count[higher-1]+=2;
                        higher--;
                        operations++;
                    }
                }
                count[bit]--;
            }
            count[bit+1]+=count[bit]/2;
        }
        return operations;
    }
}
