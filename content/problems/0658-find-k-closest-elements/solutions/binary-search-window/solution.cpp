class Solution {
    public: vector<int> findClosestElements(vector<int>& arr,int k,int x){
        int left=0,right=arr.size()-k;
        while(left<right){
            int middle=left+(right-left)/2;
            if(x-arr[middle]>arr[middle+k]-x)left=middle+1;
            else right=middle;
        }
        return vector<int>(arr.begin()+left,arr.begin()+left+k);
    }
};
