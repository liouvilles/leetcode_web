class Solution {
    long long sum(vector<int>& arr,int cap){
        long long total=0;
        for(int value:arr)total+=min(value,cap);
        return total;
    }
    public:int findBestValue(vector<int>& arr,int target){
        int left=0,right=*max_element(arr.begin(),arr.end());
        while(left<right){
            int middle=(left+right)/2;
            if(sum(arr,middle)>=target)right=middle;
            else left=middle+1;
        }
        int lower=max(0,left-1);
        return llabs(sum(arr,lower)-target)<=llabs(sum(arr,left)-target)?lower:left;
    }
};
