class Solution {
    public: int findKthPositive(vector<int>& arr,int k){
        int left=0,right=arr.size();
        while(left<right){
            int middle=left+(right-left)/2;
            if(arr[middle]-middle-1<k)left=middle+1;
            else right=middle;
        }
        return left+k;
    }
};
