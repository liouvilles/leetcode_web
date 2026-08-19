class Solution {
    public: vector<int> prevPermOpt1(vector<int>& arr){
        int i=arr.size()-2;
        while(i>=0&&arr[i]<=arr[i+1])--i;
        if(i<0)return arr;
        int j=arr.size()-1;
        while(arr[j]>=arr[i])--j;
        while(j>i+1&&arr[j-1]==arr[j])--j;
        swap(arr[i],arr[j]);
        return arr;
    }
};
