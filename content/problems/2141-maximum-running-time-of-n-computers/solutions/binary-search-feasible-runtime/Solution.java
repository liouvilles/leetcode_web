class Solution {
    public long maxRunTime(int n,int[] batteries){
        long right=0;
        for(int battery:batteries)right+=battery;
        right/=n;
        long left=0;
        while(left<right){
            long middle=(left+right+1)/2,available=0;
            for(int battery:batteries)available+=Math.min((long)battery,middle);
            if(available>=middle*n)left=middle;
            else right=middle-1;
        }
        return left;
    }
}
