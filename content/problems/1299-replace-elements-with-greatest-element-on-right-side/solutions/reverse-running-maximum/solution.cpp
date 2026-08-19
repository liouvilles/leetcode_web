class Solution {
    public: vector<int> replaceElements(vector<int>& arr){
        int maximum=-1;
        for(int i=arr.size()-1;i>=0;--i){
            int original=arr[i];
            arr[i]=maximum;
            maximum=max(maximum,original);
        }
        return arr;
    }
};
